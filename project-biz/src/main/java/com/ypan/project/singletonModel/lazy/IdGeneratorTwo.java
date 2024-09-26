package com.ypan.project.singletonModel.lazy;

import java.util.Objects;

/**
 * 单例模式-懒汉（双重检测机制）
 * 优点：getInstance()方法不会加到锁逻辑代码里来，大大提高了并发度。
 *
 * 双重检测instance为null的目的：
 * 当多个线程进来的时候，第一层判断instance都为null，进来多个线程
 * 然后多个线程竞争锁，某个线程得到锁之后，创建出instance对象实例
 * 这时如果没有第二层判断instance是否为null,已经从第一层进来的线程会继续创建新的instance对象实例。
 *
 * 缺点：如果静态变量不加volatile修饰，那么会出现我们经常说的指令重排的问题，
 * new一个对象的时候，会执行三步：1、分配内存空间 2、初始化对象 3、将对象的地址赋值给引用
 * 当发生指令重排的时候会导致初始化操作被放到最后一步，这样执行顺序为：1-3-2
 * 这样对象还没初始化完成就被其他线程拿去用了，就会报空指针异常。
 *
 */
public class IdGeneratorTwo {

    private IdGeneratorTwo(){}
    private static volatile IdGeneratorTwo instance;

    public static IdGeneratorTwo getInstance() {
        if (Objects.isNull(instance)) {
            synchronized (IdGeneratorTwo.class) {
                if (Objects.isNull(instance)) {
                    instance = new IdGeneratorTwo();
                }
            }
        }
        return instance;
    }

}
