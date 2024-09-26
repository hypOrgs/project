package com.ypan.project.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@ConfigurationProperties(prefix = "project.thread")
@Component
@Data
public class ThreadPoolConfigProperties {

    private Integer coreSize;
    private Integer maxSize;
    private Integer keepAliveTime;
}
