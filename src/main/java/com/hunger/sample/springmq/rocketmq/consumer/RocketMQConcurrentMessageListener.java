package com.hunger.sample.springmq.rocketmq.consumer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.alibaba.fastjson.JSON;
import com.hunger.sample.springmq.common.MqMessage;

public class RocketMQConcurrentMessageListener extends AbsRocketMQConcurrentlyMessageListener {

	private static final Logger logger = LoggerFactory.getLogger(RocketMQConcurrentMessageListener.class);
	
	@Override
	public void onMessage(MqMessage message) {
		logger.info("rocketmq监听到的信息, 主题：{},内容：{}",message.getQueue().getQueueName(),JSON.toJSONString(message));
		//具体业务处理

	}

}
