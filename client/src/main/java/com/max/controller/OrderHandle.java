package com.max.controller;

import com.max.entity.Order;
import com.max.entity.OrderVo;
import com.max.entity.User;
import com.max.feign.OrderFeign;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.Date;

@Controller
@RequestMapping("/order")
public class OrderHandle {

    @Autowired
    private OrderFeign orderFeign;

    @GetMapping("/save/{mid}")
    public String save(@PathVariable("mid") Long mid, HttpSession session) {
        User user = (User) session.getAttribute("user");
        Order order = Order.builder()
                .mid(mid)
                .uid(user.getId())
                .state(0)
                .date(new Date()).build();
        orderFeign.save(order);
        return "order";
    }

    @GetMapping("/findAllByUid")
    @ResponseBody
    public OrderVo findAllByUid(@RequestParam("page") Integer page, @RequestParam("limit") Integer limit, HttpSession session) {
        User user = (User) session.getAttribute("user");
        return orderFeign.findAll(page, limit, user.getId());
    }

    @GetMapping("/findAllByState")
    @ResponseBody
    public OrderVo findAllByState(
            @RequestParam("page") Integer page,
            @RequestParam("limit") Integer limit) {

        return orderFeign.findAllByState(page, limit);

    }

    @GetMapping("/updateState/{id}")
    public String findAllByState(@PathVariable("id") Long id) {
        orderFeign.updateState(id);
        return "redirect:/order_handler";
    }

}
