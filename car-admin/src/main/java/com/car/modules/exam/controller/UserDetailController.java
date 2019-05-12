package com.car.modules.car.controller;

import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.util.Arrays;
import java.util.Date;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.car.common.utils.StringUtil;
import com.car.common.utils.WXUtils;
import com.car.common.utils.picture.PictureTool;
import com.car.common.utils.picture.PictureUtil;
import com.car.common.utils.picture.QrCodeCreateUtil;
import com.car.common.validator.ValidatorUtils;
import com.car.modules.car.entity.OfflineOrganizationEntity;
import com.car.modules.car.entity.UserIntroduceEntity;
import com.car.modules.car.service.OfflineOrganizationService;
import com.car.modules.car.service.UserIntroduceService;
import com.car.modules.sys.entity.SysUserEntity;
import com.car.modules.sys.entity.UserSimpleVo;
import com.car.modules.sys.service.SysUserService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.car.modules.car.entity.UserDetailEntity;
import com.car.modules.car.service.UserDetailService;
import com.car.common.utils.R;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
 * @author lzp
 * @email sunlightcs@gmail.com
 * @date 2019-03-22 15:40:26
 */
@RestController
@RequestMapping("car/userdetail")
public class UserDetailController {
    @Autowired
    private UserDetailService userDetailService;

    @Autowired
    private UserIntroduceService userIntroduceService;

    @Autowired
    private OfflineOrganizationService offlineOrganizationService;

    @Autowired
    private SysUserService sysUserService;

    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    @RequiresPermissions("car:userdetail:info")
    public R info(@PathVariable("id") Long id) {
        UserDetailEntity userDetail = userDetailService.selectById(id);

        return R.ok().put("userDetail", userDetail);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    @RequiresPermissions("car:userdetail:save")
    public R save(@RequestBody UserDetailEntity userDetail) {
        userDetailService.insert(userDetail);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    @RequiresPermissions("car:userdetail:update")
    public R update(@RequestBody UserDetailEntity userDetail) {
        ValidatorUtils.validateEntity(userDetail);
        userDetailService.updateAllColumnById(userDetail);//全部更新

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @RequiresPermissions("car:userdetail:delete")
    public R delete(@RequestBody Long[] ids) {
        userDetailService.deleteBatchIds(Arrays.asList(ids));

        return R.ok();
    }

    public String getServerUrl(HttpServletRequest request) {
        String url = null;
        url = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + request.getContextPath();
        return url;
    }

    @RequestMapping(value = "/bind/get/user")
    public R getUser(HttpServletResponse response, HttpServletRequest request) {
        response.setHeader("Access-Control-Allow-Origin","*");
        response.setHeader("Access-Control-Allow-Methods","POST");
        response.setHeader("Access-Control-Allow-Headers","Access-Control");
        response.setHeader("Allow","POST");
        String userCode = request.getParameter("usercode");
        SysUserEntity user = sysUserService.selectById(Long.valueOf(userCode));
        if (user != null) {
            UserSimpleVo vo = new UserSimpleVo();
            vo.setMobile(user.getMobile());
            vo.setUserName(user.getUsername());
            return R.ok().put("user", vo);
        }
        return R.error("获取关联人员失败");
    }

    @RequestMapping(value = "/bind/get/organization")
    public R getOrganizationInfo(HttpServletResponse response, HttpServletRequest request) {
        response.setHeader("Access-Control-Allow-Origin","*");
        response.setHeader("Access-Control-Allow-Methods","POST");
        response.setHeader("Access-Control-Allow-Headers","Access-Control");
        response.setHeader("Allow","POST");
        String organizationCode = request.getParameter("orcode");
        OfflineOrganizationEntity offlineOrganizationEntity = offlineOrganizationService.selectOne(new EntityWrapper<OfflineOrganizationEntity>().eq("organization_code", organizationCode));
        if (offlineOrganizationEntity != null) {
            return R.ok().put("organ", offlineOrganizationEntity);
        }
        return R.error("获取机构信息失败");
    }

    @RequestMapping(value = "/bind/user")
    public void bindUser(HttpServletResponse response, HttpServletRequest request) throws Exception {
        String code = request.getParameter("code");
        if (StringUtil.hasValue(code)) {
            String openid = WXUtils.queueInfo(code);
//            String openid = request.getParameter("openid");
            String userCode = request.getParameter("usercode");
            String organizationCode = request.getParameter("orcode");
            String url="http://www.jxjsykt.com/help/wxhelp.html";
            if (StringUtil.hasValue(openid)) {
                if (StringUtil.hasValue(openid)) {
                    UserIntroduceEntity userIntroduceEntity = new UserIntroduceEntity();
                    userIntroduceEntity.setOpenid(openid);
                    if (StringUtil.hasValue(userCode)) {
                        userIntroduceEntity.setUserId(Long.valueOf(userCode));
                        url+="?usercode="+userCode;
                    }
                    if (StringUtil.hasValue(organizationCode)) {
                        OfflineOrganizationEntity offlineOrganizationEntity = offlineOrganizationService.selectOne(new EntityWrapper<OfflineOrganizationEntity>().eq("organization_code", organizationCode));
                        if (offlineOrganizationEntity != null) {
                            userIntroduceEntity.setOrganizationCode(organizationCode);
                            userIntroduceEntity.setOfflineOrganizationId(offlineOrganizationEntity.getId());
                            userIntroduceEntity.setOrganizationName(offlineOrganizationEntity.getOrganizationName());
                            userIntroduceEntity.setOrganizationPicture(offlineOrganizationEntity.getOrganizationPicture());
                            url+="?orcode="+organizationCode;
                        } else {
                            return;
                        }
                    }
                    long count = userIntroduceService.selectCount(new EntityWrapper<UserIntroduceEntity>().eq("openid", openid));
                    if (count == 0) {
                        userIntroduceEntity.setConfirmDate(new Date());
                        userIntroduceService.insert(userIntroduceEntity);
                    }
                }
            }

            response.sendRedirect(url);
        }
    }
}
