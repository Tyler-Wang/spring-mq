package com.hunger.sample.springmq.activemq.consumer;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.ObjectMessage;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.alibaba.fastjson.JSON;
import com.hunger.sample.springmq.common.MqMessage;
import com.hunger.sample.springmq.common.MqRequest;
import com.hunger.sample.springmq.common.MqResponse;
/**
 * 队列消息监听者
 * @author wangj
 *
 */
public class QueueMessageListener implements MessageListener {
	
	private static final Logger logger = LoggerFactory.getLogger(QueueMessageListener.class);
	
	public void onMessage(Message message) {
		// TODO Auto-generated method stub
		try {
			if(message instanceof ObjectMessage){
				ObjectMessage objMessage = (ObjectMessage)message;
				MqMessage mqMessage = (MqMessage)objMessage.getObject();
				logger.info("监听到的信息：{}",JSON.toJSONString(mqMessage));
				if(mqMessage instanceof MqRequest){
					//消息是请求
				}else if(mqMessage instanceof MqResponse){
					//消息是响应
				}else{
					logger.info("消息不是请求或响应：{}" ,JSON.toJSONString(mqMessage));
				}
			}
		} catch (JMSException e) {
			logger.error("接受队列的消息时出现异常,数据：{}",JSON.toJSONString(message), e);
		}
	}

}
