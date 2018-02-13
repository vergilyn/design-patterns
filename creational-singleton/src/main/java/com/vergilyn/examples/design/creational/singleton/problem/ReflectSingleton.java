package com.vergilyn.examples.design.creational.singleton.problem;

import java.lang.reflect.Constructor;

/**
 * 反射破坏单例。所以要通过代码解决。
 * @author VergiLyn
 * @bolg http://www.cnblogs.com/VergiLyn/
 * @date 2016/12/25
 */
public class ReflectSingleton {
}
//存在问题的写法
class ReflectSingletonProblem {
    private static ReflectSingletonProblem instance;
    private ReflectSingletonProblem(){}
    public static ReflectSingletonProblem getInstance(){
        if(instance == null) instance = new ReflectSingletonProblem();
        return instance;
    }
}
class test{
    public static void main(String[] args) throws Exception {
        ReflectSingletonProblem s1 = ReflectSingletonProblem.getInstance();
        ReflectSingletonProblem s2 = ReflectSingletonProblem.getInstance();

        Class clazz = Class.forName(ReflectSingletonProblem.class.getName());
        Constructor[] constructors = clazz.getDeclaredConstructors();
        constructors[0].setAccessible(true);
        ReflectSingletonProblem s3 = (ReflectSingletonProblem) constructors[0].newInstance();

        System.out.println(s1 == s2); // true
        System.out.println(s1 == s3); // false
    }
}
// 解决反射破坏单例
class ResolveReflectProblem {
    private static ResolveReflectProblem instance;
    private ResolveReflectProblem() throws Exception {
        if(instance != null) throw new Exception("单例已被实例化。");
    }
    public static ResolveReflectProblem getInstance() throws Exception {
        if(instance == null) instance = new ResolveReflectProblem();
        return instance;
    }
}
class TestResolve{
    public static void main(String[] args) throws Exception {
        ResolveReflectProblem s1 = ResolveReflectProblem.getInstance();
        ResolveReflectProblem s2 = ResolveReflectProblem.getInstance();

        Class clazz = Class.forName(ResolveReflectProblem.class.getName());
        Constructor[] constructors = clazz.getDeclaredConstructors();
        constructors[0].setAccessible(true);
        ResolveReflectProblem s3 = (ResolveReflectProblem) constructors[0].newInstance(); // 异常

        System.out.println(s1 == s2);
        System.out.println(s1 == s3);
    }
}