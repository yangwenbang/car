package com.car.rocketmq;

import java.util.Properties;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.aliyun.openservices.ons.api.Message;
import com.aliyun.openservices.ons.api.ONSFactory;
import com.aliyun.openservices.ons.api.Producer;
import com.aliyun.openservices.ons.api.PropertyKeyConst;
import com.aliyun.openservices.ons.api.SendResult;
import com.car.common.config.RocketMQConfig;

@Component
public class RocketMQProducer {
    @Autowired
    private RocketMQConfig rocketMQConfig;

    /**
     * 1、发送普通消息
     *
     * @param message
     * @return
     */
    public boolean sendNormalMessage(Message message,String groupId) {

        Properties properties=rocketMQConfig.getProperties();
        properties.setProperty(PropertyKeyConst.GROUP_ID,groupId);
        Producer producer = ONSFactory.createProducer(properties);
        // 在发送消息前，必须调用 start 方法来启动 Producer，只需调用一次即可
        producer.start();
        try {
            SendResult sendResult = producer.send(message);
            // 同步发送消息，只要不抛异常就是成功
            if (sendResult != null) {
                System.out.println("消息发送成功：messageID："+sendResult.getMessageId());
                return true;
            }
        } catch (Exception e) {
            // 消息发送失败，需要进行重试处理，可重新发送这条消息或持久化这条数据进行补偿处理
            e.printStackTrace();
        }
        return false;
    }
}