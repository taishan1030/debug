package com.wls.debug.idempotent;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.wls.debug.idempotent.moduler.mapper")
public class IdempotentApplication {

    public static void main(String[] args) {
        SpringApplication.run(IdempotentApplication.class, args);
    }

}
