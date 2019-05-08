package com.mingjie.life_server.service.impl;

import com.mingjie.life_server.dao.OrderDao;
import com.mingjie.life_server.pojo.Order;
import com.mingjie.life_server.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {
    @Autowired
    private OrderDao orderDao;
    @Override
    public void save(Order order) {
        orderDao.saveAndFlush(order);
    }

    @Override
    public List<Order> findAll() {
        return orderDao.findAll();
    }
}
