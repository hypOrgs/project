package com.ypan.project.singletonModel.hunary;

/**
 * 单例模式：饿汉式
 * 优点：在类加载的时候，静态实例instance就已经创建并初始化好了，所以在多线程下是线程安全的。
 * 缺点：因为不支持延迟加载，如果该实例占用资源过多或初始化时间过长，就会影响到系统的性能
 */
public class IdGenerator {

    // 私有化构造器
    private IdGenerator() {}

    private static final IdGenerator instance = new IdGenerator();

    public static IdGenerator getInstance() {
        return instance;
    }


}
