package com.tiantian.sams.controller;

import com.tiantian.sams.dao.StudentInformationDao;
import com.tiantian.sams.model.Student;
import com.tiantian.sams.model.StudentInformation;
import com.tiantian.sams.service.StudentService;
import com.tiantian.sams.service.impl.StudentServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;

@Controller
public class RegisterController {

    @Autowired
    StudentService studentService = new StudentServiceImpl();

    @Autowired
    StudentInformationDao studentInformationDao;

    @RequestMapping("/studentRegister")
    public String login(@RequestParam("username") String username,
                        @RequestParam("password")String password,
                        @RequestParam("college")String college,
                        @RequestParam("studentClass")String studentClass,
                        @RequestParam("studentNumber")String studentNumber,
                        @RequestParam("name")String name,
                        @RequestParam("sex")String sex,
                        @RequestParam("status")String status,
                        @RequestParam("telephoneNumber")String telephoneNumber,
                        @RequestParam("Birthdate")String birthdate,
                        @RequestParam("politicalAppearance")String politicalAppearance,
                        @RequestParam("martialStatus")String martialStatus,
                        @RequestParam("idNumber")String idNumber,
                        @RequestParam("nativePlace")String nativePlace,
                        Model model,
                        HttpSession session) {
        System.out.println("==================用户注册开始==================");
        Student registerStudent = new Student(0, username, password);
        int studentId = studentService.insertStudent(registerStudent);
        StudentInformation registerStudentInformation = new StudentInformation(studentId, college, studentClass,
                                                                        studentNumber, name, sex, status,
                                                                        telephoneNumber, birthdate, politicalAppearance,
                                                                        martialStatus, idNumber, nativePlace);
        int result = studentInformationDao.insertStudent(registerStudentInformation);
        if (result > 0) {
            // 上传成功
            System.out.println("==================用户注册成功==================");
            model.addAttribute("username", username);
            model.addAttribute("password", password);
            return "page-login";
        } else {
            model.addAttribute("msg","该用户名已经被使用");
            // 写回除用户名密码之外的全部数据
            model.addAttribute("college", college);
            model.addAttribute("studentClass", studentClass);
            model.addAttribute("studentNumber", studentNumber);
            model.addAttribute("name", name);
            model.addAttribute("sex", sex);
            model.addAttribute("status", status);
            model.addAttribute("telephoneNumber", telephoneNumber);
            model.addAttribute("Birthdate", birthdate);
            model.addAttribute("politicalAppearance", politicalAppearance);
            model.addAttribute("martialStatus", martialStatus);
            model.addAttribute("idNumber", idNumber);
            model.addAttribute("nativePlace", nativePlace);
            System.out.println("==================用户注册失败==================");
            return "page-register";
        }
    }

}
