package com.hunger.sample.springmq.common;
/**
 * 消息队列名称定义
 * @author wangj
 *
 */
public enum MqQueueName {
	REQ_TEST{

		@Override
		public final String getQueueName() {
			// TODO Auto-generated method stub
			return "mq.req.test";
		}
		
	},
	RES_TEST{

		@Override
		public final String getQueueName() {
			// TODO Auto-generated method stub
			return "mq.res.test";
		}
		
	};
	
	public abstract String getQueueName();
}
