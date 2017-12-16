package com.hunger.sample.springmq.rocketmq.consumer;

import java.util.ArrayList;
import java.util.List;

import com.hunger.sample.springmq.common.MqQueueName;
import com.hunger.sample.springmq.kafka.consumer.AbsMultiListenTopic;

public class TopicMessageRocketMQListenerTopic implements AbsMultiListenTopic{

	@Override
	public List<String> getListenTopic() {
		List<MqQueueName> list = new ArrayList<MqQueueName>();
		list.add(MqQueueName.REQ_TEST);
		
		
		List<String> topics = new ArrayList<String>();
		for(MqQueueName qn : list){
			topics.add(qn.getQueueName().replaceAll("\\.", "\\-"));
		}
		return topics;
	}

}
