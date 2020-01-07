package com.max;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import tk.mybatis.spring.annotation.MapperScan;

@SpringBootApplication
@MapperScan("com.max.repository")
public class AccountApplication {

    public static void main(String[] args) {
        SpringApplication.run(AccountApplication.class,args);

    }

}
