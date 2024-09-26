package com.ypan.utils;

import lombok.extern.slf4j.Slf4j;

import javax.servlet.http.HttpServletRequest;
import java.io.BufferedReader;
import java.io.IOException;

@Slf4j
public class RequestBodyUtil {

    /**
     * 获取请求消息正文数据(消息体数据)
     */
    public static String getRequestBody(HttpServletRequest request) {
        // 获取body内容
        StringBuilder bodyBuilder = new StringBuilder();
        try (BufferedReader reader = request.getReader()) {
            String str;
            while ((str = reader.readLine()) != null) {
                bodyBuilder.append(str);
            }
        } catch (IOException e) {
            log.error("===读取request的消息体出错：", e);
            e.printStackTrace();
        }

        if (bodyBuilder.length() == 0) {
            throw new IllegalArgumentException("消息体内容为空");
        }

        return bodyBuilder.toString();
    }
}
