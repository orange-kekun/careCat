package com.example.carecat;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@ServletComponentScan
@EnableTransactionManagement
@Slf4j
public class CarecatApplication {

    public static void main(String[] args) {
        SpringApplication.run(CarecatApplication.class, args);
        log.info("carecat平台启动成功");
    }

}
