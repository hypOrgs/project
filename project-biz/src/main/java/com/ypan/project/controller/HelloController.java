package com.ypan.project.controller;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.ypan.base.BaseResult;
import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;

@RestController
@RequestMapping("/hello")
@Api(tags = "请求源码分析")
public class HelloController {


    @PostMapping("/user")
    public BaseResult<String> post() {
        while (true) {

        }
    }

    @PutMapping("/user")
    public BaseResult<String> put() {
        return BaseResult.ok("put请求");
    }

    @DeleteMapping("/user")
    public BaseResult<String> delete() {
        return BaseResult.ok("delete请求");
    }

    @GetMapping("/user")
    public BaseResult<String> get(@RequestParam("username") String username, @RequestParam("userpass") String userpass ) {
        System.out.println(username + userpass);
        return BaseResult.ok("get请求");
    }

    @PostMapping("/locaDateTime")
    public BaseResult<String> test( @RequestBody @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss") LocalDateTime abc) {
        return BaseResult.ok(abc.toString()); }
}
