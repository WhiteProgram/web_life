package com.mingjie.life_server.dao;

import com.mingjie.life_server.pojo.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface OrderDao extends JpaRepository<Order,Integer>, JpaSpecificationExecutor<Order> {
}
