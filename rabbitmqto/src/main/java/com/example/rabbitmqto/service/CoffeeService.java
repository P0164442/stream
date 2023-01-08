package com.example.rabbitmqto.service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import com.example.rabbitmqto.dao.CoffeeDAO;
import com.example.rabbitmqto.entity.Coffee;
import org.springframework.stereotype.Service;

/**
 * @ClassName CoffeeService
 * @Description TODO
 * @Author wujun.cao
 * @Date Created in 2023/1/8 12:02
 */
@Service
public class CoffeeService extends ServiceImpl<CoffeeDAO, Coffee> implements ICoffeeService {

}
