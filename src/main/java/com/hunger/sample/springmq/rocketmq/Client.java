package com.hunger.sample.springmq.rocketmq;

import java.net.URL;

import org.apache.log4j.PropertyConfigurator;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.hunger.sample.springmq.common.MqttMqRequest;
import com.hunger.sample.springmq.common.TestMqRequest;
import com.hunger.sample.springmq.mqtt.producer.MqttMessageProducer;
import com.hunger.sample.springmq.rocketmq.producer.RocketMQMessageProducer;

public class Client {
	public static void main(String[] args) {
		URL url = Client.class.getResource("/conf/log4j.properties");
		String path = url.getPath();
		PropertyConfigurator.configureAndWatch(path);
		ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("classpath:spring/spring-bean.xml", "classpath:spring/spring-rocketmq.xml");
		RocketMQMessageProducer rocketMp = ctx.getBean(RocketMQMessageProducer.class);
		while(true){
			TestMqRequest req = new TestMqRequest();
			req.setMsgId(""+System.currentTimeMillis());
			rocketMp.sendQueueMessage(req);
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}
}
