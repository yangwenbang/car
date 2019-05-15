package com.car.controller;


import static com.car.ApiConstants.DATA;

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
import com.car.dto.HomePageInfoDTO;
import com.car.exception.DAOException;
import com.car.service.AdvertisementService;
import com.car.vo.AdvertisementVO;

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
    	
    	} catch (DAOException e) {
    		log.error("get HomePageInfoDTO occur errors . ", e);
    		R.error();
    	}
    	
		return R.ok().put(DATA, pageInfo);
    }
    
   
    
}
