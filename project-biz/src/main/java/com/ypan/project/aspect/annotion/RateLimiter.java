package com.ypan.project.aspect.annotion;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface RateLimiter {

    // 限流时间，默认一秒
    int time() default 1;

    // 限流次数，默认2次
    int count() default 2;
}
