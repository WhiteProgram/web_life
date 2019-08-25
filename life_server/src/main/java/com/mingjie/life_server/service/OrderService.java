package com.mingjie.life_server.service;

import com.mingjie.life_server.pojo.Consumption;
import org.springframework.data.domain.Page;

import java.math.BigDecimal;

public interface OrderService {
    void save(Consumption consumption);

    Page<Consumption> findAll(Integer page, Integer size);

    BigDecimal priceOut(Integer startTime, Integer endTime);

    void del(int[] ids,Integer status);
}
