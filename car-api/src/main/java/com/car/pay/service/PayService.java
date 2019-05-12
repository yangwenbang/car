package com.car.pay.service;

import java.util.SortedMap;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface PayService {
	
	/* @param orderId   公司业务订单号
    * @param price     价格
    * @param body      主题信息
    * @param ipAddress 客户端APP IP 地址
    * @return 返回的信息直接发给客户端即可
    * @throws IOException
    */
	default String createAliOrder(String notifyUrl, String orderNo, String coin, String body, String ipAddress) throws Exception {
		return null;
	}
	
//	default Map<String, String> createWeChatOrder(String notifyUrl, String orderNo, String coin, String body, String ipAddress) throws Exception {
//		return null;
//	}
	
	default SortedMap<String, Object> createWeChatOrder(String notifyUrl, String orderNo, String coin, String body, String ipAddress) throws Exception {
		return null;
	}
	
	/**
     * 服务器调用该请求，进行数据异步传回作用
     *
     * @param request
     * @param response
     * @return 一个代表接受成功／失败的 XML 信息（失败原因应该是：签名失败，成功则表示确认收到数据，不需要再发数据到服务器）
     * @throws Exception
     */
    String callBack(HttpServletRequest request, HttpServletResponse response) throws Exception;
    
}
