package com.car.utils;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URI;
import java.util.HashMap;
import java.util.Map;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.alibaba.fastjson.JSONObject;
import com.aliyuncs.utils.StringUtils;
import com.car.ApiConstants;
import com.car.exception.RestException;
import com.car.pay.wxpay.WeChatConfig;

public class WeChatLoginUtils {
	private static final Logger log = LoggerFactory.getLogger(WeChatLoginUtils.class);

//	private static final String APPID = "wxa6ab3694c23586ce";
//	private static final String SECRET = "742a4f451f02f8492f1f81125e587800";
	private static final String GRANT_TYPE = "authorization_code";
	
	//获取access_token 接口地址   Get
	private final static String ACCESS_TOKEN_URL = "https://api.weixin.qq.com/sns/oauth2/access_token?appid=APPID&secret=SECRET&code=CODE&grant_type=authorization_code";
	private final static String WECHAT_USERINFO_URL = "https://api.weixin.qq.com/sns/userinfo?lang=zh_CN&access_token=ACCESS_TOKEN&openid=OPENID";

	/*
	 * 获取token
	 */
	public static Map getAccessToken(String code) throws Exception {
		Map<String, Object> resultMap = new HashMap<>(4);
//		String url = "https://api.weixin.qq.com/sns/oauth2/access_token?appid=" + WeChatConfig.APPID + "&secret="
//				+ WeChatConfig.KEY + "&code=" + code + "&grant_type=" + GRANT_TYPE + "";
		
		//拼接获取access_token的请求地址
		String accessTokenUrl = ACCESS_TOKEN_URL.replace("APPID", WeChatConfig.APPID)
				.replace("SECRET", WeChatConfig.APP_SECRET).replace("CODE", code);
        
		JSONObject responseObj = sendRequest(accessTokenUrl);

		String accessToken = responseObj.getString("access_token");
		String openid = responseObj.getString("openid");
		String refreshToken = responseObj.getString("refresh_token");
		Long expiresIn = responseObj.getLong("expires_in");
		accessToken = StringUtils.isEmpty(accessToken) ? "" : accessToken;
		openid = StringUtils.isEmpty(openid) ? "" : openid;
		refreshToken = StringUtils.isEmpty(refreshToken) ? "" : refreshToken;
		expiresIn = expiresIn == null ? 0 : expiresIn;

		resultMap.put("accessToken", accessToken);
		resultMap.put("openid", openid);
		resultMap.put("refreshToken", refreshToken);
		resultMap.put("expiresIn", expiresIn);

		return resultMap;
	}
	
	/**
	 * 获取用户信息-第一次登录
	 * @param accessToken
	 * @param openid
	 * @return
	 * @throws Exception 
	 */
	public static Map<String, Object> getWeChatUserInfo(String accessToken, String openid) throws Exception {
		Map<String, Object> resultMap = new HashMap<>(5);
		// 拼接获取userinfo的请求地址
		accessToken = accessToken == null ? "" : accessToken;
		String userinfoUrl = WECHAT_USERINFO_URL.replace("ACCESS_TOKEN", accessToken).replace("OPENID", openid);

		// 发送请求,获取返回结果
		JSONObject jsonObject = sendRequest(userinfoUrl);

		if (jsonObject.getString("openid") != null) {

			openid = jsonObject.getString("openid");
			String userName = jsonObject.getString("nickname");
			int sex = Integer.parseInt(jsonObject.getString("sex"));
			String cityName = jsonObject.getString("city");
			String picUrl = jsonObject.getString("headimgurl");

			resultMap.put("openid", openid);
			resultMap.put("userName", userName);
			resultMap.put("sex", sex);
			resultMap.put("cityName", cityName);
			resultMap.put("picUrl", picUrl);

		} else {
			throw new RestException(jsonObject.getString("errmsg"));

		}
		return resultMap;
	}
	
	
	private static JSONObject sendRequest(String url) throws Exception {
		URI uri = URI.create(url);
		HttpClient client = new DefaultHttpClient();
		HttpGet get = new HttpGet(uri);

		HttpResponse response = client.execute(get);

		BufferedReader reader = null;
		InputStreamReader isr = null;
		StringBuilder builder = new StringBuilder();
		try {
			if (response.getStatusLine().getStatusCode() == 200) {
				HttpEntity entity = response.getEntity();
				isr = new InputStreamReader(entity.getContent(), ApiConstants.UTF_8);
				reader = new BufferedReader(isr);
	
				for (String temp = reader.readLine(); temp != null; temp = reader.readLine()) {
					builder.append(temp);
				}
			}
		} finally {
			if (reader != null) {
				reader.close();
				reader = null;
			}
			if (isr != null) {
				isr.close();
				isr = null;
			}
		}
		return JSONObject.parseObject(builder.toString().trim());
	}
}
