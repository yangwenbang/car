package com.car.pay.wxpay;

public class WeChatConfig {

   public static final String APPID = "wxa6ab3694c23586ce";
   
   public static final String MCH_ID = "1523988871";
   
   public static final String APP_SECRET = "742a4f451f02f8492f1f81125e587800";
   
   public static final String KEY = "123456789jxjsykt987654321JXJSYKT";
   
   // 下单 API 地址
   public static final String PLACE_URL = "https://api.mch.weixin.qq.com/pay/unifiedorder";
   
   /**
    * 接收通知的接口名(回调地址)
    */
   public static final String NOTIFY_URL = "/api/personal/weChatNotify";

}