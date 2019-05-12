package com.car.controller;


import static com.car.ApiConstants.DATA;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.car.annotation.Login;
import com.car.common.utils.R;
import com.car.exception.DAOException;
import com.car.service.LiveCourseService;
import com.car.vo.LiveCourseVO;

/**
 * 直播
 *
 * @author wind
 */
@RestController
@RequestMapping("/api/live")
//@Api(tags="登录接口")
public class ApiLiveController {
	private static final Logger log = LoggerFactory.getLogger(ApiLiveController.class);

    @Autowired
    private LiveCourseService liveCourseService;
    
    @Login
    @GetMapping("allLiveCourses")
	public R getSubjectCourses(@RequestParam("userId") long userId) throws DAOException {
    	
    	if (userId == 0) {
    		throw new DAOException("userId or projectId or categoryId is null");
    	}
    	
    	List<LiveCourseVO> liveCourses = new ArrayList<>();
    	try {
    		
    		liveCourses = liveCourseService.getLiveCoursesByUser(userId);
    		
    	} catch (DAOException e) {
    		log.error("get liveCourses occur errors . ", e);
    		return R.error();
    	}
		
    	return R.ok().put(DATA, liveCourses);
    }
    
    
    
}
