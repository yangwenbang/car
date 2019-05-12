package com.car.rocketmq;

import java.util.Properties;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.aliyun.openservices.ons.api.Action;
import com.aliyun.openservices.ons.api.ConsumeContext;
import com.aliyun.openservices.ons.api.Consumer;
import com.aliyun.openservices.ons.api.Message;
import com.aliyun.openservices.ons.api.MessageListener;
import com.aliyun.openservices.ons.api.ONSFactory;
import com.aliyun.openservices.ons.api.PropertyKeyConst;
import com.car.common.config.RocketMQConfig;

@Component
public class RocketMQConsumer {

    @Autowired
    private RocketMQConfig rocketMQConfig;


    /**
     * 1、普通订阅
     *
     * @param
     */
    public void normalSubscribe( ) {

        Properties properties = rocketMQConfig.getProperties();

        properties.put(PropertyKeyConst.GROUP_ID, "GID-test");

        Consumer consumer = ONSFactory.createConsumer(properties);
        consumer.subscribe("test", "*", new MessageListener() {
            @Override
            public Action consume(Message message, ConsumeContext context) {
                System.out.println("Receive: " + new String(message.getBody()));

                    //把消息转化为java对象
                    //JSONObject jsonObject=JSONObject.parseObject(jsonString);
                    //Book book= jsonObject.toJavaObject(Book.class);

                return Action.CommitMessage;
            }
        });

        consumer.start();
    }
}