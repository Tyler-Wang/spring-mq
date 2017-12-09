package com.hunger.sample.springmq.kafka.producer;

import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.util.concurrent.ListenableFuture;

import com.hunger.sample.springmq.common.IMqMessageProducer;
import com.hunger.sample.springmq.common.MqMessage;
import com.hunger.sample.springmq.utils.JdkSerializeUtil;

public class KafkaMessageProducer implements IMqMessageProducer {

	@SuppressWarnings("rawtypes")
	private KafkaTemplate kafkaTemplate;
	
	@Override
	public void sendQueueMessage(MqMessage mqMessage) {
		// TODO Auto-generated method stub
		this.send(mqMessage);
	}

	@Override
	public void sendTopicMessage(MqMessage mqMessage) {
		// TODO Auto-generated method stub
		this.send(mqMessage);
	}

	@SuppressWarnings("unchecked")
	private ListenableFuture<SendResult<String, String>> send(MqMessage mqMessage){
		String topic = mqMessage.getQueue().getQueueName();
		byte[] data = JdkSerializeUtil.serialize(mqMessage);
		return kafkaTemplate.send(topic, data);
	}
	
	@SuppressWarnings("rawtypes")
	public KafkaTemplate getKafkaTemplate() {
		return kafkaTemplate;
	}

	public void setKafkaTemplate(KafkaTemplate kafkaTemplate) {
		this.kafkaTemplate = kafkaTemplate;
	}
	
}
