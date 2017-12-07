package com.hunger.sample.springmq.kafka.producer;

import org.springframework.kafka.core.KafkaTemplate;

import com.hunger.sample.springmq.common.IMqMessageProducer;
import com.hunger.sample.springmq.common.MqMessage;

public class KafkaMessageProducer implements IMqMessageProducer {

	private KafkaTemplate kafkaTemplate;
	
	@Override
	public void sendQueueMessage(MqMessage mqMessage) {
		// TODO Auto-generated method stub

	}

	@Override
	public void sendTopicMessage(MqMessage mqMessage) {
		// TODO Auto-generated method stub

	}

	public KafkaTemplate getKafkaTemplate() {
		return kafkaTemplate;
	}

	public void setKafkaTemplate(KafkaTemplate kafkaTemplate) {
		this.kafkaTemplate = kafkaTemplate;
	}
	
}
