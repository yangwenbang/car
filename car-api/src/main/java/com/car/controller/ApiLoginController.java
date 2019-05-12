package com.car.controller;


import static com.car.ApiConstants.DATA;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.car.annotation.Login;
import com.car.common.utils.R;
import com.car.dto.ProjectCategoryDTO;
import com.car.exception.DAOException;
import com.car.form.LoginForm;
import com.car.form.UserProjectForm;
import com.car.redis.ParamSetRedis;
import com.car.service.ParamSetService;
import com.car.service.ProjectService;
import com.car.service.TokenService;
import com.car.service.UserProjectService;
import com.car.service.UserService;
import com.car.utils.WeChatLoginUtils;
import com.car.vo.ParamSetVO;
import com.car.vo.UserVO;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/**
 * 登录接口
 *
 * @author wind
 */
@RestController
@RequestMapping("/api")
@Api(tags="登录接口")
public class ApiLoginController {
	private static final Logger log = LoggerFactory.getLogger(ApiLoginController.class);

    @Autowired
    private UserService userService;
    @Autowired
    private TokenService tokenService;
    @Autowired 
    private ProjectService projectService;
    @Autowired
    private UserProjectService userProjectService;
    @Autowired
    private ParamSetService paramSetService;
    @Autowired
    private ParamSetRedis paramSetRedis;
    
    @GetMapping("verficationCode")
    public R verficationCode(@RequestParam("mobile") String mobile) {
    	String verficationCode = "123456";
		
		return R.ok().put(DATA, verficationCode);
    }
    
    @PostMapping("login")
    @ApiOperation("用户登录接口")
    public R weChatLogin(@ModelAttribute LoginForm form){

        //用户登录
        UserVO user = null;
		try {
			user = userService.weChatLogin(form);
		} catch (Exception e) {
			log.error("login occur error ", e);
			return R.error();
		}

        return R.ok().put(DATA, user);
    }
    
    @GetMapping("paramSet")
    public R getParamSet() {
    	ParamSetVO paramSet = new ParamSetVO();
		try {
			paramSet = paramSetRedis.getParamSet(paramSetService);
		} catch (Exception e) {
			log.error("get paramSet occur errors . ", e);
			return R.error();
		}
		
        return R.ok().put(DATA, paramSet);
    }
    
    @GetMapping("accessToken")
    public R getAccessToken(@RequestParam("code") String code){
    	Map<String, Object> resultMap = new HashMap<>(4);
		try {
			resultMap = WeChatLoginUtils.getAccessToken(code);
		} catch (Exception e) {
			log.error("get accessToken occur errors . ", e);
			return R.error();
		}
		
        return R.ok().put(DATA, resultMap);
    }
    
    @Login
    @GetMapping("projectCategorys")
    public R getProjectCategorys(){
    	List<ProjectCategoryDTO> projectCategorys = new ArrayList<>();
		try {
			projectCategorys = projectService.getProjectCategorys();
		} catch (DAOException e) {
			log.error("get projectCategorys occur error ", e);
		}
		
        return R.ok().put(DATA, projectCategorys);
    }
    
    @Login
    @PostMapping("saveUserProject")
    public R saveUserProject(@ModelAttribute UserProjectForm userProjectForm){

        //保存用户项目分类
		try {
			userProjectService.saveUserProject(userProjectForm);
		} catch (DAOException e) {
			log.error("saveUserProject occur errors. ", e);
			return R.error();
		}

        return R.ok();
    }

    @Login
    @PostMapping("logout")
    public R logout(@RequestAttribute("userId") long userId){
        tokenService.expireToken(userId);
        return R.ok();
    }

}
