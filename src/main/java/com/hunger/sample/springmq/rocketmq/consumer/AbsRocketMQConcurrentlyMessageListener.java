package com.hunger.sample.springmq.rocketmq.consumer;

import java.util.List;

import org.apache.rocketmq.client.consumer.listener.ConsumeConcurrentlyContext;
import org.apache.rocketmq.client.consumer.listener.ConsumeConcurrentlyStatus;
import org.apache.rocketmq.client.consumer.listener.MessageListenerConcurrently;
import org.apache.rocketmq.common.message.MessageExt;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.hunger.sample.springmq.common.IMqMessageListener;
import com.hunger.sample.springmq.common.MqMessage;
import com.hunger.sample.springmq.utils.JdkSerializeUtil;

public abstract class AbsRocketMQConcurrentlyMessageListener implements MessageListenerConcurrently, IMqMessageListener{

	private static final Logger logger = LoggerFactory.getLogger(AbsRocketMQConcurrentlyMessageListener.class);
	
	@Override
	public ConsumeConcurrentlyStatus consumeMessage(List<MessageExt> msgs, ConsumeConcurrentlyContext context) {
		if(msgs.size() > 0){
			for(MessageExt msg : msgs){
				try {
					MqMessage message = (MqMessage) JdkSerializeUtil.deserialize(msg.getBody());
					this.onMessage(message);
				} catch (Exception e) {
					logger.error("消耗消息出错:", e);
					return ConsumeConcurrentlyStatus.CONSUME_SUCCESS;
				}
			}
		}
		return ConsumeConcurrentlyStatus.CONSUME_SUCCESS;
	}

}
