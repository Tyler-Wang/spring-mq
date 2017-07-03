package com.hunger.sample.springmq.common;

import java.io.Serializable;
/**
 * MQ消息
 * @author wangj
 *
 */
public abstract class MqMessage implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 3670831689784087183L;
	private String msgId; //消息Id
	
	public abstract MqQueueName getQueue();
	
	public String getMsgId() {
		return msgId;
	}

	public void setMsgId(String msgId) {
		this.msgId = msgId;
	}
	
}
