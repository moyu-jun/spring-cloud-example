package com.james.example.rabbitmq.domain;

import lombok.Data;
import lombok.Getter;

import java.io.Serializable;

/**
 * Created by James on 2020/3/26.
 */
@Data
public class Order implements Serializable {

    private Integer id;
    private String name;

}
