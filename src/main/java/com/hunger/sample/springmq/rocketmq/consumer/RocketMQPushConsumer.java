package com.hunger.sample.springmq.rocketmq.consumer;

import java.util.HashMap;
import java.util.Map;

import org.apache.rocketmq.client.consumer.DefaultMQPushConsumer;
import org.springframework.beans.factory.InitializingBean;

public class RocketMQPushConsumer implements InitializingBean{

	private DefaultMQPushConsumer defaultMQPushConsumer;
	
	private TopicMessageRocketMQListenerTopic listenerTopic;
	
	@Override
	public void afterPropertiesSet() throws Exception {
		if(defaultMQPushConsumer == null){
			throw new IllegalArgumentException("必须指定DefaultMQPushConsumer");
		}
		if(listenerTopic == null){
			throw new IllegalArgumentException("必须指定TopicMessageRocketMQListenerTopic");
		}
		Map<String, String> subscription = new HashMap<String, String>();
		for(String topic : listenerTopic.getListenTopic()){
			subscription.put(topic, null);
		}
		defaultMQPushConsumer.setSubscription(subscription);
		
		defaultMQPushConsumer.start();
	}

	public DefaultMQPushConsumer getDefaultMQPushConsumer() {
		return defaultMQPushConsumer;
	}

	public void setDefaultMQPushConsumer(DefaultMQPushConsumer defaultMQPushConsumer) {
		this.defaultMQPushConsumer = defaultMQPushConsumer;
	}

	public TopicMessageRocketMQListenerTopic getListenerTopic() {
		return listenerTopic;
	}

	public void setListenerTopic(TopicMessageRocketMQListenerTopic listenerTopic) {
		this.listenerTopic = listenerTopic;
	}

	
}
