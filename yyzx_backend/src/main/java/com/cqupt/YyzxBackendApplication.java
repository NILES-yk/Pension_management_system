package com.cqupt;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.cqupt.mapper")
public class YyzxBackendApplication {
    //查看swagger接口文档:http://localhost:9999/yyzx/swagger-ui.html
    public static void main(String[] args) {
        SpringApplication.run(YyzxBackendApplication.class, args);
    }
}
