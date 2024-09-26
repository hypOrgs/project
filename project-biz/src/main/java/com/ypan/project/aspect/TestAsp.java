package com.ypan.project.aspect;

import com.alibaba.fastjson.JSONObject;
import com.ypan.utils.RequestBodyUtil;
import lombok.extern.slf4j.Slf4j;
import org.apache.logging.log4j.util.Strings;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.nio.charset.StandardCharsets;
import java.util.Objects;

@Slf4j
@Aspect
@Component
public class TestAsp {


    @Pointcut("@annotation(com.ypan.project.aspect.annotion.TestAno)")
    public void testAspect() {
    }

    @Around("testAspect()")
    public Object decryptionAndVerification(ProceedingJoinPoint joinPoint) {

        ServletRequestAttributes requestAttributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        if (Objects.isNull(requestAttributes)) {
            return "请求参数不能为空";
        }
        HttpServletRequest request = requestAttributes.getRequest();
        String parameter = request.getParameter("111");
        log.info("111:{}",parameter);
        String body = RequestBodyUtil.getRequestBody(request);
        log.info("txzfd 请求消息体:{}", body);
        if (Strings.isBlank(body)) {
            return "请求消息体不能为空";
        }


        Class<?> aClass = joinPoint.getArgs()[0].getClass();
        Object[] params = new Object[1];
        params[0] = JSONObject.parseObject(body, aClass);
        try {
            Object proceed = joinPoint.proceed(params);
            return proceed;
        } catch (Throwable e) {
            e.printStackTrace();
            return "cuwu";
        }


    }
}
