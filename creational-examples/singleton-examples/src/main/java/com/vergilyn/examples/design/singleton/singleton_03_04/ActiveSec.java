package com.vergilyn.examples.design.singleton.singleton_03_04;

/**
 * 单例模式03：积极加载(饿汉)、线程安全。<br/>
 *
 * @author vergilyn
 * @date 2021-01-26
 */
public class ActiveSec {
	/**
	 * 饿汉：在类装载时就实例化。避免了多线程同步问题，所以线程安全。<br/>
	 * 讨论：不能说积极加载比懒加载就差。积极加载只是在非必要的时候,就实例化了。
	 */
	private static ActiveSec instance = new ActiveSec();

	private ActiveSec() {
	}

	public static ActiveSec getInstance() {
		return instance;
	}
}

/**
 * 单例模式04：饿汉变种、线程安全。<br/>
 * 网上也说了和{@link ActiveSec}差不多。但根据我对JVM的理解，其实只是写法不一样的区别。
 *
 * @author vergilyn
 * @date 2021-01-26
 */
class ActiveSec2 {
	private static ActiveSec2 instance;

	static {
		instance = new ActiveSec2();
	}

	private ActiveSec2() {
	}

	public static ActiveSec2 getInstance() {
		return instance;
	}
}