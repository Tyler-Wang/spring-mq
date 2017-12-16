package com.hunger.sample.springmq.rocketmq.producer;

import org.apache.rocketmq.client.exception.MQBrokerException;
import org.apache.rocketmq.client.exception.MQClientException;
import org.apache.rocketmq.client.producer.DefaultMQProducer;
import org.apache.rocketmq.client.producer.SendResult;
import org.apache.rocketmq.common.message.Message;
import org.apache.rocketmq.remoting.exception.RemotingException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.InitializingBean;

import com.alibaba.fastjson.JSON;
import com.hunger.sample.springmq.common.IMqMessageProducer;
import com.hunger.sample.springmq.common.MqMessage;
import com.hunger.sample.springmq.utils.JdkSerializeUtil;

public class RocketMQMessageProducer implements IMqMessageProducer, InitializingBean {
	private static final Logger logger = LoggerFactory.getLogger(RocketMQMessageProducer.class);
	
	private DefaultMQProducer defaultMQProducer;
	
	@Override
	public void sendQueueMessage(MqMessage mqMessage) {
		
		Message msg = new Message(mqMessage.getQueue().getQueueName().replaceAll("\\.", "\\-"), JdkSerializeUtil.serialize(mqMessage));
		try {
			SendResult sr = defaultMQProducer.send(msg);
			logger.info("发送消息: {}, 结果: {}", new Object[]{JSON.toJSONString(mqMessage), sr.getSendStatus()});
		} catch (MQClientException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (RemotingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (MQBrokerException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void sendTopicMessage(MqMessage mqMessage) {
		// TODO Auto-generated method stub

	}

	@Override
	public void afterPropertiesSet() throws Exception {
		if(defaultMQProducer != null){
			defaultMQProducer.setVipChannelEnabled(false);
			defaultMQProducer.start();
		}
		
	}

	public DefaultMQProducer getDefaultMQProducer() {
		return defaultMQProducer;
	}

	public void setDefaultMQProducer(DefaultMQProducer defaultMQProducer) {
		this.defaultMQProducer = defaultMQProducer;
	}
	
}
