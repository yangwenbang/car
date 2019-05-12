package com.car.pay.alipay;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Random;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.codec.digest.DigestUtils;
import org.apache.commons.httpclient.methods.multipart.FilePartSource;
import org.apache.commons.httpclient.methods.multipart.PartSource;

import com.alipay.api.AlipayApiException;
import com.alipay.api.internal.util.AlipaySignature;

/**
 *类  说  明: 
 *创建时间: 2019年2月5日 上午9:38:02
 *创  建  人: wind
 **/
public class AlipayUtils {
    
    /**
     *方法说明: 签名验证
     *参数说明: @param params 通知返回来的参数数组
     *参数说明: @param sign   比对的签名结果
     *参数说明: @throws AlipayApiException
     *返回说明: boolean 签名验证结果
     *创建时间: 2019年2月5日 下午2:19:18
     *创  建  人: wind
     **/
    public static boolean rsaCheck(Map<String, String> params) throws AlipayApiException {
        return AlipaySignature.rsaCheckV1(params, AlipayConfig.ALIPAY_PUBLIC_KEY, AlipayConfig.CHARSET, AlipayConfig.SIGN_TYPE);
    }

    /**
     *方法说明: 进行签名
     *参数说明: @param params 需要签名的参数
     *参数说明: @throws AlipayApiException
     *返回说明: String 签名字符串
     *创建时间: 2019年2月5日 下午2:29:01
     *创  建  人: wind
     **/
    public static String rsaSign(Map<String, String> params) throws AlipayApiException {
        String content = AlipaySignature.getSignCheckContentV2(params);
        return SignUtils.sign(content, AlipayConfig.PRIVATE_KEY, true);
//        return AlipaySignature.rsaSign(content, AlipayConfig.PRIVATE_KEY, AlipayConfig.CHARSET, AlipayConfig.SIGN_TYPE);
    }
    
    /**
     *方法说明: 解密
     *参数说明: @param params 密文参数
     *参数说明: @throws AlipayApiException
     *返回说明: String 解密字符串
     *创建时间: 2019年2月5日 下午3:34:02
     *创  建  人: wind
     **/
    public static String rsaDecrypt(Map<String, String> params) throws AlipayApiException{
        return AlipaySignature.checkSignAndDecrypt(params, AlipayConfig.ALIPAY_PUBLIC_KEY, AlipayConfig.PRIVATE_KEY, true, true, AlipayConfig.SIGN_TYPE);
    }
    /**
     * 获取远程服务器ATN结果,验证返回URL
     * 
     * @param notifyId 通知校验ID
     * @return 服务器ATN结果 验证结果集： invalid命令参数不对 出现这个错误，请检测返回处理中partner和key是否为空 true
     *         返回正确信息 false 请检查防火墙或者是服务器阻止端口问题以及验证时间是否超过一分钟
     */
    public static String verifyResponse(String notifyId) {
        // 获取远程服务器ATN结果，验证是否是支付宝服务器发来的请求
        String urlValue = AlipayConfig.HTTPS_VERIFY_URL + "partner=" + AlipayConfig.SELLER_ID + "&notify_id=" + notifyId;
        return checkUrl(urlValue);
    }

    /**
     * 获取远程服务器ATN结果
     * 
     * @param urlValue 指定URL路径地址
     * @return 服务器ATN结果 验证结果集： invalid命令参数不对 出现这个错误，请检测返回处理中partner和key是否为空 true
     *         返回正确信息 false 请检查防火墙或者是服务器阻止端口问题以及验证时间是否超过一分钟
     */
    private static String checkUrl(String urlValue) {
        String inputLine = "";
        try {
            URL url = new URL(urlValue);
            HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
            BufferedReader in = new BufferedReader(new InputStreamReader(urlConnection.getInputStream()));
            inputLine = in.readLine().toString();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return inputLine;
    }
    
    /**
     *方法说明: 获取支付宝回调地址
     *创建时间: 2019年2月5日 下午1:21:05
     *创  建  人: wind
     **/
    public static String getNotifyUrl(HttpServletRequest request){
        StringBuffer requestURL = request.getRequestURL();
        return requestURL.substring(0,requestURL.indexOf("/api"))+AlipayConfig.NOTIFY_URL;
    }
    
//    /**
//	 * 构造支付订单参数列表
//	 * @param pid
//	 * @param app_id
//	 * @param target_id
//	 * @return
//	 */
//	public static Map<String, String> buildOrderParamMap(String app_id, boolean rsa2) {
//		Map<String, String> keyValues = new HashMap<String, String>();
//
//		keyValues.put("app_id", app_id);
//
//		keyValues.put("biz_content", "{\"timeout_express\":\"30m\",\"product_code\":\"QUICK_MSECURITY_PAY\",\"total_amount\":\"0.01\",\"subject\":\"学币购买\",\"body\":\"我是测试数据\",\"out_trade_no\":\"" + getOutTradeNo() +  "\"}");
//
//		keyValues.put("charset", "utf-8");
//
//		keyValues.put("method", "alipay.trade.app.pay");
//
//		keyValues.put("sign_type", rsa2 ? "RSA2" : "RSA");
//
//		keyValues.put("timestamp", "2016-07-29 16:55:53");
//		
//		keyValues.put("notify_url", "http://47.99.68.132:9090/car-api/api/personal/alipayNotify");
//
//		keyValues.put("version", "1.0");
//
//		return keyValues;
//	}

	/**
	 * 构造支付订单参数信息
	 *
	 * @param map
	 * 支付订单参数
	 * @return
	 */
	public static String buildOrderParam(Map<String, String> map) {
		List<String> keys = new ArrayList<String>(map.keySet());

		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < keys.size() - 1; i++) {
			String key = keys.get(i);
			String value = map.get(key);
			sb.append(buildKeyValue(key, value, true));
			sb.append("&");
		}

		String tailKey = keys.get(keys.size() - 1);
		String tailValue = map.get(tailKey);
		sb.append(buildKeyValue(tailKey, tailValue, true));

		return sb.toString();
	}

	/**
	 * 拼接键值对
	 *
	 * @param key
	 * @param value
	 * @param isEncode
	 * @return
	 */
	private static String buildKeyValue(String key, String value, boolean isEncode) {
		StringBuilder sb = new StringBuilder();
		sb.append(key);
		sb.append("=");
		if (isEncode) {
			try {
				sb.append(URLEncoder.encode(value, "UTF-8"));
			} catch (UnsupportedEncodingException e) {
				sb.append(value);
			}
		} else {
			sb.append(value);
		}
		return sb.toString();
	}
    
    /**
	 * 要求外部订单号必须唯一。
	 * @return
	 */
	public static String getOrderNo() {
		SimpleDateFormat format = new SimpleDateFormat("MMddHHmmss", Locale.getDefault());
		Date date = new Date();
		String key = format.format(date);

		Random r = new Random();
		key = key + r.nextInt();
		key = key.substring(0, 15);
		return key;
	}
    
}