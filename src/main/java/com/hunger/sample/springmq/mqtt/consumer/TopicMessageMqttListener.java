package com.hunger.sample.springmq.mqtt.consumer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.integration.mqtt.core.MqttPahoClientFactory;

import com.alibaba.fastjson.JSON;
import com.hunger.sample.springmq.common.MqMessage;
import com.hunger.sample.springmq.kafka.consumer.AbsMultiListenTopic;

public class TopicMessageMqttListener extends AbsMqttMessageListener {

	private static final Logger logger = LoggerFactory.getLogger(TopicMessageMqttListener.class);
	
	public TopicMessageMqttListener(String clientId, MqttPahoClientFactory clientFactory, AbsMultiListenTopic multTopic) {
		super(clientId, clientFactory, multTopic.getListenTopic().toArray(new String[]{}));
	}

	@Override
	public void onMessage(MqMessage message) {
		logger.info("mqtt监听到的信息, 主题：{},内容：{}",message.getQueue().getQueueName(),JSON.toJSONString(message));
		//具体业务处理
	}

}
