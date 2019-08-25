package com.mingjie.life_server.controller.admin;

import com.mingjie.life_server.QueryVo.PageVo;
import com.mingjie.life_server.pojo.Consumption;
import com.mingjie.life_server.service.OrderService;
import com.mingjie.life_server.util.BaseResult;
import com.mingjie.life_server.util.Common;
import com.mingjie.life_server.util.ResultUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;

@Api(description = "订单管理模块")
@RestController
@RequestMapping("/admin/order")
public class ConsumptionController {
    @Autowired
    private OrderService orderService;

    @ApiOperation("获取订单列表")
    @GetMapping("")
    public BaseResult list(PageVo pageVo){
        Page<Consumption> orders = orderService.findAll(pageVo.getPage(),pageVo.getSize());
        return ResultUtil.successPageList(orders.getContent(),orders.getTotalPages());
    }

    @ApiOperation("保存订单")
    @PostMapping("/save")
    public BaseResult list(Consumption consumption){
        if(consumption.getId() == null){
            consumption.setCreatedTime(Common.get_current());
            consumption.setStatus(1);
        }
        orderService.save(consumption);
        return ResultUtil.success("修改成功");
    }

    @ApiOperation("逻辑删除账单")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "ids",value = "要删除的id集合，多个用逗号隔开",paramType = "query"),
            @ApiImplicitParam(name = "status",value = "逻辑状态,1为正常，0为删除",paramType = "query")
    })
    @PostMapping("/delete")
    public BaseResult delete(String ids,Integer status){
        orderService.del(Common.stringsToints(ids.split(",")),status);
        return ResultUtil.success("删除成功");
    }

    @ApiOperation("统计阶段支出")
    @GetMapping("/priceOut")
    public BaseResult priceOut(Integer startTime,Integer endTime){
        BigDecimal sum = orderService.priceOut(startTime,endTime);
        return ResultUtil.success(sum);
    }
}
