package com.mingjie.life_server.service;

import com.mingjie.life_server.pojo.Order;
import org.springframework.data.domain.Page;

import java.math.BigDecimal;
import java.util.List;

public interface OrderService {
    void save(Order order);

    Page<Order> findAll(Integer page, Integer size);

    BigDecimal priceOut(Integer startTime, Integer endTime);

    void del(int[] ids,Integer status);
}
