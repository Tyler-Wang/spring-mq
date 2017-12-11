package com.hunger.sample.springmq.common;

public class MqttMqRequest extends MqRequest {

	@Override
	public MqQueueName getQueue() {
		// TODO Auto-generated method stub
		return MqQueueName.MQTT_REQ_TEST;
	}

}
