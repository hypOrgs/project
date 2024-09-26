package com.ypan.project.singletonModel.lazy;

import java.util.Objects;

/**
 * 单例模式-饿汉式
 * 优点：支持延迟加载
 *
 * 缺点：加锁机制导致每次调用都加锁大大降低了系统性能，并发度为1
 * 如果这个对象频繁的被用到，那频繁加锁释放锁会导致性能瓶颈，这种实现方式就不可取了。
 *
 */
public class IdGeneratorOne {

    private IdGeneratorOne(){}
    private static IdGeneratorOne instance;

    public static synchronized IdGeneratorOne getInstance() {
        if (Objects.isNull(instance)) {
            return new IdGeneratorOne();
        }
        return instance;
    }
}
