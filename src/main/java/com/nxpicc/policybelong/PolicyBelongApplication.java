package com.nxpicc.policybelong;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@EnableTransactionManagement
public class PolicyBelongApplication {

    public static void main(String[] args) {
        SpringApplication.run(PolicyBelongApplication.class, args);
    }

}
