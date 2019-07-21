package com.car.utils;
import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.alibaba.druid.support.json.JSONUtils;
import com.aliyuncs.CommonRequest;
import com.aliyuncs.CommonResponse;
import com.aliyuncs.DefaultAcsClient;
import com.aliyuncs.IAcsClient;
import com.aliyuncs.exceptions.ClientException;
import com.aliyuncs.exceptions.ServerException;
import com.aliyuncs.http.MethodType;
import com.aliyuncs.profile.DefaultProfile;

public class AliSmsUtils {
	private static final Logger log = LoggerFactory.getLogger(AliSmsUtils.class);

	private static final String ACCESS_KEYID = "LTAIS5CbtzHO98OH";
	private static final String ACCESS_SECRET = "EHBB0X1znIySFEVZzh5W9ZDtgl0L7T";
	private static final String TEMPLATE_CODE = "SMS_169380158";
	
	public static void main(String[] args) {
		String random=(int)((Math.random()*9+1)*100000)+"";
		System.out.println(random);
	}
	
	public static void sendSms(String mobile, String code) throws ServerException,ClientException {
		DefaultProfile profile = DefaultProfile.getProfile("cn-hangzhou", ACCESS_KEYID, ACCESS_SECRET);
        IAcsClient client = new DefaultAcsClient(profile);

        CommonRequest request = new CommonRequest();
        request.setMethod(MethodType.POST);
        request.setDomain("dysmsapi.aliyuncs.com");
        request.setVersion("2017-05-25");
        request.setAction("SendSms");
        request.putQueryParameter("RegionId", "cn-hangzhou");
        request.putQueryParameter("PhoneNumbers", mobile);
        request.putQueryParameter("SignName", "车两科技");
        request.putQueryParameter("TemplateCode", TEMPLATE_CODE);
        Map<String, String> codeMap = new HashMap<>(1);
        codeMap.put("code", code);
        request.putQueryParameter("TemplateParam", JSONUtils.toJSONString(codeMap));
        
        CommonResponse response = client.getCommonResponse(request);
	}
	
//	public static void main(String[] args) {
//        DefaultProfile profile = DefaultProfile.getProfile("cn-hangzhou", ACCESS_KEYID, ACCESS_SECRET);
//        IAcsClient client = new DefaultAcsClient(profile);
//
//        CommonRequest request = new CommonRequest();
//        request.setMethod(MethodType.POST);
//        request.setDomain("dysmsapi.aliyuncs.com");
//        request.setVersion("2017-05-25");
//        request.setAction("SendSms");
//        request.putQueryParameter("RegionId", "cn-hangzhou");
//        request.putQueryParameter("PhoneNumbers", "13755619790");
//        request.putQueryParameter("SignName", "车两科技");
//        request.putQueryParameter("TemplateCode", "SMS_169380158");
//        request.putQueryParameter("TemplateParam", "{\"code\": \"44356\"}");
//        try {
//            CommonResponse response = client.getCommonResponse(request);
//            System.out.println(response.getData());
//        } catch (ServerException e) {
//            e.printStackTrace();
//        } catch (ClientException e) {
//            e.printStackTrace();
//        }
//    }
}