package com.hunger.sample.springmq.kafka.consumer;

import org.springframework.kafka.listener.config.ContainerProperties;

import com.hunger.sample.springmq.common.AbsMultiListenTopic;

public class KafkaContainerProperties extends ContainerProperties {
	
	public KafkaContainerProperties(AbsMultiListenTopic multiTopic){
		super(multiTopic.getListenTopic().toArray(new String[]{}));
	}
}
