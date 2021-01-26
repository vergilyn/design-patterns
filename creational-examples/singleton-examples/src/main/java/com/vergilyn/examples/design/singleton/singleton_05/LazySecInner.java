package com.vergilyn.examples.design.singleton.singleton_05;

/**
 * 单例模式05：懒加载、线程安全。<br/>
 * 区别03/04：前者是只要class类被装载，那么instance就被加载(积极加载)。
 * <br/>而此运用静态内部类特性,只有显示调过<code>getInstance()<code/>才会装载InnerClass,才会new LazySecInner();
 * <br/>懒加载的目的：1.实例化相当消耗资源,让其在真正使用时才实例化。2.class可能被动的被装载,此时实例化是没意义的。
 * <br/>
 *
 * @author vergilyn
 * @date 2021-01-26
 */
public class LazySecInner {
	private static class InnerClass {
		private static final LazySecInner INSTANCE = new LazySecInner();
	}

	private LazySecInner() {
	}

	public static final LazySecInner getInstance() {
		return InnerClass.INSTANCE;
	}
}
