package com.hunger.sample.springmq.mqtt.consumer;

import org.eclipse.paho.client.mqttv3.MqttMessage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.integration.channel.DirectChannel;
import org.springframework.integration.mqtt.core.MqttPahoClientFactory;
import org.springframework.integration.mqtt.inbound.MqttPahoMessageDrivenChannelAdapter;
import org.springframework.integration.mqtt.support.DefaultPahoMessageConverter;
import org.springframework.scheduling.concurrent.ThreadPoolTaskScheduler;

import com.hunger.sample.springmq.common.MqMessage;
import com.hunger.sample.springmq.utils.JdkSerializeUtil;

public abstract class AbsMqttMessageListener extends MqttPahoMessageDrivenChannelAdapter {

	private static final Logger logger = LoggerFactory.getLogger(AbsMqttMessageListener.class);
	
	public AbsMqttMessageListener(String clientId, MqttPahoClientFactory clientFactory, String[] topic) {
		super(clientId, clientFactory, topic);
		super.setOutputChannel(new DirectChannel());
		ThreadPoolTaskScheduler threadPoolTaskScheduler = new ThreadPoolTaskScheduler();
		threadPoolTaskScheduler.initialize();
		super.setTaskScheduler(threadPoolTaskScheduler);
		super.setConverter(new DefaultPahoMessageConverter());
	}

	@Override
	public void messageArrived(String topic, MqttMessage mqttMessage) throws Exception {
		try {
			MqMessage mqMsg = (MqMessage) JdkSerializeUtil.deserialize(mqttMessage.getPayload());
			this.onMessage(mqMsg);
		} catch (Exception e) {
			logger.error("mqtt消息转化出错:", e);
		}
	}
	
	/**
	 * 具体消息处理
	 * @param message
	 */
	public abstract void onMessage(MqMessage message);
}
