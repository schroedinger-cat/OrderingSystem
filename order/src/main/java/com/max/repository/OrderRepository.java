package com.max.repository;

import com.max.entity.Order;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

public interface OrderRepository extends Mapper<Order> {

    List<Order> selectAllJoinMenuByUid(Long uid);

    List<Order> selectAllJoinMenuByState(Integer status);
}
