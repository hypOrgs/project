package com.ypan.project;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
@Slf4j
public class ProjectApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext applicationContext = SpringApplication.run(ProjectApplication.class, args);


/*
// 查看容器里面所有注册的组件
        String[] definitionNames = applicationContext.getBeanDefinitionNames();
        for (String definitionName : definitionNames) {
            log.info("组件为:{}", definitionName);
        }

        log.info("总共有" + definitionNames.length + "个组件");

//        Object myProperties = applicationContext.getBean("myProperties");
//        System.out.println(JSON.toJSONString(myProperties));
        String[] beanNamesForType = applicationContext.getBeanNamesForType(MyProperties.class);
        for (String s : beanNamesForType) {
            System.out.println(s);
        }*/

    }

}
