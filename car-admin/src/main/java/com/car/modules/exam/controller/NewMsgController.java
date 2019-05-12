package com.car.modules.car.controller;

import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Map;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.car.common.utils.*;
import com.car.common.validator.ValidatorUtils;
import com.car.modules.car.entity.MsgTypeEntity;
import com.car.modules.car.entity.vo.IdVo;
import com.car.modules.car.service.MsgTypeService;
import com.car.modules.sys.controller.AbstractController;
import com.qiniu.util.Json;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.car.modules.car.entity.NewMsgEntity;
import com.car.modules.car.service.NewMsgService;
import com.alibaba.fastjson.JSON;

import javax.servlet.http.HttpServletResponse;


/**
 * @author lzp
 * @email sunlightcs@gmail.com
 * @date 2019-03-11 20:54:55
 */
@RestController
@RequestMapping("car/newmsg")
public class NewMsgController extends AbstractController {

    @Value("${execonfig.htmlDir}")
     private String fileDir;

    @Value("${execonfig.htmlTemplate}")
    private String htmlTemplate;

    @Autowired
    private NewMsgService newMsgService;

    @Autowired
    private MsgTypeService msgTypeService;

    /**
     * 列表
     */
    @RequestMapping("/list/condition")
    public R list(@RequestBody String data) {
        PageCondition pageCondition = JsonUtils.readValue(data, PageCondition.class);
        Map<String, Object> params = pageCondition.transferToTargetMap();
        PageUtils page = newMsgService.queryPage(params);
        return R.ok().put("page", page);
    }

    /**
     * 列表
     */
    @RequestMapping("/type/list/condition")
    public R queryTypelist(@RequestBody String data) {
        PageCondition pageCondition = JsonUtils.readValue(data, PageCondition.class);
        Map<String, Object> params = pageCondition.transferToTargetMap();
        PageUtils page = msgTypeService.queryWithProject(params);
        return R.ok().put("page", page);
    }

    /**
     * 列表
     */
    @RequestMapping("/type/all")
    public R queryTypeAll() {
        List<MsgTypeEntity> msgTypeEntities = msgTypeService.selectList(new EntityWrapper<MsgTypeEntity>().eq("effective", 1).orderBy("seq"));
        return R.ok().put("list", msgTypeEntities);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id, HttpServletResponse response) {
        response.setHeader("Access-Control-Allow-Origin","*");
        response.setHeader("Access-Control-Allow-Methods","POST");
        response.setHeader("Access-Control-Allow-Headers","Access-Control");
        response.setHeader("Allow","POST");
        NewMsgEntity newMsg = newMsgService.selectById(id);
        try {
            String filepath = String.format("%s/1000%s.html", fileDir, newMsg.getId());
            String body = FileUtils.readfile(filepath);
            newMsg.setMsgContent(FileUtils.getBody(body).getContent());
        }
        catch (Exception ex){
            ex.printStackTrace();
        }
        return R.ok().put("newMsg", newMsg);
    }


    /**
     * 信息
     */
    @RequestMapping("/type/info/{id}")
    public R typeInfo(@PathVariable("id") Long id) {
        MsgTypeEntity typeEntity = msgTypeService.selectById(id);
        return R.ok().put("msgType", typeEntity);
    }


    /**
     * 保存(新增或修改)
     */
    @RequestMapping("/save")
    public R save(@RequestBody String data) {
        NewMsgEntity newMsgEntity = JSON.parseObject(data, NewMsgEntity.class);
        ValidatorUtils.validateEntity(newMsgEntity);
        if (newMsgEntity.getId() == null || newMsgEntity.getId() == 0) {
            newMsgEntity.setPublishUsername(getUser().getUsername());
            newMsgEntity.setPublishDate(new Date());
            newMsgEntity.setCreateDate(new Date());
            newMsgEntity.setEffective(1);
            newMsgService.insert(newMsgEntity);
            String fileName=String.format("1000%d",newMsgEntity.getId());
            FileUtils.makeHtml(htmlTemplate,fileDir,newMsgEntity.getMsgName(),newMsgEntity.getMsgContent(),fileName);
            newMsgEntity.setMsgContent("");
            newMsgEntity.setMsgContentUrl(String.format("http://www.jxjsykt.com/help/%s.html",fileName));
            newMsgService.updateAllColumnById(newMsgEntity);
        } else {

            String fileName=String.format("1000%d",newMsgEntity.getId());
            FileUtils.makeHtml(htmlTemplate,fileDir,newMsgEntity.getMsgName(),newMsgEntity.getMsgContent(),fileName);
            newMsgEntity.setMsgContentUrl(String.format("http://www.jxjsykt.com/help/%s.html",fileName));

            newMsgEntity.setPublishUsername(getUser().getUsername());
            newMsgEntity.setPublishDate(new Date());
            newMsgService.updateAllColumnById(newMsgEntity);//全部更新
        }
        return R.ok();
    }

    /**
     * 保存(新增或修改)
     */
    @RequestMapping("/type/save")
    public R typeSave(@RequestBody String data) {
        MsgTypeEntity typeEntity = JSON.parseObject(data, MsgTypeEntity.class);
        ValidatorUtils.validateEntity(typeEntity);
        if (typeEntity.getId() == null || typeEntity.getId() == 0) {
            typeEntity.setEffective(1);
            typeEntity.setCreateTime(new Date());
            msgTypeService.insert(typeEntity);
        } else {
            typeEntity.setUpdateTime(new Date());
            msgTypeService.updateAllColumnById(typeEntity);//全部更新
        }
        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @RequiresPermissions("car:newmsg:delete")
    public R delete(@RequestBody Long[] ids) {
        newMsgService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/type/delete")
    public R delete(@RequestBody String data) {
        IdVo idVo = JsonUtils.readValue(data, IdVo.class);
        msgTypeService.deleteById(idVo.getId());
        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/tidy/all")
    public R tidyAll() {
        List<NewMsgEntity> msgEntities= newMsgService.selectList(new EntityWrapper<NewMsgEntity>().orderBy("publish_date"));
        for (NewMsgEntity newMsgEntity:msgEntities
             ) {
            String fileName=String.format("1000%d",newMsgEntity.getId());
            FileUtils.makeHtml(htmlTemplate,fileDir,newMsgEntity.getMsgName(),newMsgEntity.getMsgContent(),fileName);
//            newMsgEntity.setMsgContentUrl(String.format("http://www.jxjsykt.com/help/%s.html",fileName));
            System.out.println("has create file:"+fileName+".html");
        }


        return R.ok();
    }




}
