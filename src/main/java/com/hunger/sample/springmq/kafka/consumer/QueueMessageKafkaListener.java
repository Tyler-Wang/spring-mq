package com.hunger.sample.springmq.kafka.consumer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.alibaba.fastjson.JSON;
import com.hunger.sample.springmq.common.MqMessage;

public class QueueMessageKafkaListener extends AbsKafkaMessageListener {

	private static final Logger logger = LoggerFactory.getLogger(QueueMessageKafkaListener.class);
	@Override
	public void onMessage(MqMessage mqMessage) {
		logger.info("kafka监听到的信息,队列：{},内容：{}",mqMessage.getQueue().getQueueName(),JSON.toJSONString(mqMessage));
		//具体处理业务
	}

}
