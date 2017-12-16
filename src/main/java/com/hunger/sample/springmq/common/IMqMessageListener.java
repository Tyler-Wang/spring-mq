package com.hunger.sample.springmq.common;

public interface IMqMessageListener {

	/**
	 * 具体消息处理
	 * @param message
	 */
	public void onMessage(MqMessage message);
}
