package com.hunger.sample.springmq.utils;

import org.springframework.util.Assert;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;

public class FastjsonSerializeUtil {
	public static byte[] serialize(Object targetObj) {
		Assert.notNull(targetObj, "待序列化的内容不能为空！");
		byte[] jsonBytes = JSON.toJSONBytes(targetObj, SerializerFeature.WriteClassName);
		return jsonBytes;
	}
	
	public static Object deserialize(byte[] bytes, Class<?> clz) {
		Assert.notNull(bytes, "待反序列化的内容不能为空！");
		Object obj = JSON.parseObject(bytes, clz);
		return obj;
	}
}
