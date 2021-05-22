package com.tiantian.sams.controller;

import com.tiantian.sams.dao.StudentDao;
import com.tiantian.sams.model.Dormitory;
import com.tiantian.sams.model.DormitoryCheckInAndOut;
import com.tiantian.sams.model.Student;
import com.tiantian.sams.service.DormitoryService;
import com.tiantian.sams.service.StudentService;
import com.tiantian.sams.service.impl.StudentServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Controller
@RequestMapping("/student")
public class StudentController {
    @Autowired
    private StudentService studentService;

    @Autowired
    private DormitoryService dormitoryService;

    @GetMapping("/findAll")
    public String findAll(Model model){
        //List<Student> students = studentService.findAll();
        List<Student> studentsView = dormitoryService.findAllView();
        //model.addAttribute("students",students);
        model.addAttribute("studentsView",studentsView);
        return "studentList";
    }

    @GetMapping("findByStudentId")
    public String findByStudentId(String studentId, Model model){
        Student student = studentService.findByStudentId(studentId);
        student.setDepartmentId(dormitoryService.findViewByStudentId(studentId).getDepartmentId());
        model.addAttribute("student",student);
        return "updateStudent";
    }

    @GetMapping("/findByDepartmentId")
    public String findByDepartmentId(Integer departmentId, Model model) {
        List<Student> students = studentService.findByDepartmentId(departmentId);
        model.addAttribute("students",students);
        return "studentList";
    }

    @GetMapping("/findByCollege")
    public String findByCollege(String college, Model model) {
        List<Student> students = studentService.findByCollege(college);
        model.addAttribute("students",students);
        return "studentList";
    }

    @GetMapping("/findByStudentClass")
    public String findByStudentClass(String studentClass, Model model) {
        List<Student> students = studentService.findByStudentClass(studentClass);
        model.addAttribute("students",students);
        return "studentList";
    }

    @PostMapping("/update")
    public String update(Student student, DormitoryCheckInAndOut dormitoryCheckInAndOut){
        if(student.getBedStatus()==0) {
            dormitoryCheckInAndOut.setOperateName("退宿");
            dormitoryCheckInAndOut.setDormitoryId(student.getDormitoryId());
            dormitoryCheckInAndOut.setRecordTime(new Date());
            dormitoryCheckInAndOut.setInAndOutDate(new Date());
            dormitoryService.dormitoryCheckout(dormitoryCheckInAndOut);
        }
        studentService.update(student);
        return "redirect:/student/findAll";
    }

    @PostMapping("/addStudent")
    public String addStudent(Student student, DormitoryCheckInAndOut dormitoryCheckInAndOut) throws ParseException {
        student.setRecordTime(new Date());
        studentService.addStudent(student);

        dormitoryCheckInAndOut.setOperateName("入住");
        dormitoryCheckInAndOut.setRecordTime(new Date());
        dormitoryCheckInAndOut.setInAndOutDate(student.getCheckInDate());
        dormitoryService.dormitoryCheckin(dormitoryCheckInAndOut);
        return "redirect:/student/findAll";
    }

    @GetMapping("/toAddStudent")
    public String toAddStudent(){
        return "/addStudent";
    }
}
