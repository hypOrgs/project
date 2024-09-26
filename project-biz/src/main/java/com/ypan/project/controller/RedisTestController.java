package com.ypan.project.controller;
import java.time.LocalDateTime;
import java.util.concurrent.TimeUnit;

import com.alibaba.fastjson.JSON;
import com.ypan.base.BaseResult;
import com.ypan.project.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/redis")
public class RedisTestController {

    @Autowired
    private StringRedisTemplate redisTemplate;

    @GetMapping("/incr")
    public BaseResult<Boolean> incrRedis() {

        User user = new User();
        user.setId(0L);
        user.setName("");
        user.setAge(0);
        user.setPinyin("");
        user.setId(0L);
        user.setDelFlag("");
        user.setCreateTime(LocalDateTime.now());
        user.setUpdateTime(LocalDateTime.now());
        user.setCreateBy("");
        user.setUpdateBy("");
        String s = JSON.toJSONString(user);
        redisTemplate.opsForValue().set("888", s, 5, TimeUnit.MINUTES);
        return BaseResult.ok(true);
    }

}
