package com.car.http;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class HttpDemo {


    public static void main(String[] args) throws IOException {
        String surl = "http://js.yhjyedu.com/cas/web/login/execute/save";
        Map<String,String> param=new HashMap<>();
        param.put("userid","南昌10001");
        param.put("password","nanchang1001");
        System.out.println(HttpUtils.sendPost(surl,param)); // post的关键所在！
        System.out.println(HttpUtils.sendHttpGet("http://js.yhjyedu.com/lms/home/my/clazz/501", null));

    }
}
