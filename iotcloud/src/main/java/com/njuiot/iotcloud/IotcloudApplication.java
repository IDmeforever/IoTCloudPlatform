package com.njuiot.iotcloud;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@MapperScan("com.njuiot.iotcloud.mapper")
@SpringBootApplication
public class IotcloudApplication {

    public static void main(String[] args) {
        SpringApplication.run(IotcloudApplication.class, args);
    }

}
