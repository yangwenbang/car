package com.car.controller;


import static com.car.ApiConstants.ZERO;

import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.SortedMap;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.aliyuncs.exceptions.ClientException;
import com.aliyuncs.exceptions.ServerException;
import com.car.annotation.Login;
import com.car.dto.CommodityQuestionDTO;
import com.car.entity.PayRecord;
import com.car.exception.DAOException;
import com.car.form.CommodityQuestionFrom;
import com.car.form.OldCommodityForm;
import com.car.form.PayForm;
import com.car.form.PublishPostForm;
import com.car.form.UpdateOldCommodityForm;
import com.car.pay.alipay.AlipayUtils;
import com.car.pay.service.PayService;
import com.car.pay.service.impl.AliPayServiceImpl;
import com.car.pay.service.impl.WeChatPayServiceImpl;
import com.car.pay.wxpay.WeChatPayUtils;
import com.car.service.CommodityCategoryService;
import com.car.service.CommodityQuestionService;
import com.car.service.CommodityService;
import com.car.service.PayRecordService;
import com.car.service.PublishPostService;
import com.car.service.QualityShopService;
import com.car.service.UserService;
import com.car.utils.Result;
import com.car.utils.STSUtils;
import com.car.vo.CommodityCategoryVO;
import com.car.vo.CommodityVO;
import com.car.vo.QualityShopVO;
import com.car.vo.UserVO;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

/**
 * 发布接口
 *
 * @author wind
 */
@RestController
@RequestMapping("/api/oldCommodity")
@Api(tags="二手商品接口")
public class ApiOldCommodityController {
	private static final Logger log = LoggerFactory.getLogger(ApiOldCommodityController.class);
	
	private static final int ZERO = 0;
	private static final String SUCCESS = "success";

	@Autowired
	private CommodityService commodityService;
	@Autowired
	private CommodityCategoryService commodityCategoryService;
	@Autowired
	private PublishPostService publishPostService;
	@Autowired
	private CommodityQuestionService commodityQuestionService;
	@Autowired
	private QualityShopService qualityShopService;
	@Autowired
    private PayRecordService payRecordService;
	@Autowired
    private UserService userService;
	
	@Login
	@GetMapping("/getQualityShops")
	@ApiOperation("获取质检商家接口")
	public Result<List<QualityShopVO>> getQualityShops(@ApiParam(value = "分页ID(从0开始)")@RequestParam("pageId") int pageId){
		List<QualityShopVO> qualityShopVOList = new ArrayList<>();
		try {
			qualityShopVOList = qualityShopService.getQualityShops(pageId);
		} catch (DAOException e) {
			log.error("get QualityShopVO occur errors .", e);
			return new Result<>(500, e.getMessage());
		}
		return new Result<>(ZERO, SUCCESS, qualityShopVOList);
	}
	
	/**
	 * 保存商品
	 */
	@Login
	@PostMapping("/publishCommodity")
	@ApiOperation("发布商品")
	public Result<String> saveCommodity(@ModelAttribute OldCommodityForm oldCommodity) {
		if(oldCommodity.getCommodityName() == null){
			return new Result<>(500, "商品名称为空");
		}
		
		if(oldCommodity.getCommodityCategoryId() == null){
			return new Result<>(500, "商品分类ID不能为空");
		}
		
		try {
			commodityService.insertCommodity(oldCommodity);
		} catch (DAOException e) {
			log.error("insert oldCommodity occur errors .", e);
			return new Result<>(500, e.getMessage());
		}
		return new Result<>(ZERO, SUCCESS);
	}

	@GetMapping("/getCommodityCategorys")
	@ApiOperation("获取商品分类接口")
	public Result<List<CommodityCategoryVO>> getCommodityCategory(){
		List<CommodityCategoryVO> commodityCategoryList = new ArrayList<>();
		try {
			commodityCategoryList = commodityCategoryService.queryCommodityCategorys();
		} catch (DAOException e) {
			log.error("get CommodityCategoryVO occur errors .", e);
			return new Result<>(500);
		}
		return new Result<>(ZERO, SUCCESS,commodityCategoryList);
	}

	/**
	 * 发布帖子
	 */
	@Login
	@PostMapping("/savePublishPost")
	@ApiOperation("发布帖子接口")
	public Result<String> savePublishPost(@ModelAttribute PublishPostForm publishPost) throws DAOException {
		if(publishPost.getPublishTitle() == null){
			throw new DAOException("帖子标题为空");
		}
		if(publishPost.getPublishContent() == null){
			throw new DAOException("帖子内容为空");
		}
		if(publishPost.getPublishUserId() == null){
			throw new DAOException("帖子用户为空");
		}
		publishPostService.insertPublishPost(publishPost);
		return new Result<>(ZERO, SUCCESS);
	}

	@GetMapping("/getCommoditysByCategorys")
	@ApiOperation("获取二手商品")
	public Result<List<CommodityVO>> getCommoditysByCategoryId(@ApiParam(value = "商品分类ID(推荐默认为0)")@RequestParam("commodityCategoryId") long commodityCategoryId,
			@ApiParam(value = "分页ID(从0开始)")@RequestParam("pageId") int pageId) {
		List<CommodityVO> commodityList = new ArrayList<>();
		try {
			commodityList = commodityService.queryCommoditysByCategoryId(commodityCategoryId, pageId);
		} catch (DAOException e) {
			log.error("get CommodityCategoryVO occur errors .", e);
			return new Result<>(500);
		}
		return new Result<>(0, SUCCESS,commodityList);
	}

	@Login
	@GetMapping("/getCommodityQuestions")
	@ApiOperation("获取问答接口")
	public Result<List<CommodityQuestionDTO>> getCommodityQuestionsByTypeId(@ApiParam(value = "问题类型ID(商品ID/帖子ID)") @RequestParam("questionTypeId") long questionTypeId,
		@ApiParam(value = "提问类型(0商品/1帖子)") @RequestParam("questionType") Integer questionType) {
		List<CommodityQuestionDTO> commodityQuestionList = null;
		try {
			commodityQuestionList = commodityQuestionService.queryCommodityQuestionsByTypeId(questionTypeId,questionType);
		} catch (DAOException e) {
			log.error("get CommodityQuestionDTO occur errors .", e);
			return new Result<>(500, e.getMessage());
		}
		return new Result<>(0, SUCCESS, commodityQuestionList);
	}

	/**
	 * 发布商品问答接口
	 * 仅做了商品回复权限校验
	 */
	@Login
	@PostMapping("/saveCommodityQuestion")
	@ApiOperation("发布商品问答接口")
	public Result<String> saveCommodityQuestion(@ModelAttribute CommodityQuestionFrom commodityQuestionFrom ) throws DAOException {
		Long userId;
		if (commodityQuestionFrom.getReplayStatus().equals(1)){
			if (commodityQuestionFrom.getQuestionType() == 0) {
				userId = commodityQuestionService.getUserIdByCommodityId(commodityQuestionFrom.getQuestionTypeId());
			} else if (commodityQuestionFrom.getQuestionType() == 1) {
				userId = commodityQuestionService.getUserIdByPublishPostId(commodityQuestionFrom.getQuestionTypeId());
			} else {
				return new Result<>(500,"提问类型不符合规范");
			}
			if (userId == null || !userId.equals(commodityQuestionFrom.getUserId())) {
				return new Result<>(500,"你没有回复的权限");
			}
		}
		try {
			commodityQuestionService.insertCommodityQuestion(commodityQuestionFrom);
		} catch (DAOException e) {
			log.error("get CommodityQuestionDTO occur errors .", e);
			return new Result<>(500,e.getMessage());
		}
		return new Result<>(ZERO, SUCCESS);
	}

	@Login
	@DeleteMapping("/deleteOldCommodity")
	@ApiOperation("删除二手商品")
	public Result<String> removeCommodityById(@ApiParam(value = "商品id") Long commodityId,
		@ApiParam(value = "发布商品的用户id") Long userId) throws DAOException {
		Long dbUserId = commodityQuestionService.getUserIdByCommodityId(commodityId);
		if (dbUserId == null || !dbUserId.equals(userId)){
			return new Result(500,"你没有删除权限");
		}
		commodityService.deleteCommodityById(commodityId);
		return new Result<>(ZERO, SUCCESS);
	}

	@Login
	@PutMapping("/updateOldCommodity")
	@ApiOperation("修改二手商品")
	public Result<String> updateCommodityById(@ApiParam(value = "发布商品的用户id") Long userId,
		@ApiParam(value = "修改的字段") UpdateOldCommodityForm commodityForm) {
		Long dbUserId = commodityQuestionService.getUserIdByCommodityId(commodityForm.getCommodityId());
		if (dbUserId == null || !dbUserId.equals(userId)){
			return new Result("你没有修改权限");
		}
		try {
			commodityService.updateCommodityById(commodityForm);
		} catch (DAOException e) {
			log.error("update Commodity occur errors .", e);
			return new Result<>(500,e.getMessage());
		}
		return new Result<>(ZERO, SUCCESS);
	}

	@Login
	@DeleteMapping("/deletePublishPost")
	@ApiOperation("删除帖子")
	public Result<String> removePublishPostById(@ApiParam(value = "帖子id") Long publishPostId,
		@ApiParam(value = "发布帖子用户id") Long userId) throws DAOException {
		Long dbUserId = commodityQuestionService.getUserIdByPublishPostId(publishPostId);
		if (dbUserId == null || !dbUserId.equals(userId)){
			return new Result(500,"你没有删除权限");
		}
		publishPostService.deletePublishPostById(publishPostId);
		return new Result<>(ZERO, SUCCESS);
	}
	
	@GetMapping("/getSTSInfos")
	@ApiOperation("获取OSS的STS授权信息")
	public Result<Map<String, String>> getSTSInfos(){
		
		Map<String, String> stsMap = new LinkedHashMap<String, String>();
		try {
			stsMap = STSUtils.getSTSInfos();
		} catch (ServerException e) {
			log.error("get sts occur errors . ", e);
			return new Result<>(500, e.getMessage());
		} catch (ClientException e) {
			log.error("get sts occur errors . ", e);
			return new Result<>(500, e.getMessage());
		}
		
		return new Result<>(ZERO, SUCCESS, stsMap);
	}
	
	@Login
    @PostMapping("pay")
    @ApiOperation("支付接口")
    public Result<String> pay(@ModelAttribute PayForm payForm,
    		HttpServletRequest request) throws Exception {
    	
    	long userId = payForm.getUserId();
    	int payType = payForm.getPayType();
    	String money = payForm.getMoney();
    	
    	if (userId == 0) {
    		throw new DAOException("userId is null");
    	}
    	
    	String data = "";
    	try {
    		String ipAddress = getIpAddress(request);
    		String orderNo = AlipayUtils.getOrderNo();
    		if (payType == 0) { // 支付宝
    			PayService aliPayService = new AliPayServiceImpl();
    			String notifyUrl = AlipayUtils.getNotifyUrl(request);
    			data = aliPayService.createAliOrder(notifyUrl, orderNo, money, "车配件购买", ipAddress);
    			
    			// orderNo错误
    			savePayRecord(userId, payForm.getCommodityId(), payType, orderNo, money);
    			
    			return new Result<>(ZERO, SUCCESS, data);
    		} else if (payType == 1) { // 微信
    			PayService weChatService = new WeChatPayServiceImpl();
    			String notifyUrl = WeChatPayUtils.getNotifyUrl(request);
//    			Map<String, String> dataMap = weChatService.createWeChatOrder(notifyUrl, orderNo, coin, "", ipAddress);
    			SortedMap<String, Object> dataMap = weChatService.createWeChatOrder(notifyUrl, orderNo, money, "车配件购买", ipAddress);
    			
    			savePayRecord(userId, payForm.getCommodityId(), payType, orderNo, money);
    			
//    			return new Result<>(ZERO, SUCCESS, dataMap);
    			return new Result<>(ZERO, SUCCESS);
    		}
				
		} catch (Exception e) {
			log.error("get pay occur error ", e);
			return new Result<>(500, e.getMessage());
		}
		
        return new Result<>(ZERO, SUCCESS);
    }

    @PostMapping("alipayNotify")
    public String alipayNotify(HttpServletRequest request, HttpServletResponse response) {
        try {
        	PayService aliPayService = new AliPayServiceImpl();
            return aliPayService.callBack(request, response);
        } catch (Exception e) {
            response.setHeader("Content-type", "application/xml");
            return "<xml>\n" +
                    "  <return_code><![CDATA[FAIL]]></return_code>\n" +
                    "  <return_msg><![CDATA[]]></return_msg>\n" +
                    "</xml>";
        }
    }
    
    @PostMapping("weChatNotify")
    public String weChatNotify(HttpServletRequest request, HttpServletResponse response) {
        try {
        	PayService weChatService = new WeChatPayServiceImpl();
            return weChatService.callBack(request, response);
        } catch (Exception e) {
            response.setHeader("Content-type", "application/xml");
            return "<xml>\n" +
                    "  <return_code><![CDATA[FAIL]]></return_code>\n" +
                    "  <return_msg><![CDATA[]]></return_msg>\n" +
                    "</xml>";
        }
    }
    
    private void savePayRecord(long userId, long commodityId, int payType, String orderNo, String money)
			throws DAOException {
		// payRecord
		UserVO user = userService.findById(userId);
		PayRecord payRecord = new PayRecord();
		payRecord.setUserId(userId);
		payRecord.setCommodityId(commodityId);
		payRecord.setUserMobile(user.getMobile());
		payRecord.setUserName(user.getUserName());
		payRecord.setCargoType(ZERO);
		payRecord.setPayOrReturn(ZERO);
		payRecord.setPayDate(new Date());
		payRecord.setPayMoney(Double.parseDouble(money));
		payRecord.setPayType(payType);
		payRecord.setBank("");
		payRecord.setCardNum("");
		payRecord.setPayer(user.getUserName());
		payRecord.setOrderNo(orderNo);
		payRecord.setPayStatus(ZERO);
		payRecord.setVersion(ZERO);
		payRecordService.savePayRecord(payRecord);
	}
    
    private static String getIpAddress(HttpServletRequest request) {
		String ip = request.getHeader("x-forwarded-for");
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getHeader("Proxy-Client-IP");
		}
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getHeader("WL-Proxy-Client-IP");
		}
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getHeader("HTTP_CLIENT_IP");
		}
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getHeader("HTTP_X_FORWARDED_FOR");
		}
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getRemoteAddr();
		}
		return ip;
	}
	
}
