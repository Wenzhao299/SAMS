package com.tiantian.sams.controller;

import com.tiantian.sams.model.Student;
import com.tiantian.sams.service.StudentService;
import com.tiantian.sams.service.impl.StudentServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/student")
public class StudentController {
    @Autowired
    StudentService studentService = new StudentServiceImpl();

    @GetMapping("/findAll")
    public String findAll(Model model){
        List<Student> students = studentService.findAll();
        model.addAttribute("students",students);
        return "student/studentList";
    }

    @GetMapping("/findByDepartmentId")
    public String findByDepartmentId(Integer departmentId, Model model) {
        Student students = studentService.findByDepartmentId(departmentId);
        model.addAttribute("students",students);
        return "student/studentList";
    }

    @GetMapping("/findByCollege")
    public String findByCollege(String college, Model model) {
        Student students = studentService.findByCollege(college);
        model.addAttribute("students",students);
        return "student/studentList";
    }

    @GetMapping("/findByStudentClass")
    public String findByStudentClass(String studentClass, Model model) {
        Student students = studentService.findByStudentClass(studentClass);
        model.addAttribute("students",students);
        return "student/studentList";
    }
}
