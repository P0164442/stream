package com.example.rabbitmqto.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;

/**
 * @ClassName CoffeeOrder
 * @Description TODO
 * @Author wujun.cao
 * @Date Created in 2023/1/8 11:48
 */

@TableName("T_ORDER")
@Data
public class Coffee implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId("id")
    private Long id;

    @TableField("name")
    private String name;

    @TableField("price")
    private Long price;

    private String barista;

}
