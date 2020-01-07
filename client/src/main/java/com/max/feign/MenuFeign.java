package com.max.feign;

import com.max.entity.Menu;
import com.max.entity.MenuVo;
import com.max.entity.Type;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@FeignClient(value = "menu")
public interface MenuFeign {

    @GetMapping("/menu/findAll/{index}/{limit}")
    MenuVo findAll(@PathVariable("index") Integer index, @PathVariable("limit") Integer limit);

    @DeleteMapping("/menu/deleteById/{id}")
    void deleteById(@PathVariable("id") Long id);

    @GetMapping("/menu/findAllTypes")
    List<Type> findAllTypes();

    @PostMapping("/menu/save")
    void save(Menu menu);

    @PutMapping("/menu/update")
    void update(Menu menu);

    @GetMapping("/menu/findById/{id}")
    Menu findById(@PathVariable("id")Long id);
}


