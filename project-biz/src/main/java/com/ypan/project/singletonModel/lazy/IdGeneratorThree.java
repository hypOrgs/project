package com.ypan.project.singletonModel.lazy;

/**
 * 单例模式：懒汉式（静态内部类机制）
 * 优点：比双重检测更简单的实现方式，SingletonHolder是一个静态内部类，当外部类IdGenertorThree被加载的时候，并不会创建SingletonHolder实例对象。
 * 只有当调用getInstance（）方法时,SingletonHolder才会被加载，这个时候才会创建instance。
 * instance的唯一性、创建过程的线程安全性，都由JVM来保证，所以，这种实现方式既保证了线程安全，又能做到延迟加载。
 */
public class IdGeneratorThree {

    private IdGeneratorThree() {
    }

    private static class SingletonHolder {
        private static final IdGeneratorThree instance = new IdGeneratorThree();
    }

    public static IdGeneratorThree getInstance() {
        return SingletonHolder.instance;
    }

}
