package com.max.controller;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.max.entity.Order;
import com.max.entity.OrderVo;
import com.max.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import java.security.acl.LastOwnerException;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/order")
public class OrderHandler {

    @Autowired
    private OrderRepository orderRepository;


    @PostMapping("/save")
    public void save(@RequestBody Order order) {
        orderRepository.insertSelective(order);

    }

    @GetMapping("/findAll/{index}/{limit}/{uid}")
    public OrderVo findAll(
            @PathVariable("index") Integer index,
            @PathVariable("limit") Integer limit,
            @PathVariable("uid") Long uid) {
        Page<Order> page = PageHelper.startPage(index, limit);
        orderRepository.selectAllJoinMenuByUid(uid);
        return OrderVo.builder()
                .code(0)
                .count(page.getTotal())
                .data(page.getResult())
                .msg("成功!")
                .build();
    }

    @GetMapping("/findAllByState/{index}/{limit}")
    public OrderVo findAllByState(
            @PathVariable("index") Integer index,
            @PathVariable("limit") Integer limit) {
        Page<Order> page = PageHelper.startPage(index, limit);
        orderRepository.selectAllJoinMenuByState(0);
        return OrderVo.builder()
                .code(0)
                .count(page.getTotal())
                .data(page.getResult())
                .msg("成功!")
                .build();
    }

    @PutMapping("/updateState/{id}")
    public void updateState(@PathVariable("id")Long id){
        Order order = orderRepository.selectByPrimaryKey(id);
        order.setState(1);
        orderRepository.updateByPrimaryKeySelective(order);
    }




}
