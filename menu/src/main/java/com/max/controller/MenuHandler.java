package com.max.controller;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.max.entity.Menu;
import com.max.entity.MenuVo;
import com.max.entity.Type;
import com.max.repository.MenuRepository;
import com.max.repository.TypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/menu")
public class MenuHandler {


    @Value("${server.port}")
    private String port;


    @Autowired
    private MenuRepository menuRepository;

    @Autowired
    private TypeRepository typeRepository;


    @GetMapping("/index")
    public String index() {

        return "menu的端口是" + port;
    }


    @RequestMapping("/findAll/{index}/{limit}")
    public MenuVo findAll(@PathVariable("index") Integer index, @PathVariable("limit") Integer limit) {
        Page<Menu> page = PageHelper.startPage(index, limit);
        menuRepository.selectAllJoinType();
        return MenuVo.builder()
                .code(0)
                .count(page.getTotal())
                .data(page.getResult())
                .msg("成功!")
                .build();
    }

    @DeleteMapping("/deleteById/{id}")
    public void deleteById(@PathVariable("id") Long id){
        menuRepository.deleteByPrimaryKey(id);
    }

    @GetMapping("/findAllTypes")
    public List<Type> findAllTypes(){
        return typeRepository.selectAll();
    }

    @PostMapping("/save")
    public void save(@RequestBody Menu menu){
        menuRepository.insert(menu);
    }

    @GetMapping("/findById/{id}")
    public Menu findById(@PathVariable("id") Long id){
        return menuRepository.selectByPrimaryKey(id);
    }

    @PutMapping("/update")
    public void update(@RequestBody Menu menu){
        menuRepository.updateByPrimaryKeySelective(menu);
    }


}
