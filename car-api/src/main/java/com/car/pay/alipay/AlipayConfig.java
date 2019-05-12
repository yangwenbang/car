package com.car.pay.alipay;

public class AlipayConfig {

    /**
     *合作身份者ID，签约账号，以2088开头由16位纯数字组成的字符串，查看地址：https://openhome.alipay.com/platform/keyManage.htm?keyType=partner
     */
    public static final String SELLER_ID = "2088032799051716";
   
    /**
     *商户的私钥,需要PKCS8格式，RSA公私钥生成：https://doc.open.alipay.com/doc2/detail.htm?spm=a219a.7629140.0.0.nBDxfy&treeId=58&articleId=103242&docType=1
     */
    public static final String PRIVATE_KEY = "MIIEvQIBADANBgkqhkiG9w0BAQEFAASCBKcwggSjAgEAAoIBAQCiOsWMF3Cz0TISij/xb+YFcifDq8iuh7RE45BvGH7xBO7O9SgZWvx4v3x6PjSXN4yxjQeTHsYVaVg7qQFBa5i1bRWrFaVPh9bHmy6TMyW22P7IZVcODSOI/YkeQTexOnEWnkQfsZ09lwFaboPX9v8mCTqH2NpIYBU8c3WOtAIrPulv1XMXnRz3oym2IQinsUA3detQWUN9Uiv+DD/MQPXc1OEiqIJ+oz/Eg+wtjteWJeJ5zc4bBMrLAtsvvxjDeWXFmKSIE7DC5cLz7s/OD2m8Re7LhfYX5pZosjf83A+Q8Zv1aLoTC37JXKfTA7xSIVAf2aBe4ZDb9IOJgR4F/4M1AgMBAAECggEBAJq/GQUCrvy3hd3thgUVygJT295oFGt3AtvbfkCayyu4mttLOs7E3aOIdIJep+e+kzQh5KHPbv+plwKBubLfobEdtteVNDTizFtmiUzcMxNxdcdN83Zxzf20aoEzkJ47svfyS+U3lVfUnPPYC2eMMeHkV7KRhdYX4Oni8LYIuzDnqk+lI6k7th2bKYmRn/EwD6CTjD0fjiOlyooQ5AwbCDSbwcVY1WaJp3fR30yupx0VgsyOOKOf01/KM/NqBoawCNUaaYVyEnUNJlGf+wyXVbKDh5UqioUdv+yyVbjaHUX55jUzkE9fd2/rkzV0LmgWRvQ8BWUm3aa895WsRFo4vFkCgYEA+/E/NRx9iP9yqi6lqkGIoWtebz76li5oItk+DNXmMh6nxCPNvBrU00tr3oxmLJEhAFNcHSE/ekL5MwbSEwbINAcYIxnZl9jMOneFqoLMerfr8QEbDQpcxhbGxBBUcmoFPBdKiigWWubAlMQ2/FnPLk5uk7N5u+Cd9ksfiit9+PMCgYEApNekC547qi0CwnTNtvS7qccTFUt/DCuGWCFcF918GwK0GAUC2KxCqq3yos+lfKwraynF+K5i9oXm3bmhOxntPQaJnmIl6sqA8duDgc7JJyUTDDojn9vY9ZEpwwtVaFudMwvrEwkS4Bbqhf6Pqw81pHcolnsMvu98AQia6rM2nTcCgYA8umDm93AW9qP3+3h5OoSpjAzeOcsDKjp1s/Gt/F0ZVaRQteSgY8NLDxH4OdVjBrRytKUubFY1rTEOKKW4alkVmWQrCc8WN+66ZRb2C8MoDW80z3Rqx0WnhdPxbJI+ZenPGzofZRxGWvquoUEzwJ4c5lDnD0rXi4Pn2yHGF0etGwKBgFYpoUWxX96DyH18MEsBgVYtCHyJCc+CsKZASbLvwn8b2qbzd5lp8S7l3X3cq9OO6uMI4sIp5PCW7SXYcb5Cvw627BgtlUQ0tVG2O/cN73bWmi459YUJlU5Gol2g/vOdb33PLQC2LXeUguGnPdFcEd31qvF9QBxNcbPYm6EyK8nhAoGAYGYKebZWn7971/3um7wAgWCdwWQt7ynCxw0GEv6V88Z3CXJ61zsFWwfLmDY/nR3QMYECBlghRvfBu6PcrJ8ZEoaHkYUFMuakcot/HOYyRXFY8TfwocN+eaJqjhoXD92KNEhqqGSkS1N3vIZ6/OUMt19k6DcmI21f+8Vzq46S1e4=";
	
    /**
     *支付宝的公钥，查看地址：https://openhome.alipay.com/platform/keyManage.htm?keyType=partner
     */
    public static final String ALIPAY_PUBLIC_KEY = "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAojrFjBdws9EyEoo/8W/mBXInw6vIroe0ROOQbxh+8QTuzvUoGVr8eL98ej40lzeMsY0Hkx7GFWlYO6kBQWuYtW0VqxWlT4fWx5sukzMlttj+yGVXDg0jiP2JHkE3sTpxFp5EH7GdPZcBWm6D1/b/Jgk6h9jaSGAVPHN1jrQCKz7pb9VzF50c96MptiEIp7FAN3XrUFlDfVIr/gw/zED13NThIqiCfqM/xIPsLY7XliXiec3OGwTKywLbL78Yw3llxZikiBOwwuXC8+7Pzg9pvEXuy4X2F+aWaLI3/NwPkPGb9Wi6Ewt+yVyn0wO8UiFQH9mgXuGQ2/SDiYEeBf+DNQIDAQAB";

    /** 
     * 签名方式
     */
    public static final String SIGN_TYPE = "RSA2";
    /**
     * 字符编码格式 目前支持 gbk 或 utf-8
     */
    public static final String CHARSET = "utf-8";
    /**
     * 接收通知的接口名(回调地址)
     */
    public static final String NOTIFY_URL = "/api/personal/alipayNotify";
    /**
     * APPID
     */
    public static final String APP_ID = "2018100961638585"; 
    
    /**
     * 支付宝消息验证地址
     */
    public static final String HTTPS_VERIFY_URL = "https://mapi.alipay.com/gateway.do?service=notify_verify&";

}