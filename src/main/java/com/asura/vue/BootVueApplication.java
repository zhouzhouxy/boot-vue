package com.asura.vue;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author asura
 * @version 1.0.0
 * @date 2020/8/7/007 21:33
 */
@SpringBootApplication
@MapperScan("com.asura.vue.mapper")
public class BootVueApplication {
    public static void main(String[] args) {
        SpringApplication.run(BootVueApplication.class,args);
    }
}
