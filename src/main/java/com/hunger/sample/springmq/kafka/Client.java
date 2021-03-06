package com.hunger.sample.springmq.kafka;

import java.net.URL;

import org.apache.log4j.PropertyConfigurator;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.hunger.sample.springmq.common.TestMqRequest;
import com.hunger.sample.springmq.kafka.producer.KafkaMessageProducer;

public class Client {
	public static void main(String[] args) {
		URL url = Client.class.getResource("/conf/log4j.properties");
		String path = url.getPath();
		PropertyConfigurator.configureAndWatch(path);
		ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("classpath:spring/spring-*.xml");
		
		KafkaMessageProducer kmp = ctx.getBean(KafkaMessageProducer.class);
		while(true){
			TestMqRequest req = new TestMqRequest();
			req.setMsgId(""+System.currentTimeMillis());
			kmp.sendQueueMessage(req);
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
