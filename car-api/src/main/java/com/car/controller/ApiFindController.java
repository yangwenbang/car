package com.car.controller;


import static com.car.ApiConstants.DATA;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.car.annotation.Login;
import com.car.common.utils.R;
import com.car.dto.HomePageInfoDTO;
import com.car.dto.NewMsgDTO;
import com.car.exception.DAOException;
import com.car.service.AdvertisementService;
import com.car.service.CourseService;
import com.car.service.NewMsgService;
import com.car.vo.AdvertisementVO;
import com.car.vo.CourseVO;
import com.car.vo.NewMsgVO;
import com.car.vo.SubjectAndCourseVO;

/**
 * 登录接口
 *
 * @author wind
 */
@RestController
@RequestMapping("/api/find")
//@Api(tags="登录接口")
public class ApiFindController {
	private static final Logger log = LoggerFactory.getLogger(ApiFindController.class);

    @Autowired
    private AdvertisementService advertisementService;
    @Autowired
    private NewMsgService newMsgService;
    @Autowired
    private CourseService courseService;
    
    @Login
    @GetMapping("homePageInfos")
	public R getHomePageInfo(@RequestParam("userId") long userId,
			@RequestParam("projectId") long projectId, 
			@RequestParam("categoryId") long categoryId) throws DAOException {
    	
    	if (userId == 0 || projectId == 0 || categoryId == 0) {
    		throw new DAOException("project or categoryId is null");
    	}
    	
    	HomePageInfoDTO pageInfo = null;
    	try {
    	// banner
    	List<AdvertisementVO> advertisements = advertisementService.getAdvertisementsByProject(projectId);
    	
    	// 资讯
    	List<NewMsgVO> newMsgs = newMsgService.getLastNewMsgsByProject(projectId);
    	
    	// 热门课程
    	List<CourseVO> bestViedoCourses = courseService.getFamousCoursesByProjectAndCategory(userId, projectId, categoryId, 1, 4);
    	
    	// 热门题库
    	List<CourseVO> bestExercises = courseService.getFamousCoursesByProjectAndCategory(userId, projectId, categoryId, 2, 4);
    	
    	// 公开课程
    	List<CourseVO> bestPublicCourses = courseService.getFamousCoursesByProjectAndCategory(userId, projectId, categoryId, 3, 4);
    	
    	pageInfo = new HomePageInfoDTO(advertisements, newMsgs, bestViedoCourses, bestPublicCourses, bestExercises);
    	} catch (DAOException e) {
    		log.error("get HomePageInfoDTO occur errors . ", e);
    		R.error();
    	}
    	
		return R.ok().put(DATA, pageInfo);
    }
    
    @Login
    @GetMapping("allFamousCourses")
	public R getSubjectCourses(@RequestParam("userId") long userId,
			@RequestParam("projectId") long projectId,
			@RequestParam("categoryId") long categoryId,
			@RequestParam("courseType") int courseType) throws DAOException {
    	
    	if (userId == 0 || projectId == 0 || categoryId == 0) {
    		throw new DAOException("userId or projectId or categoryId is null");
    	}
    	
    	List<CourseVO> allFamousCourses = new ArrayList<>();
    	try {
    		
    		allFamousCourses = courseService.getFamousCoursesByProjectAndCategory(userId, projectId, categoryId, courseType, 4);
    		
    	} catch (DAOException e) {
    		log.error("get allFamousCourses occur errors . ", e);
    		return R.error();
    	}
		
    	return R.ok().put(DATA, allFamousCourses);
    }
    
    @Login
    @GetMapping("allNewMsgs")
	public R getAllNewMsgs(@RequestParam("projectId") long projectId) throws DAOException {
    	
    	if (projectId == 0) {
    		throw new DAOException("project is null");
    	}
    	
    	List<NewMsgDTO> msgDTOs = new ArrayList<>();
    	try {
    		
    		List<NewMsgVO> newMsgs = newMsgService.getNewMsgsByProject(projectId);
    		
    		if (CollectionUtils.isEmpty(newMsgs)) {
    			return R.ok();
    		}
    		
    		List<NewMsgVO> msgs = null;
    		Map<String, List<NewMsgVO>> msgMap = new HashMap<>();
    		for (NewMsgVO newMsg : newMsgs) {
    			String key = newMsg.getMsgTypeId() + "_" + newMsg.getMsgTypeName();
    			if (msgMap.containsKey(key)) {
    				msgMap.get(key).add(newMsg);
    			} else {
    				msgs = new ArrayList<>();
    				msgs.add(newMsg);
    				msgMap.put(key, msgs);
    			}
    		}
    		
    		// 组手机端数据
    		NewMsgDTO dto = null;
    		Set<Entry<String, List<NewMsgVO>>> entrySet = msgMap.entrySet();
    		for (Entry<String, List<NewMsgVO>> entry : entrySet) {
    			String[] key = entry.getKey().split("_");
    			long msgTypeId = Long.parseLong(key[0]);
    			String msgTypeName = key[1];
    			msgDTOs.add(new NewMsgDTO(msgTypeId, msgTypeName, entry.getValue()));
    		}
    
    	} catch (DAOException e) {
    		log.error("get msgDTOs occur errors . ", e);
    		R.error();
    	}
    	
		return R.ok().put(DATA, msgDTOs);
    }
    
}
