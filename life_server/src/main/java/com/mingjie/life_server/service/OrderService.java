package com.mingjie.life_server.service;

import com.mingjie.life_server.pojo.Order;

import java.util.List;

public interface OrderService {
    void save(Order order);

    List<Order> findAll();
}
