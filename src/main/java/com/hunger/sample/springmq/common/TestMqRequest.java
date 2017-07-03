package com.hunger.sample.springmq.common;

public class TestMqRequest extends MqRequest {


	/**
	 * 
	 */
	private static final long serialVersionUID = 8259855750681633057L;

	@Override
	public MqQueueName getQueue() {
		// TODO Auto-generated method stub
		return MqQueueName.REQ_TEST;
	}

}
