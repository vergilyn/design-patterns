package com.vergilyn.examples.design.singleton.problem;

import java.io.Serializable;
import java.lang.reflect.Type;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.parser.DefaultJSONParser;
import com.alibaba.fastjson.parser.ParserConfig;
import com.alibaba.fastjson.parser.deserializer.ObjectDeserializer;

/**
 * 序列化和反序列化破坏单例
 *
 * @author vergilyn
 * @date 2021-01-26
 */
public class SerializableSingleton {
}

// VFIXME 存在问题的写法。
class SerializableSingletonProblem implements Serializable {
	private static SerializableSingletonProblem instance;

	private SerializableSingletonProblem() {
	}

	public static SerializableSingletonProblem getInstance() {
		if (instance == null) {
			instance = new SerializableSingletonProblem();
		}
		return instance;
	}
}

class TestSerializableSingletonProblem {
	public static void main(String[] args) {
		SerializableSingletonProblem s1 = SerializableSingletonProblem.getInstance();
		SerializableSingletonProblem s2 = SerializableSingletonProblem.getInstance();

		byte[] s = JSON.toJSONBytes(s1);
		System.out.println("s: " + s);
		SerializableSingletonProblem s3 = JSON.parseObject(s, SerializableSingletonProblem.class);
		System.out.println("s1: " + s1);
		System.out.println("s2: " + s2);
		System.out.println("s3: " + s3);
	}
}

//解决返序列化破坏代理
class SerializableSingletonResolve implements ObjectDeserializer {
	@Override
	public <T> T deserialze(DefaultJSONParser defaultJSONParser, Type type, Object o) {
		System.out.println("deserialze...");
		return (T) SerializableSingletonProblem.getInstance();
	}

	@Override
	public int getFastMatchToken() {
		return 0;
	}
}

class TestSerializableSingletonResolve {
	public static void main(String[] args) {
		SerializableSingletonProblem s1 = SerializableSingletonProblem.getInstance();
		SerializableSingletonProblem s2 = SerializableSingletonProblem.getInstance();
		System.out.println("s1: " + s1);
		System.out.println("s2: " + s2);

		ParserConfig.getGlobalInstance()
				.putDeserializer(SerializableSingletonProblem.class, new SerializableSingletonResolve());
		SerializableSingletonProblem s3 = JSON.parseObject("", SerializableSingletonProblem.class);

		System.out.println("s3: " + s3);
	}
}