package com.mingjie.life_server.service.impl;

import com.mingjie.life_server.dao.ConsumptionDao;
import com.mingjie.life_server.pojo.Consumption;
import com.mingjie.life_server.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import javax.transaction.Transactional;
import java.math.BigDecimal;

@Service
public class OrderServiceImpl implements OrderService {
    @Autowired
    private ConsumptionDao consumptionDao;
    @Override
    public void save(Consumption consumption) {
        consumptionDao.saveAndFlush(consumption);
    }

    @Override
    public Page<Consumption> findAll(Integer page, Integer size) {
        Specification specification = new Specification() {
            @Override
            public Predicate toPredicate(Root root, CriteriaQuery criteriaQuery, CriteriaBuilder cb) {
                return cb.equal(root.get("status").as(Integer.class),1);
            }
        };
        Pageable pageable = new PageRequest(page,size, Sort.Direction.DESC,"id");
        return consumptionDao.findAll(specification,pageable);
    }

    @Override
    public BigDecimal priceOut(Integer startTime, Integer endTime) {
        BigDecimal sum = consumptionDao.priceOut(startTime, endTime);
        if(sum == null)
            sum = new BigDecimal(0);
        return sum;
    }

    @Override
    @Transactional
    public void del(int[] ids,Integer status) {
        consumptionDao.del(ids,status);
    }
}
