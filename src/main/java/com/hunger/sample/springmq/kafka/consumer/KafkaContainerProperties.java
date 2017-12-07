package com.hunger.sample.springmq.kafka.consumer;

import org.springframework.kafka.listener.config.ContainerProperties;

public class KafkaContainerProperties extends ContainerProperties {
	
	public KafkaContainerProperties(AbsMultiListenTopic multiTopic){
		super(multiTopic.getListenTopic().toArray(new String[]{}));
	}
}
