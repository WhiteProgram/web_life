package com.mingjie.life_server.dao;

import com.mingjie.life_server.pojo.Consumption;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.math.BigDecimal;

public interface ConsumptionDao extends JpaRepository<Consumption,Integer>, JpaSpecificationExecutor<Consumption> {
    @Query(value = "SELECT SUM(fee) FROM Consumption WHERE status = '1' AND createdTime BETWEEN ?1 AND ?2")
    BigDecimal priceOut(Integer startTime, Integer endTime);

    @Modifying(clearAutomatically = true)
    @Query(value = "UPDATE Consumption SET status = ?2 WHERE id IN (?1)")
    void del(int[] ids,Integer status);
}
