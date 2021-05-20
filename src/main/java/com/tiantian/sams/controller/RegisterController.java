package com.tiantian.sams.controller;

import com.tiantian.sams.dao.AdminDao;
import com.tiantian.sams.dao.AdminInformationDao;
import com.tiantian.sams.dao.DepartmentDao;
import com.tiantian.sams.model.Admin;
import com.tiantian.sams.model.AdminInformation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class RegisterController {

    @Autowired
    AdminDao adminDao;

    @Autowired
    AdminInformationDao adminInformationDao;

    @Autowired
    DepartmentDao departmentDao;

    @RequestMapping("/adminRegister")
    public String register(@RequestParam("adminId") String adminId,
                        @RequestParam("password")String password,
                        @RequestParam("departmentId")String departmentId,
                        @RequestParam("name")String name,
                        @RequestParam("sex")String sex,
                        @RequestParam("telephoneNumber")String telephoneNumber,
                        @RequestParam("email")String email,
                        Model model) {
        System.out.println("==================用户注册开始==================");
        // 保存管理员用户名和密码
        Admin registerAdmin = new Admin(adminId, password);
        int insertAdminResult = adminDao.insertAdmin(registerAdmin);
        // 保存管理员其他信息
        AdminInformation adminInformation = new AdminInformation(adminId, departmentId, name, sex, telephoneNumber, email);
        int result = adminInformationDao.insertAdmin(adminInformation);
        if (result > 0) {
            // 上传成功
            System.out.println("==================用户注册成功==================");
            model.addAttribute("adminId", adminId);
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

    @GetMapping("/myRegister")
    public String register(Model model) {
        System.out.println("==================读取用户注册所需信息开始==================");
        // 查询楼号信息
        List<Integer> departmentIdList = departmentDao.selectDepartmentId();
        System.out.println("departmentIdList="+departmentIdList);
        model.addAttribute("departmentIdList",departmentIdList);
        System.out.println("==================读取用户注册所需信息结束==================");
        return "page-register";
    }

}
