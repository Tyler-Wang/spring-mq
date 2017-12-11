package com.hunger.sample.springmq.mqtt.consumer;

import java.util.concurrent.Executors;

import org.eclipse.paho.client.mqttv3.MqttMessage;
import org.springframework.integration.channel.DirectChannel;
import org.springframework.integration.mqtt.core.MqttPahoClientFactory;
import org.springframework.integration.mqtt.inbound.MqttPahoMessageDrivenChannelAdapter;
import org.springframework.messaging.Message;
import org.springframework.scheduling.concurrent.ThreadPoolTaskScheduler;

import com.alibaba.fastjson.JSON;
import com.hunger.sample.springmq.common.MqMessage;
import com.hunger.sample.springmq.utils.JdkSerializeUtil;

public abstract class AbsMqttMessageListener extends MqttPahoMessageDrivenChannelAdapter {

	public AbsMqttMessageListener(String clientId, MqttPahoClientFactory clientFactory, String[] topic) {
		super(clientId, clientFactory, topic);
		super.setOutputChannel(new DirectChannel());
		ThreadPoolTaskScheduler threadPoolTaskScheduler = new ThreadPoolTaskScheduler();
		threadPoolTaskScheduler.initialize();
		super.setTaskScheduler(threadPoolTaskScheduler);
	}

	@Override
	public void messageArrived(String topic, MqttMessage mqttMessage) throws Exception {
		//Message<String> message = (Message<String>) this.getConverter().toMessage(topic, mqttMessage);
		try {
			MqMessage mqMsg = (MqMessage) JdkSerializeUtil.deserialize(mqttMessage.getPayload());
			this.onMessage(mqMsg);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 具体消息处理
	 * @param message
	 */
	public abstract void onMessage(MqMessage message);
}
