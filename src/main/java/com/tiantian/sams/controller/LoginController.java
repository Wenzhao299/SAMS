package com.tiantian.sams.controller;

import com.tiantian.sams.dao.AdminDao;
import com.tiantian.sams.model.Admin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class LoginController {

    @Autowired
    AdminDao adminDao;

    @RequestMapping("/adminLogin")
    public String login(@RequestParam("username") String username,
                        @RequestParam("password") String password,
                        Model model) {
        System.out.println("==================用户登录开始==================");
        Admin loginAdmin = adminDao.selectAdminByAdminIdAndPassword(username, password);
        if (loginAdmin != null) {
            // 如果用户存在
            System.out.println("用户登录成功！！！");
            System.out.println("==================用户登录成功==================");
            return "index";
        } else {
            model.addAttribute("msg","无此用户信息");
            System.out.println("==================用户登录失败==================");
            return "page-login";
        }
    }
}
