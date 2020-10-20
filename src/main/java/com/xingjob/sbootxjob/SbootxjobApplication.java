package com.xingjob.sbootxjob;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.xingjob.sbootxjob.mapper")
public class SbootxjobApplication {

    public static void main(String[] args) {
        SpringApplication.run(SbootxjobApplication.class, args);
    }

}
