package com.mingjie.life_server.controller.admin;

import com.mingjie.life_server.pojo.Order;
import com.mingjie.life_server.service.OrderService;
import com.mingjie.life_server.util.BaseResult;
import com.mingjie.life_server.util.Common;
import com.mingjie.life_server.util.ResultUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Api(description = "订单管理模块")
@RestController
@RequestMapping("/admin/order")
public class OrderController {
    @Autowired
    private OrderService orderService;

    @ApiOperation("获取订单列表")
    @GetMapping("")
    public BaseResult list(){
        List<Order> orders = orderService.findAll();
        return ResultUtil.success(orders);
    }

    @ApiOperation("保存订单")
    @PostMapping("/save")
    public BaseResult list(Order order){
        if(order.getId() == null){
            order.setCreatedTime(Common.get_current());
        }
        orderService.save(order);
        return ResultUtil.success("修改成功");
    }
}
