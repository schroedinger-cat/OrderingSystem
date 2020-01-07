package com.max.feign;

import com.max.entity.User;
import com.max.entity.UserVo;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

@FeignClient(value = "user")
public interface UserFeign {

    @RequestMapping("/user/findAll/{index}/{limit}")
    UserVo findAll(@PathVariable("index") Integer index, @PathVariable("limit") Integer limit);

    @DeleteMapping("/user/deleteById/{id}")
    void deleteById(@PathVariable("id") Long id);

    @PostMapping("/user/save")
    void save(User user);

    @GetMapping("/user/findById/{id}")
    User findById(@PathVariable("id") Long id);

    @PutMapping("/user/update")
    void update(User user);


}
