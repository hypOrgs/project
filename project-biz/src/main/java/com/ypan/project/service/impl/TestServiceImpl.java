package com.ypan.project.service.impl;

import com.ypan.project.entity.User;
import com.ypan.project.service.TestService;
import com.ypan.project.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ThreadPoolExecutor;

@Service
public class TestServiceImpl implements TestService {

    @Autowired
    private UserService userService;

    @Autowired
    private ThreadPoolExecutor threadPoolExecutor;

    @Override
    public Boolean testAsync() {
        try {
            Thread.sleep(1000L);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        CompletableFuture.runAsync(() -> this.async(), threadPoolExecutor);
        return true;
    }

    public void async() {
        userService.save(new User());
    }
}
