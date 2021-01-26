package com.vergilyn.examples.design.singleton.singleton_07;

/**
 * 单例模式07：双重校验锁。
 *
 * @author vergilyn
 * @date 2021-01-26
 */
public class DualSync {
	private volatile static DualSync instance;

	private DualSync() {
	}

	public static DualSync getInstance() {
		if (instance == null) {
			synchronized (DualSync.class) {
				if (instance == null) {
					instance = new DualSync();
				}
			}
		}
		return instance;
	}
}
