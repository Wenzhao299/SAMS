package com.tiantian.sams.controller;

import com.tiantian.sams.model.Student;
import com.tiantian.sams.service.StudentService;
import com.tiantian.sams.service.impl.StudentServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;

@Controller
public class LoginController {

    @Autowired
    StudentService studentService = new StudentServiceImpl();

    @RequestMapping("/studentLogin")
    public String login(@RequestParam("username") String username,
                        @RequestParam("password")String password,
                        Model model,
                        HttpSession session) {
        System.out.println("==================用户登录开始==================");

        Student loginStudent = studentService.selectStudentByUsernameAndPassword(username, password);
        if (loginStudent != null) {
            // 如果用户存在
            System.out.println("用户登录成功！！！");
            System.out.println("==================用户登录结束==================");
            return "index";

        } else {
            model.addAttribute("msg","无此用户信息");
            System.out.println("==================用户登录结束==================");
            return "page-login";
        }
    }

}
