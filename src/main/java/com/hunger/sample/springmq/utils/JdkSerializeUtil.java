package com.hunger.sample.springmq.utils;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import org.springframework.util.Assert;

public class JdkSerializeUtil {

	public static byte[] serialize(Object targetObj) {
		
		Assert.notNull(targetObj, "待序列化的内容不能为空！");
		ByteArrayOutputStream bos = new ByteArrayOutputStream();
		ObjectOutputStream os = null;
		try {
			os = new ObjectOutputStream(bos);
			os.writeObject(targetObj);
			os.flush();
		} catch (IOException e) {
			e.printStackTrace();
			return null;
		} finally {
			if (os != null) {
				try {
					os.close();
				} catch (IOException e) {
					e.printStackTrace();
				}

			}
			if (bos != null) {
				try {
					bos.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}

		return bos.toByteArray();
	}
	
	public static Object deserialize(byte[] bytes) {
		
		Assert.notNull(bytes, "待反序列化的内容不能为空！");
		ByteArrayInputStream in = new ByteArrayInputStream(bytes);
		ObjectInputStream ois = null;
		Object o = null;
		try {
			ois = new ObjectInputStream(in);
			o = ois.readObject();
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			if(ois !=null){
				try {
					ois.close();
				} catch (IOException e) {					
					e.printStackTrace();
				}
			}
			if(in !=null){
				try {
					in.close();
				} catch (IOException e) {					
					e.printStackTrace();
				}
			}
		}
		
		return o;
	}
}
