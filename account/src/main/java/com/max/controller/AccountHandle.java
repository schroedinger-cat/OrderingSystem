package com.max.controller;

import com.max.entity.Admin;
import com.max.entity.User;
import com.max.repository.AdminRepository;
import com.max.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tk.mybatis.mapper.common.ExampleMapper;
import tk.mybatis.mapper.common.Mapper;
import tk.mybatis.mapper.entity.Example;

@RestController
@RequestMapping("/account")
public class AccountHandle {

    @Autowired
    private AdminRepository adminRepository;

    @Autowired
    private UserRepository userRepository;

    @GetMapping("/login/{username}/{password}/{type}")
    public Object login(
            @PathVariable("username") String username,
            @PathVariable("password") String password,
            @PathVariable("type") String type) {

        Class class_ = null;
        Mapper mapper = null;
        switch (type) {
            case "user":
                class_ = User.class;
                mapper = userRepository;
                break;
            case "admin":
                class_ = Admin.class;
                mapper = adminRepository;
                break;
        }

        Example example = new Example(class_);
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("username",username);
        criteria.andEqualTo("password",password);

        return mapper.selectOneByExample(example);
    }


}
