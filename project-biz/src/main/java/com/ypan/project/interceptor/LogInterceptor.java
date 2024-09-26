package com.ypan.project.interceptor;

import com.alibaba.fastjson.JSON;
import lombok.extern.slf4j.Slf4j;
import org.apache.catalina.connector.OutputBuffer;
import org.apache.catalina.connector.ResponseFacade;
import org.apache.tomcat.util.digester.DocumentProperties;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.lang.reflect.Field;
import java.nio.ByteBuffer;
import java.nio.charset.CharsetEncoder;
import java.nio.charset.StandardCharsets;
import java.text.SimpleDateFormat;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

@Slf4j
public class LogInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        try {
            SimpleDateFormat sim = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            log.info("<-------请求参数日志打印开始");
            Map<String, Object> jsonMap = new HashMap<>();
            jsonMap.put("log_time", sim.format(System.currentTimeMillis()));
            jsonMap.put("url", request.getRequestURL().toString());
            jsonMap.put("method", request.getMethod());
            jsonMap.put("param", JSON.toJSONString(request.getParameterMap()));
            log.info("request参数打印：" + JSON.toJSONString(jsonMap));
            log.info("请求参数日志打印结束------>");
        } catch (Exception e) {
            log.error("请求日志打印失败。。");
        }
        return true;
    }

}
