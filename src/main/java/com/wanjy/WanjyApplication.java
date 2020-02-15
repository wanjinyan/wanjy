package com.wanjy;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
@SpringBootApplication
@MapperScan("com.wanjy.common.mapper")
public class WanjyApplication {
    public static void main(String[] args) {
        SpringApplication.run(WanjyApplication.class, args);
    }

}
