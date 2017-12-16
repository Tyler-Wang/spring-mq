package com.hunger.sample.springmq.mqtt.consumer;

import java.util.ArrayList;
import java.util.List;

import com.hunger.sample.springmq.common.AbsMultiListenTopic;
import com.hunger.sample.springmq.common.MqQueueName;

public class TopicMessageMqttListenerTopic implements AbsMultiListenTopic {

	@Override
	public List<String> getListenTopic() {
		List<MqQueueName> list = new ArrayList<MqQueueName>();
		list.add(MqQueueName.MQTT_REQ_TEST);
		
		
		List<String> topics = new ArrayList<String>();
		for(MqQueueName qn : list){
			topics.add(qn.getQueueName());
		}
		return topics;
	}

}
