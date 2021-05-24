package com.tiantian.sams.controller;

import com.tiantian.sams.model.Dormitory;
import com.tiantian.sams.model.DormitoryChange;
import com.tiantian.sams.model.DormitoryCheckInAndOut;
import com.tiantian.sams.model.Student;
import com.tiantian.sams.service.DormitoryService;
import com.tiantian.sams.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/student")
public class StudentController {
    @Autowired
    private StudentService studentService;

    @Autowired
    private DormitoryService dormitoryService;

    private Student stu;
    private Dormitory dor;

    @GetMapping("/findAll")
    public String findAll(Model model){
        //List<Student> students = studentService.findAll();
        List<Student> studentsView = dormitoryService.findAllView();
        //model.addAttribute("students",students);
        model.addAttribute("studentsView",studentsView);
        return "quireStudentAll";
    }

    @GetMapping("findByStudentId")
    public String findByStudentId(String studentId, String quireType, Model model){
        Student student = studentService.findByStudentId(studentId);
        stu = student;
        dor = dormitoryService.findByDorId(stu.getDormitoryId());
        student.setDepartmentId(dormitoryService.findViewByStudentId(studentId).getDepartmentId());
        model.addAttribute("student",student);
        if(quireType.equals("checkIn")) {
            return "updateStudentCheckIn";
        }else if(quireType.equals("checkOut")) {
            return "updateStudentCheckOut";
        }else if(quireType.equals("change")) {
            return "updateStudentChange";
        }else {
            return "page-404";
        }
    }

    @GetMapping("/findByDepartmentId")
    public String findByDepartmentId(Integer departmentId, Model model) {
        List<Student> studentsView = studentService.findViewByDepartmentId(departmentId);
        model.addAttribute("studentsView",studentsView);
        return "quireStudentByDepartmentId";
    }

    @GetMapping("/findByCollege")
    public String findByCollege(String college, Model model) {
        List<Student> studentsView = studentService.findByCollege(college);
        model.addAttribute("studentsView",studentsView);
        return "quireStudentByCollege";
    }

    @GetMapping("/findByStudentClass")
    public String findByStudentClass(String studentClass, Model model) {
        List<Student> studentsView = studentService.findByStudentClass(studentClass);
        model.addAttribute("studentsView",studentsView);
        return "quireStudentByStudentClass";
    }

    private void fun_updateInAndOut(Student student, DormitoryCheckInAndOut check) {
        check.setDepartmentId(student.getDepartmentId());
        check.setDormitoryId(student.getDormitoryId());
        check.setBedNumber(student.getBedNumber());
        check.setRecordTime(new Date());
        check.setInAndOutDate(new Date());
        dormitoryService.dormitoryCheckInAndOut(check);
        studentService.update(student);
    }
    @GetMapping("/updateInAndOut")
    public String updateInAndOut(String studentId, DormitoryCheckInAndOut check, String operateType){
        Student student = studentService.findByStudentId(studentId);
        //更新dormitoryCheckInAndOut
        if (operateType.equals("checkIn") && student.getBedStatus()!=1) {
            check.setOperateName("入住");
            student.setBedStatus(1);
            fun_updateInAndOut(student, check);
        }else if (operateType.equals("checkOut") && student.getBedStatus()!=0) {
            check.setOperateName("退宿");
            student.setBedStatus(0);
            fun_updateInAndOut(student, check);
        }

        if (operateType.equals("checkIn")) {
            String url = "?studentId="+student.getStudentId()+"&quireType=checkIn";
            return "redirect:/student/findByStudentId"+url;
        }else if (operateType.equals("checkOut")) {
            String url = "?studentId="+student.getStudentId()+"&quireType=checkOut";
            return "redirect:/student/findByStudentId"+url;
        }else {
            return "page-404";
        }
    }

    @PostMapping("/addStudent")
    public String addStudent(Student student, DormitoryCheckInAndOut check) {
        student.setRecordTime(new Date());
        studentService.addStudent(student);

        check.setOperateName("入住");
        check.setDormitoryId(student.getDormitoryId());
        check.setRecordTime(new Date());
        check.setInAndOutDate(new Date());
        dormitoryService.dormitoryCheckInAndOut(check);

        return "redirect:/student/findAll";
    }

    @GetMapping("/toAddStudent")
    public String toAddStudent(){
        return "/addStudent";
    }

    @GetMapping("/toDormitoryExchange")
    public String toDormitoryExchange(){
        return "/exchangeStudent";
    }
}
