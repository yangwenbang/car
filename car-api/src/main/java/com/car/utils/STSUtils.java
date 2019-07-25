package com.car.utils;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.LinkedHashMap;
import java.util.Map;

import com.aliyuncs.DefaultAcsClient;
import com.aliyuncs.auth.sts.AssumeRoleRequest;
import com.aliyuncs.auth.sts.AssumeRoleResponse;
import com.aliyuncs.exceptions.ClientException;
import com.aliyuncs.exceptions.ServerException;
import com.aliyuncs.http.MethodType;
import com.aliyuncs.http.ProtocolType;
import com.aliyuncs.profile.DefaultProfile;
import com.aliyuncs.profile.IClientProfile;

/**
 * OSS授权
 * 
 * @author wind
 */
public class STSUtils {
	private static final String REGION_CN_HANGZHOU = "cn-hangzhou";
	private static final String STS_API_VERSION = "2015-04-01";
	private static final String ACCESS_KEY = "LTAIphJgIBq2KcGw";
	private static final String ACCESS_KEY_SECRET = "mOxYtr92pCAloJCBaA5jrxRtk4gd3T";
	
	public static void main(String[] args) {
		System.out.println(STSUtils.class.getResource("all_policy.txt"));
	}

	public static Map<String, String> getSTSInfos() throws ServerException,ClientException {
		IClientProfile profile = DefaultProfile.getProfile(REGION_CN_HANGZHOU, ACCESS_KEY, ACCESS_KEY_SECRET);
		DefaultAcsClient client = new DefaultAcsClient(profile);
		
		ProtocolType protocolType = ProtocolType.HTTPS;
		String roleSessionName = "alice-001";
		
		InputStream inputStream = STSUtils.class.getResourceAsStream("all_policy.txt");
		String policy = ReadJson(inputStream); 

		// 创建一个 AssumeRoleRequest 并设置请求参数
		AssumeRoleRequest request = new AssumeRoleRequest();
		request.setVersion(STS_API_VERSION);
		request.setMethod(MethodType.POST);
		request.setProtocol(protocolType);

		request.setRoleArn("acs:ram::1581056204406376:role/ossrole");
		request.setRoleSessionName(roleSessionName);
		request.setPolicy(policy);
		request.setDurationSeconds(900L);

		// 发起请求，并得到response
		Map<String, String> respMap = new LinkedHashMap<String, String>();
		AssumeRoleResponse stsResponse = client.getAcsResponse(request);
		respMap.put("StatusCode", "200");
        respMap.put("AccessKeyId", stsResponse.getCredentials().getAccessKeyId());
        respMap.put("AccessKeySecret", stsResponse.getCredentials().getAccessKeySecret());
        respMap.put("SecurityToken", stsResponse.getCredentials().getSecurityToken());
        respMap.put("Expiration", stsResponse.getCredentials().getExpiration());
     
		
		return respMap;
	}
	
	/**
	 * 读取配置文件
	 * @param path
	 * @return
	 */
	public static String ReadJson(InputStream inputStream){
        //从给定位置获取文件
//        File file = new File(path);
        BufferedReader reader = null;
        //返回值,使用StringBuffer
        StringBuffer data = new StringBuffer();
        //
        try {
            reader = new BufferedReader(new InputStreamReader(inputStream));
            //每次读取文件的缓存
            String temp = null;
            while((temp = reader.readLine()) != null){
                data.append(temp);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            //关闭文件流
            if (reader != null){
                try {
                    reader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return data.toString();
    }


}