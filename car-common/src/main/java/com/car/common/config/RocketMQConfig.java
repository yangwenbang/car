package com.car.common.config;

import java.util.Properties;

import org.springframework.context.annotation.Configuration;

import com.car.common.constants.PropertyKeyConst;

@Configuration
public class RocketMQConfig {


    public Properties getProperties(){

        Properties properties = new Properties();
		/**
		 * 键的首字母必须大写
		 */
        properties.setProperty(PropertyKeyConst.ACCESS_KEY,"**");
        //
        properties.setProperty(PropertyKeyConst.SECRET_KEY,"**");
        //
        properties.setProperty(PropertyKeyConst.SendMsgTimeoutMillis, "3000");
        // 顺序消息消费失败进行重试前的等待时间，单位(毫秒)
        properties.put(PropertyKeyConst.SuspendTimeMillis, "100");
        // 消息消费失败时的最大重试次数
        properties.put(PropertyKeyConst.MaxReconsumeTimes, "20");
        //
        properties.put(PropertyKeyConst.NAMESRV_ADDR, "http://MQ_INST_1712446655561421_Bahw3cHw.mq-internet-access.mq-internet.aliyuncs.com:80");
        return  properties;
    }
}