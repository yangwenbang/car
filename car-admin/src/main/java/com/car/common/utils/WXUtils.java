package com.car.common.utils;

import net.sf.json.JSONObject;

import javax.net.ssl.HttpsURLConnection;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;

public class WXUtils {


    public static final String APPID = "wx96e00748bfc14aff";

    public static final String MCH_ID = "1523988871";

    public static final String APP_SECRET = "7413edab4933a71a3e6d8bc745b21d20";

    public static final String KEY = "123456789jxjsykt987654321JXJSYKT";


    public static final String esakey="N1lo8muOUumwyc7Iuax5wxA3aJsoQhJj5v7Kmuva0bN";


    public static String queueInfo(String code) throws Exception {
        //通过code获取openid;
        net.sf.json.JSONObject wxUser = getOpenid(code);
        String openid = wxUser.getString("openid");
        return openid;
    }


    public static String GETOPENID = "https://api.weixin.qq.com/sns/oauth2/access_token?appid=APPID&secret=SECRET&code=CODE&grant_type=authorization_code";
    /*通过code获取用户openid*/

    public static JSONObject getOpenid(String code) throws IOException {
        JSONObject jsonObject = null;
        String path = GETOPENID.replace("APPID", APPID).replace("SECRET", APP_SECRET).replace("CODE", code);
        StringBuffer buffer = new StringBuffer();
        URL url = new URL(path);
        HttpsURLConnection httpUrlConn = (HttpsURLConnection) url.openConnection();
        httpUrlConn.setRequestMethod("POST");
        httpUrlConn.setDoOutput(true);
        httpUrlConn.setDoInput(true);
        httpUrlConn.setUseCaches(false);
        // 将返回的输入流转换成字符串
        InputStream inputStream = httpUrlConn.getInputStream();
        InputStreamReader inputStreamReader = new InputStreamReader(inputStream, "utf-8");
        BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
        String str = null;
        while ((str = bufferedReader.readLine()) != null) {
            buffer.append(str);
        }
        bufferedReader.close();
        inputStreamReader.close();
        // 释放资源
        inputStream.close();
        httpUrlConn.disconnect();
        jsonObject = JSONObject.fromObject(buffer.toString());
        return jsonObject;
    }


    public static String encodeUrl(String url) {
        String encodeurl = java.net.URLEncoder.encode(url);
        String qrurl = String.format("https://open.weixin.qq.com/connect/oauth2/authorize?appid=%s&redirect_uri=%s&response_type=code&scope=snsapi_base&state=123&connect_redirect=1#wechat_redirect", APPID, encodeurl);

        return qrurl;
    }


    public static void main(String[] args) {
        System.out.println(WXUtils.encodeUrl("http://www.jxjsykt.com:8080/car-admin/index.html?usercode=111"));
    }

}
