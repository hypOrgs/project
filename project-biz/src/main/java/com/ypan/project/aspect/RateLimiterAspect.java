package com.ypan.project.aspect;

import com.ypan.project.aspect.annotion.RateLimiter;
import com.ypan.utils.Utils;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ZSetOperations;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.Method;
import java.util.concurrent.TimeUnit;

@Slf4j
@Aspect
@Component
public class RateLimiterAspect {

    @Autowired
    private RedisTemplate redisTemplate;

    /**
     * 实现限流（新思路）
     * @param point
     * @param rateLimiter
     * @throws Throwable
     */
    @SuppressWarnings("unchecked")
    @Before("@annotation(rateLimiter)")
    public void doBefore(JoinPoint point, RateLimiter rateLimiter) throws Throwable {
        // 在 {time} 秒内仅允许访问 {count} 次。
        int time = rateLimiter.time();
        int count = rateLimiter.count();
        // 根据用户IP（可选）和接口方法，构造key
        String combineKey = getCombineKey(point);

        // 限流逻辑实现
        ZSetOperations zSetOperations = redisTemplate.opsForZSet();
        // 记录本次访问的时间结点
        long currentMs = System.currentTimeMillis();
        zSetOperations.add(combineKey, currentMs, currentMs);
        // 这一步是为了防止member一直存在于内存中
        redisTemplate.expire(combineKey, time, TimeUnit.SECONDS);
        // 移除{time}秒之前的访问记录（滑动窗口思想）
        zSetOperations.removeRangeByScore(combineKey, 0, currentMs - time * 1000);

        // 获得当前窗口内的访问记录数
        Long currCount = zSetOperations.zCard(combineKey);
        // 限流判断
        if (currCount > count) {
            log.error("[limit] 限制请求数'{}',当前请求数'{}',缓存key'{}'", count, currCount, combineKey);
            throw new RuntimeException("访问过于频繁，请稍后再试!");
        }
    }

    /**
     * 把用户IP和接口方法名拼接成 redis 的 key
     * @param point 切入点
     * @return 组合key
     */
    private String getCombineKey(JoinPoint point) {
        StringBuilder sb = new StringBuilder("rate_limit:");
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();
        sb.append(Utils.getIpAddress(request) );

        MethodSignature signature = (MethodSignature) point.getSignature();
        Method method = signature.getMethod();
        Class<?> targetClass = method.getDeclaringClass();
        // keyPrefix + "-" + class + "-" + method
        return sb.append("-").append( targetClass.getName() )
                .append("-").append(method.getName()).toString();
    }
}
