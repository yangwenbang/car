package com.car.rocketmq;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.aliyun.openservices.ons.api.Message;

@RestController
public class TestController {
	
	@Autowired
	private RocketMQProducer rocketMQProducer;

	@Autowired
	private RocketMQConsumer rocketMQConsumer;

    //发送信息
	@RequestMapping("/send")
	public String send(String msg){
        // test 是创建的topic是名称， tag 是消息的二级分类，可以填空
		Message message=new Message("test","tag",msg.getBytes());
        // GID-test 是 发送信息组ID
		rocketMQProducer.sendNormalMessage(message,"GID-test");
		return "ok";
	}


    //接收信息
	@RequestMapping("/receive")
	public String receive(){
		rocketMQConsumer.normalSubscribe();
		return "ok";
	}

}
