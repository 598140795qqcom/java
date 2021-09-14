package com.zjq.springcloud;

import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * @author Administrator
 * @title: EurekaMain7001
 * @projectName spirngcloud2021
 * @description: TODO
 * @date 2021/8/19 16:38
 */
@EnableEurekaServer
@SpringBootApplication
public class EurekaMain7001 {
    public static void main(String[] args) {
        SpringApplication.run(EurekaMain7001.class,args);
        System.out.print("sssssssssssss");

    }
}
