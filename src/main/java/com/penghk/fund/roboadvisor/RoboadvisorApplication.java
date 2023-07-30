package com.penghk.fund.roboadvisor;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

/**
 * 开始重构
 * @date 2023/07/30
 */
@SpringBootApplication
@EnableScheduling
public class RoboadvisorApplication {

    public static void main(String[] args) {
        SpringApplication.run(RoboadvisorApplication.class, args);
    }

}
