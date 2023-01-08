package com.example.rabbitmqto;

import com.sun.deploy.util.Waiter;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.stream.annotation.EnableBinding;

@SpringBootApplication
@EnableBinding(Waiter.class)
@MapperScan("com.example.rabbitmqto.dao")
public class RabbitmqtoApplication {

    public static void main(String[] args) {
        SpringApplication.run(RabbitmqtoApplication.class, args);
    }

}
