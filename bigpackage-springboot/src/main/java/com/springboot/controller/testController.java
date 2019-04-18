package com.springboot.controller;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ImportResource;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.util.Properties;
import java.util.Set;

/**
 * @Author: 王帆
 * @CreateTime: 2018-12-18 10:36
 * @Description: 测试boot启动的controller
 */
@RestController
@EnableAutoConfiguration
@SpringBootApplication

public class testController {

    @RequestMapping("/")
    String home() {
        return "hello world";
    }

    public static void main(String[] args) {
        System.setProperty("spring.devtools.restart.enabled", "false");
        Properties properties = System.getProperties();
        Set<String> strings = properties.stringPropertyNames();
        for(String s : strings){
            System.out.println(" properties = "+s+"  , value = "+System.getProperty(s));
        }
        SpringApplication.run(testController.class, args);
        BigDecimal b = new BigDecimal(0d);
        BigDecimal a = new BigDecimal(10.0d);
        a.divide(b);

    }
}
