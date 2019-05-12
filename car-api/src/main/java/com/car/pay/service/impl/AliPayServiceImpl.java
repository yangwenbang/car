package com.car.pay.service.impl;

import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.alipay.api.internal.util.AlipaySignature;
import com.baomidou.mybatisplus.toolkit.StringUtils;
import com.car.common.utils.DateUtils;
import com.car.pay.alipay.AlipayConfig;
import com.car.pay.alipay.AlipayUtils;
import com.car.pay.alipay.OrderInfoUtil2_0;
import com.car.pay.service.PayService;
import com.car.service.PayRecordService;

import net.sf.json.JSONObject;

//@Service("aliPayService")
public class AliPayServiceImpl implements PayService {
	
	private static final Logger log = LoggerFactory.getLogger(AliPayServiceImpl.class);
	
	@Autowired
	private PayRecordService payRecordService;

	@Override
	public String createAliOrder(String notifyUrl, String orderNo, String coin, String body, String ipAddress)
			throws Exception {
		
		Map<String, String> params = OrderInfoUtil2_0.buildOrderParamMap(AlipayConfig.APP_ID, true);
		String orderParam = OrderInfoUtil2_0.buildOrderParam(params);

		String sign = OrderInfoUtil2_0.getSign(params, AlipayConfig.PRIVATE_KEY, true);
		String data = orderParam + "&" + sign;
		
		///////////////////////////////////////////
//		String nowTime = DateUtils.getDate();       //当前时间
//        //公共参数:
//        Map<String, String> publicParam = new HashMap<String, String>();
//        publicParam.put("app_id", AlipayConfig.APP_ID);      //支付宝分配给开发者的应用ID
//        publicParam.put("method", "alipay.trade.app.pay");   // 接口名称 
//        publicParam.put("charset", AlipayConfig.CHARSET);
//        publicParam.put("sign_type", AlipayConfig.SIGN_TYPE); //商户生成签名字符串所使用的签名算法类型，目前支持RSA2和RSA，推荐使用RSA2
//        publicParam.put("timestamp", nowTime);
//        publicParam.put("version", "1.0");  //调用的接口版本，固定为：1.0
//        publicParam.put("notify_url", notifyUrl);//支付宝服务器主动通知商户服务器里指定的页面http/https路径。建议商户使用https
//        //业务参数:
//        Map<String, String> payParam = new HashMap<String, String>();
//        payParam.put("body", "测试");       //对一笔交易的具体描述信息
//        payParam.put("subject", "学币购买"); //商品的标题/交易标题/订单标题/订单关键字等。
//        payParam.put("out_trade_no", orderNo);    //商户网站唯一订单号
//        payParam.put("timeout_express", "30m");   //该笔订单允许的最晚付款时间，逾期将关闭交易
//        payParam.put("total_amount", coin);//订单总金额，单位为元，精确到小数点后两位
//        payParam.put("product_code", "QUICK_MSECURITY_PAY");//销售产品码，商家和支付宝签约的产品码，为固定值QUICK_MSECURITY_PAY
//        
//        JSONObject bizcontentJson= JSONObject.fromObject(payParam);
//        log.debug("支付宝业务参数=="+bizcontentJson);
//        
//        //业务请求参数的集合，最大长度不限，除公共参数外所有请求参数都必须放在这个参数中传递，具体参照各产品快速接入文档
//        publicParam.put("biz_content", bizcontentJson.toString());
//        log.debug("支付宝请求参数=="+publicParam);
//        
//        // build
//        String orderParam = AlipayUtils.buildOrderParam(publicParam);
//        
//        // sign
//        String sign = AlipayUtils.rsaSign(publicParam);
//        String data = orderParam + "&" + URLEncoder.encode(sign, "UTF-8");
        
        ///////////////////////////////////////////////////
        
        /*//RSA签名
        String rsaSign = AlipayUtils.rsaSign(publicParam);
        log.debug("支付宝签名参数=="+rsaSign);
        
        Map<String, String> codeParam = new HashMap<String, String>();
        codeParam.put("app_id", AlipayConfig.APP_ID);
        codeParam.put("method", "alipay.trade.app.pay");
        codeParam.put("charset", AlipayConfig.CHARSET);
        codeParam.put("sign_type", AlipayConfig.SIGN_TYPE);
        codeParam.put("timestamp", URLEncoder.encode(nowTime,"UTF-8"));
        codeParam.put("version", "1.0");
        codeParam.put("notify_url",  URLEncoder.encode(notifyUrl,"UTF-8"));  //通知接口
        
        //最后对请求字符串的所有一级value（biz_content作为一个value）进行encode，编码格式按请求串中的charset为准，没传charset按UTF-8处理
        codeParam.put("biz_content", URLEncoder.encode(bizcontentJson.toString(), "UTF-8"));
        String data = AlipaySignature.getSignContent(codeParam);   //拼接后的字符串
        data = data + "&sign=" + URLEncoder.encode(rsaSign, "UTF-8");*/
        log.debug("支付宝支付参数=="+data);
        return data;
	}

	@Override
	public String callBack(HttpServletRequest request, HttpServletResponse response) throws Exception {
		log.info("==========  callBack      ==========");
        //获取支付宝POST过来反馈信息
        Map<String,String> receiveMap = getReceiveMap(request);
        log.info("支付宝支付回调参数=="+receiveMap);
        // 获取支付宝的通知返回参数,可参考技术文档中页面跳转同步通知参数列表(以下仅供参考)
        // 1,判断是否有异步通知
        if(StringUtils.isEmpty(receiveMap.get("notify_id"))){
            log.info("支付宝支付回调没有异步通知 fail1");
            return "no notify message";
        }
        //2,判断是否是支付宝发来的异步通知
        if(!AlipayUtils.verifyResponse(receiveMap.get("notify_id")).equals("true")){  
            log.info("支付宝支付回调通知错误 fail2");
            return "response failure";
        }
        //3,判断是否是支付宝发来的异步通知
//        if(!AlipayUtils.rsaCheck(receiveMap)){
//            log.info("支付宝支付回调验证签名失败 fail3");
//            return "sign failure";
//        }
        log.info("---success-----");
        //4,判断交易状态
        String tradeStatus = receiveMap.get("trade_status");
        if ("TRADE_FINISHED".equals(tradeStatus) || "TRADE_SUCCESS".equals(tradeStatus)){
            log.info("支付宝支付回调签名解码=="+URLDecoder.decode(receiveMap.get("sign"),"UTF-8"));
            String orderNo = receiveMap.get("out_trade_no");    // 商户订单号
            log.info("支付宝支付回调商户订单号orderNo=="+orderNo);
            //订单业务操作: payrecord user_coin
            payRecordService.saveBuyInfo(orderNo);
            
            return "success";
        }
        log.info("支付宝支付回调失败");
        return "failure";
	}
	
	/**
     *<p>方法说明: 获取请求参数
     *<p>返回说明: Map<String,String> receiveMap
     *<p>创建时间: 2017年11月3日 下午2:25:02
     *<p>创  建  人: geYang
     **/
    private static Map<String,String> getReceiveMap(HttpServletRequest request){
        Map<String,String> receiveMap = new HashMap<String,String>();
        Map<String, String[]> requestParams = request.getParameterMap();
        for (Iterator<String> iter = requestParams.keySet().iterator(); iter.hasNext();) {
            String name = iter.next();
            String[] values = requestParams.get(name);
            String valueStr = "";
            for (int i = 0; i < values.length; i++) {
                valueStr = (i == values.length - 1) ? valueStr + values[i]
                            : valueStr + values[i] + ",";
            }
            //乱码解决，这段代码在出现乱码时使用
            //valueStr = new String(valueStr.getBytes("ISO-8859-1"), "UTF-8");
            receiveMap.put(name, valueStr);
        }
        return receiveMap;
    }


}
