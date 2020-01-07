package com.max.controller;

import com.max.entity.User;
import com.max.entity.UserVo;
import com.max.feign.UserFeign;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

@Controller
@RequestMapping("/user")
public class UserHandle {

    @Autowired
    private UserFeign userFeign;

    @RequestMapping("/findAll")
    @ResponseBody
    public UserVo findAll(@RequestParam("page") Integer page, @RequestParam("limit") Integer limit) {
        return  userFeign.findAll(page,limit);
    }

    @GetMapping("/deleteById/{id}")
    public String deleteById(@PathVariable("id") Long id) {
        userFeign.deleteById(id);

        return "redirect:/user_manage";
    }


    @PostMapping("/save")
    public String save(User user) {
        user.setRegisterdate(new Date());
        userFeign.save(user);
        return "user_manage";
    }

    @GetMapping("/findById/{id}")
    public String findById(@PathVariable("id") Long id, Model model) {
        User user = userFeign.findById(id);
        model.addAttribute("user",user);
        return "user_add";
    }

    @PostMapping("/update")
    public String update(User user) {
        userFeign.update(user);

        return "user_manage";
    }


}
