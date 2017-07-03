package com.hunger.sample.springmq.activemq.consumer;

import java.util.ArrayList;
import java.util.List;

import org.apache.activemq.command.ActiveMQQueue;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.hunger.sample.springmq.common.MqQueueName;

public class TopicMessageActiveMQQueue extends ActiveMQQueue {
	private static final Logger logger = LoggerFactory.getLogger(TopicMessageActiveMQQueue.class);
	
	static String listenTopicName = null;
	static{
		//添加要监听的队列
		List<MqQueueName> listenerList = new ArrayList<MqQueueName>();
		listenerList.add(MqQueueName.REQ_TEST);
		
		StringBuilder sb = new StringBuilder();
		for(int i=0;i<listenerList.size();i++){
			if(i>0){
				sb.append(",");
			}
			sb.append(listenerList.get(i).getQueueName());
		}
		
		logger.info("监听的队列：{}", sb);		
		listenTopicName =sb.toString();
	}
	
	public TopicMessageActiveMQQueue(){
		super(listenTopicName);
	}
}
