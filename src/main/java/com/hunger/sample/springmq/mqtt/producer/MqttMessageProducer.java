package com.hunger.sample.springmq.mqtt.producer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.integration.mqtt.outbound.MqttPahoMessageHandler;
import org.springframework.integration.mqtt.support.MqttHeaders;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.hunger.sample.springmq.common.IMqMessageProducer;
import com.hunger.sample.springmq.common.MqMessage;
import com.hunger.sample.springmq.utils.JdkSerializeUtil;

public class MqttMessageProducer implements IMqMessageProducer {
	
	private static final Logger logger = LoggerFactory.getLogger(MqttMessageProducer.class);
	
	private MqttPahoMessageHandler mqttPahoMessageHandler;
	
	@Override
	public void sendQueueMessage(MqMessage mqMessage) {
		this.send(mqMessage);
	}

	@Override
	public void sendTopicMessage(MqMessage mqMessage) {
		logger.debug("准备向Topic {}, 发送消息 {}", mqMessage.getQueue().getQueueName(), JSONObject.toJSONString(mqMessage));
		this.send(mqMessage);
		logger.debug("向Topic {}, 发送消息 {} 完成", mqMessage.getQueue().getQueueName(), JSONObject.toJSONString(mqMessage));
	}

	private void send(MqMessage mqMessage){
		//发送byte[]格式消息
		Message<byte[]> message = MessageBuilder.withPayload(JdkSerializeUtil.serialize(mqMessage)).setHeader(MqttHeaders.TOPIC, mqMessage.getQueue().getQueueName()).build();
		mqttPahoMessageHandler.handleMessage(message);
	}

	public MqttPahoMessageHandler getMqttPahoMessageHandler() {
		return mqttPahoMessageHandler;
	}

	public void setMqttPahoMessageHandler(MqttPahoMessageHandler mqttPahoMessageHandler) {
		this.mqttPahoMessageHandler = mqttPahoMessageHandler;
	}
	
}
