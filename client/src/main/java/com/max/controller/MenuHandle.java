package com.max.controller;

import com.max.entity.Menu;
import com.max.entity.MenuVo;
import com.max.entity.Type;
import com.max.feign.MenuFeign;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import java.util.List;


@Controller
@RequestMapping("/menu")
public class MenuHandle {

    @Autowired
    private MenuFeign menuFeign;

    @RequestMapping("/findAll")
    @ResponseBody
    public MenuVo findAll(@RequestParam("page") Integer page, @RequestParam("limit") Integer limit) {
        return menuFeign.findAll(page, limit);
    }

    @GetMapping("/deleteById/{id}")
    public String deleteById(@PathVariable("id") Long id) {
        menuFeign.deleteById(id);
        return "redirect:/menu_manage";
    }

    @GetMapping("/findAllTypes")
    public String findAllTypes(Model model) {
        List<Type> types = menuFeign.findAllTypes();
        model.addAttribute("types", types);
        return "menu_add";
    }

    @PostMapping("/save")
    public String save(Menu menu) {
        menuFeign.save(menu);
        return "redirect:/menu_manage";
    }


    /**
     * 回显时候查询也可以不进行关联对象查询 使用通用Mapper单表查询时 封装外键字段 即可
     *
     * @param id
     * @param model
     * @return
     */
    @GetMapping("/findById/{id}")
    public String findById(@PathVariable("id") Long id, Model model) {
        Menu menu = menuFeign.findById(id);
        List<Type> types = menuFeign.findAllTypes();
        model.addAttribute("menu", menu);
        model.addAttribute("types", types);
        return "menu_add";
    }


    @PostMapping("/update")
    public String update(Menu menu) {
        menuFeign.update(menu);
        return "redirect:/menu_manage";
    }


}
