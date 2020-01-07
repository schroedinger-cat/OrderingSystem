package com.max.controller;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.max.entity.User;
import com.max.entity.UserVo;
import com.max.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserHandle {

    @Autowired
    private UserRepository userRepository;

    @RequestMapping("/findAll/{index}/{limit}")
    public UserVo findAll(@PathVariable("index") Integer index, @PathVariable("limit") Integer limit) {
        Page<User> page = PageHelper.startPage(index, limit);
        userRepository.selectAll();
        return UserVo.builder()
                .code(0)
                .count(page.getTotal())
                .data(page.getResult())
                .msg("成功!")
                .build();
    }

    @DeleteMapping("/deleteById/{id}")
    public void deleteById(@PathVariable("id") Long id) {
        userRepository.deleteByPrimaryKey(id);
    }


    @PostMapping("/save")
    public void save(@RequestBody User user) {
        userRepository.insert(user);
    }

    @GetMapping("/findById/{id}")
    public User findById(@PathVariable("id") Long id) {
        return userRepository.selectByPrimaryKey(id);
    }

    @PutMapping("/update")
    public void update(@RequestBody User user) {
        userRepository.updateByPrimaryKeySelective(user);
    }


}
