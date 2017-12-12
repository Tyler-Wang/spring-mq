package com.hunger.sample.springmq.mqtt;

import java.net.URL;

import org.apache.log4j.PropertyConfigurator;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.hunger.sample.springmq.common.MqttMqRequest;
import com.hunger.sample.springmq.mqtt.producer.MqttMessageProducer;

public class Client {
	public static void main(String[] args) {
		URL url = Client.class.getResource("/conf/log4j.properties");
		String path = url.getPath();
		PropertyConfigurator.configureAndWatch(path);
		ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("classpath:spring/spring-bean.xml", "classpath:spring/spring-mqtt.xml");
//		MqttMessageProducer mp = ctx.getBean(MqttMessageProducer.class);
//		while(true){
//			MqttMqRequest req = new MqttMqRequest();
//			req.setMsgId(""+System.currentTimeMillis());
//			mp.sendTopicMessage(req);
//			try {
//				Thread.sleep(1000);
//			} catch (InterruptedException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//		}
		
	}
}
