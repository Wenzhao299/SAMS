package com.tiantian.sams.controller;

import com.tiantian.sams.dao.AdminInformationDao;
import com.tiantian.sams.model.Admin;
import com.tiantian.sams.model.AdminInformation;
import com.tiantian.sams.service.AdminService;
import com.tiantian.sams.service.impl.AdminServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;

@Controller
public class RegisterController {

    @Autowired
    AdminService adminService = new AdminServiceImpl();

    @Autowired
    AdminInformationDao adminInformationDao;

    @RequestMapping("/adminRegister")
    public String register(@RequestParam("username") String username,
                        @RequestParam("password")String password,
                        @RequestParam("DepartmentNumber")String departmentNumber,
                        Model model) {
        System.out.println("==================用户注册开始==================");
        // 保存管理员用户名和密码
        Admin registerAdmin = new Admin(0, username, password);
        int adminId = adminService.insertAdmin(registerAdmin);
        // 保存管理员其他信息
        AdminInformation adminInformation = new AdminInformation(adminId, departmentNumber);
        int result = adminInformationDao.insertAdmin(adminInformation);
        if (result > 0) {
            // 上传成功
            System.out.println("==================用户注册成功==================");
            model.addAttribute("username", username);
            model.addAttribute("password", password);
            return "page-login";
        } else {
            model.addAttribute("msg","该用户名已经被使用");
            // 写回除用户名密码之外的全部数据
            model.addAttribute("AdminInformation", adminInformation);
            System.out.println("==================用户注册失败==================");
            return "page-register";
        }
    }

}
