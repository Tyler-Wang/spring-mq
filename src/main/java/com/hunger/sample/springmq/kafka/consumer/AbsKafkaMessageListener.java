package com.hunger.sample.springmq.kafka.consumer;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.listener.MessageListener;

import com.hunger.sample.springmq.common.MqMessage;
import com.hunger.sample.springmq.utils.JdkSerializeUtil;
/**
 * 通用kafka消息处理类
 * 把kafka字节信息转化为MqMessage对象
 * @author wangj
 *
 */
public abstract class AbsKafkaMessageListener implements MessageListener<String, byte[]> {

	@Override
	public void onMessage(ConsumerRecord<String, byte[]> record) {
		// TODO Auto-generated method stub
		MqMessage mqMessage = (MqMessage) JdkSerializeUtil.deserialize(record.value());
		this.onMessage(record);
	}

	public abstract void onMessage(MqMessage mqMessage);
}
