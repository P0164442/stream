package com.example.rabbitmqfrom;

import com.example.rabbitmqfrom.integration.Barista;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.stream.annotation.EnableBinding;

@SpringBootApplication
@EnableBinding(Barista.class)
@MapperScan("com.example.rabbitmqfrom.dao")
public class RabbitmqfromApplication {

    public static void main(String[] args) {
        SpringApplication.run(RabbitmqfromApplication.class, args);
    }

}
