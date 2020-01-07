package com.max.feign;

import com.max.entity.Order;
import com.max.entity.OrderVo;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

@FeignClient(value = "order")
public interface OrderFeign {

    @PostMapping("/order/save")
    void save(Order order);

    @GetMapping("/order/findAll/{index}/{limit}/{uid}")
    OrderVo findAll(
            @PathVariable("index") Integer index,
            @PathVariable("limit") Integer limit,
            @PathVariable("uid") Long uid);

    @GetMapping("/order/findAllByState/{index}/{limit}")
    OrderVo findAllByState(@PathVariable("index") Integer index,
                           @PathVariable("limit") Integer limit);

    @PutMapping("/order/updateState/{id}")
    void updateState(@PathVariable("id") Long id);

}
