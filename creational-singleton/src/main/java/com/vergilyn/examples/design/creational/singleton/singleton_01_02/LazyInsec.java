package com.vergilyn.examples.design.creational.singleton.singleton_01_02;

/**
 * 单例模式01：懒加载(懒汉)、线程不安全;<br/>
 * 懒加载：因为在类加载的时候instance是null;<br/>
 * 线程不安全：<code>getInstance()</code>可以看出,如果是多线程,那么new操作可能在多个线程都发生。导致不是单例的。
 * @author VergiLyn
 * @bolg http://www.cnblogs.com/VergiLyn/
 * @date 2016/12/20
 */
public class LazyInsec {
    /** 保存实例。<br/>
     * private：阻止外部访问/修改。<br/>
     * static：根据静态只能使用静态原则。因为<code>getInstance()</code> 必须是static,所以instance必须是static。<br/>
     */
    private static LazyInsec instance;
    /** 显示定义构造函数。<br/>
     * private：阻止外部实例化。<br/>
     */
    private LazyInsec(){}
    /** 提供给外部实例化,返回唯一实例对象。<br/>
     * public、static：因为要提供给外部实例化，所以必须是public static。
     * @return
     */
    public static LazyInsec getInstance(){
        if(instance == null) instance = new LazyInsec();
        return instance;
    }
}

/**
 * 单例模式02：懒加载、线程安全;<br/>
 * 相对{@link LazySec} 区别只在线程是否安全。<br/>
 * 缺点：同步影响并发性,导致效率低下(且绝大多数是不需要同步的)
 * @author VergiLyn
 * @bolg http://www.cnblogs.com/VergiLyn/
 * @date 2016/12/20
 */
class LazySec {
    private static LazySec instance;
    private LazySec(){}
    /**
     * 区别只在sync
     * @see LazySec#getInstance()
     */
    public static synchronized LazySec getInstance(){
        if(instance == null) instance = new LazySec();
        return instance;
    }

    /**
     * 线程知识。作用一样。
     * @see #getInstance()
     */
    public static LazySec getInstance2(){
        synchronized (LazySec.class){
            if(instance == null) instance = new LazySec();
            return instance;
        }
    }
}