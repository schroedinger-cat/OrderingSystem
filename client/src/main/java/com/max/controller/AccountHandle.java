package com.max.controller;

import com.max.entity.Admin;
import com.max.entity.User;
import com.max.feign.AccountFeign;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;
import java.util.LinkedHashMap;

@Controller
@RequestMapping("/account")
public class AccountHandle {

    @Autowired
    private AccountFeign accountFeign;

    @PostMapping("/login")
    public String login(String username, String password, String type, HttpSession session) {
        Object object = accountFeign.login(username, password, type);  // object类型为LinkedHashMap
        LinkedHashMap<String, Object> hashMap = (LinkedHashMap<String, Object>) object;
        String result = null;

        if (object == null) {
            result = "login";
        } else {
            switch (type) {
                case "user":

                    String uStrId = String.valueOf(hashMap.get("id"));
                    Long uid = Long.parseLong(uStrId);

                    User user = User.builder()
                            .id((uid))
                            .nickname((String) hashMap.get("nickname")).build();
                    session.setAttribute("user", user);
                    result = "index";
                    break;
                case "admin":
                    String aStrId = String.valueOf(hashMap.get("id"));
                    Long aid = Long.parseLong(aStrId);

                    Admin admin = Admin.builder()
                            .id(aid)
                            .username((String) hashMap.get("username"))
                            .build();
                    session.setAttribute("admin", admin);
                    result = "redirect:/main";
                    break;
            }

        }

        return result;
    }

    @RequestMapping("/logout")
    public String logout(HttpSession session) {
        session.invalidate();
        return "redirect:/login"; // 这里的重定向到页面 以get方式 会走视图解析器 并不会走@PostMapping("/login")的方法

    }


}
