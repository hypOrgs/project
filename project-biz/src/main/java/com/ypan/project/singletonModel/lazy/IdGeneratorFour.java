package com.ypan.project.singletonModel.lazy;

import java.util.concurrent.atomic.AtomicLong;

/**
 * 单例模式：懒汉式（枚举机制）
 * 优点：最简单的一种实现方式，基于枚举类型的单例实现。
 * 这种实现方式通过Java枚举类型本身的特性，保证了实例创建的线程安全性和实例的唯一性。
 */
public enum IdGeneratorFour {
    INSTANCE;
    private AtomicLong id = new AtomicLong(0);

    public long getId() {
        return id.incrementAndGet();
    }
}
