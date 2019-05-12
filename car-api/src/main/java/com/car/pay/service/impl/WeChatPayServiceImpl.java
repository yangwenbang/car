package com.car.pay.service.impl;

import java.math.BigDecimal;
import java.util.Date;
import java.util.Map;
import java.util.SortedMap;
import java.util.TreeMap;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.car.common.utils.DateUtils;
import com.car.pay.service.PayService;
import com.car.pay.wxpay.CommonUtil;
import com.car.pay.wxpay.WeChatConfig;
import com.car.pay.wxpay.WeChatPayUtils;
import com.car.service.PayRecordService;

public class WeChatPayServiceImpl implements PayService {
	private static final Logger logger = LoggerFactory.getLogger(WeChatPayServiceImpl.class);
	
	@Autowired
	private PayRecordService payRecordService;
	
	public SortedMap<String, Object> createWeChatOrder(String notifyUrl, String orderNo, String coin, String body, String ipAddress) throws Exception {
 
		TreeMap<String, Object> parameters = new TreeMap<String, Object>();
		parameters.put("appid", WeChatConfig.APPID);
		parameters.put("mch_id", WeChatConfig.MCH_ID);
		parameters.put("nonce_str", CommonUtil.getRandomString(32));
		parameters.put("body", body);
		parameters.put("out_trade_no", orderNo);
		BigDecimal price = new BigDecimal(coin);
		parameters.put("total_fee", price.multiply(BigDecimal.valueOf(100)).intValue());
		parameters.put("spbill_create_ip", ipAddress);
		parameters.put("notify_url", notifyUrl);
		parameters.put("trade_type", "APP");
		String sign = CommonUtil.createSign("UTF-8", parameters);
		parameters.put("sign", sign); // 把签名后的数据组装成参数
		
		String tosend = CommonUtil.getRequestXml(parameters);
		logger.info("微信统一下单请求数据xml:" + tosend);
		SortedMap<String, Object> signParam = new TreeMap<String, Object>();
		try {
			String result = CommonUtil.httpsRequest(WeChatConfig.PLACE_URL, "POST", tosend);
			logger.info("微信统一下单返回数据xml:" + result);
			
			Map<String, String> map = CommonUtil.doXMLParse(result);
			String return_code = map.get("return_code");
            String prepay_id = null;
            if (return_code.equalsIgnoreCase("SUCCESS")) {
            	String result_code = map.get("result_code");
            	if(result_code.equalsIgnoreCase("SUCCESS")){
            		prepay_id = map.get("prepay_id");//获取到prepay_id
            		
                    signParam.put("appid", WeChatConfig.APPID);
                    signParam.put("partnerid", WeChatConfig.MCH_ID);
                    signParam.put("prepayid", prepay_id);
                    signParam.put("package", "Sign=WXPay");
                    signParam.put("noncestr", CommonUtil.getRandomString(32));//自定义不重复的长度不长于32位
                    signParam.put("timestamp", DateUtils.getSecondTimestamp(new Date()));
                    String signAgain =CommonUtil.createSign("UTF-8", signParam);//再次生成签名
                    signParam.put("sign", signAgain);
                    signParam.remove("package");
                    
            	}else{
//            		responseJson = CommonUtil.createResponseJson(
//            				map.get("err_code"), map.get("err_code_des"),
//							null);
            	}
            }else{
//            	responseJson = CommonUtil.createResponseJson(
//            			map.get("return_code"), map.get("return_msg"),
//						null);
            }
		} catch (Exception e) {
			logger.error("createWeChatOrder occur errors . ", e);
		}
 
		return signParam;
	}
	
//	@Override
//	public Map<String, String> createWeChatOrder(String notifyUrl, String orderNo, String coin, String body, String ipAddress)
//			throws IOException {
//		SortedMap<String, Object> parameters = new TreeMap<String, Object>();
//        parameters.put("appid", WeChatConfig.APPID);
//        parameters.put("mch_id", WeChatConfig.MCH_ID);
//        parameters.put("device_info", "WEB"); // 默认 "WEB"
//        parameters.put("body", "ceshi");
//        parameters.put("attach", "Andy");
//        parameters.put("nonce_str", WeChatPayUtils.gen32RandomString()); // 32 位随机字符串
//        parameters.put("notify_url", notifyUrl);
//        parameters.put("out_trade_no", orderNo);
//        BigDecimal price = new BigDecimal(coin);
//        parameters.put("total_fee", price.multiply(BigDecimal.valueOf(100)).intValue());
////        parameters.put("total_fee", 1); // 测试时，将支付金额设置为 1 分钱
//        parameters.put("spbill_create_ip", ipAddress);
//        parameters.put("trade_type", "APP");
//        parameters.put("sign", WeChatPayUtils.createSign(parameters, WeChatConfig.KEY)); // sign 必须在最后
//        String result = WeChatPayUtils.executeHttpPost(WeChatConfig.PLACE_URL, parameters); // 执行 HTTP 请求，获取接收的字符串（一段 XML）
//        Map<String, String> resultMap = WeChatPayUtils.createSign2(result, WeChatConfig.KEY);
//        return resultMap;
//	}

	@Override
	public String callBack(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// 预先设定返回的 response 类型为 xml
        response.setHeader("Content-type", "application/xml");
        // 读取参数，解析Xml为map
        Map<String, String> map = WeChatPayUtils.transferXmlToMap(WeChatPayUtils.readRequest(request));
        // 转换为有序 map，判断签名是否正确
        boolean isSignSuccess = WeChatPayUtils.checkSign(new TreeMap<String, Object>(map), WeChatConfig.KEY);
        if (isSignSuccess) {
            // 签名校验成功，说明是微信服务器发出的数据
            String orderNo = map.get("out_trade_no");

            payRecordService.saveBuyInfo(orderNo);
            
            return success();
        } else {
            // 签名校验失败（可能不是微信服务器发出的数据）
            return fail();
        }
    }

    String fail() {
        return "<xml>\n" +
                "  <return_code><![CDATA[FAIL]]></return_code>\n" +
                "  <return_msg><![CDATA[]]></return_msg>\n" +
                "</xml>";
    }

    String success() {
        return "<xml>\n" +
                "  <return_code><![CDATA[SUCCESS]]></return_code>\n" +
                "  <return_msg><![CDATA[OK]]></return_msg>\n" +
                "</xml>";
    }
}
