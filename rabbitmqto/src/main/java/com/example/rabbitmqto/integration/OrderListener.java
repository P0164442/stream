package com.example.rabbitmqto.integration;

import com.example.rabbitmqto.entity.Coffee;
import com.example.rabbitmqto.service.CoffeeService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

@Component
@Slf4j
@Transactional
public class OrderListener {
    @Resource
    private CoffeeService coffeeService;


    @Autowired
    @Qualifier(Waiter.FINISHED_ORDERS)
    private MessageChannel finishedOrdersMessageChannel;
    @Value("${order.barista-prefix}${random.uuid}")
    private String barista;

    @StreamListener(Waiter.NEW_ORDERS)
    public void processNewOrder(Long id) {
        Coffee o = coffeeService.getById(id);
        if (o == null) {
            log.warn("Order id {} is NOT valid.", id);
            return;
        }

        o.setName("dd");
        coffeeService.updateById(o);
        log.info("Order {} is READY.", id);
        finishedOrdersMessageChannel.send(MessageBuilder.withPayload(id).build());
    }

}
