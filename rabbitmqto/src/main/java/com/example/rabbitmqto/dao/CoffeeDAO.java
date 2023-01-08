package com.example.rabbitmqto.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.rabbitmqto.entity.Coffee;
import org.apache.ibatis.annotations.Mapper;

/**
 * @ClassName CoffeeOrderDAO
 * @Description TODO
 * @Author wujun.cao
 * @Date Created in 2023/1/8 11:47
 */
@Mapper
public interface CoffeeDAO extends BaseMapper<Coffee> {
}
