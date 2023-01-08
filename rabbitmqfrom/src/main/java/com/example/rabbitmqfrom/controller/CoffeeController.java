package com.example.rabbitmqfrom.controller;

import com.example.rabbitmqfrom.entity.Coffee;
import com.example.rabbitmqfrom.integration.Barista;
import com.example.rabbitmqfrom.service.CoffeeService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.messaging.support.MessageBuilder;

import javax.annotation.Resource;

/**
 * @ClassName CoffeeOrderController
 * @Description TODO
 * @Author wujun.cao
 * @Date Created in 2023/1/8 11:47
 */
@RestController
@RequestMapping("/coffee")
@Slf4j
public class CoffeeController {

    @Resource
    private CoffeeService coffeeService;
    @Autowired
    private Barista barista;

    @PutMapping("/{id}")
    public Coffee updateCoffeeState(@RequestBody Coffee coffee) {
        log.info("Cooffee state: {}", coffee);
        Coffee order = coffeeService.getById(coffee.getId());
        order.setName(coffee.getName());
        order.setPrice(coffee.getPrice());
        coffeeService.updateById(order);
        barista.newOrders().send(MessageBuilder.withPayload(order.getId()).build());
        return order;
    }
}
