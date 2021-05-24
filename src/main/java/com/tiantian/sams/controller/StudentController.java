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
        return "studentList";
    }

    @GetMapping("findByStudentId")
    public String findByStudentId(String studentId, Model model){
        Student student = studentService.findByStudentId(studentId);
        stu = student;
        dor = dormitoryService.findByDorId(stu.getDormitoryId());
        student.setDepartmentId(dormitoryService.findViewByStudentId(studentId).getDepartmentId());
        model.addAttribute("student",student);
        return "updateStudent";
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

    @PostMapping("/update")
    public String update(Student student, DormitoryCheckInAndOut check, DormitoryChange change){
        //更新dormitoryCheckInAndOut
        if (student.getBedStatus()!=stu.getBedStatus() && student.getBedStatus()==0) {
            check.setOperateName("退宿");
            check.setDormitoryId(student.getDormitoryId());
            check.setRecordTime(new Date());
            check.setInAndOutDate(new Date());
            dormitoryService.dormitoryCheckInAndOut(check);
        }else if (student.getBedStatus()!=stu.getBedStatus() && student.getBedStatus()==1) {
            check.setOperateName("入住");
            check.setDormitoryId(student.getDormitoryId());
            check.setRecordTime(new Date());
            check.setInAndOutDate(new Date());
            dormitoryService.dormitoryCheckInAndOut(check);
        }
        //更新dormitoryChange
        if (student.getDepartmentId()!=stu.getDepartmentId() || student.getDormitoryId()!=stu.getDormitoryId() || student.getBedNumber()!=stu.getBedNumber()) {
            switch (stu.getBedNumber()) {
                case 1:dor.setBedStatus1(0);break;
                case 2:dor.setBedStatus2(0);break;
                case 3:dor.setBedStatus3(0);break;
                case 4:dor.setBedStatus4(0);break;
            }
            dormitoryService.dormitoryUpdate(dor);
            change.setChangeDate(new Date());
            change.setRecordTime(new Date());
            dormitoryService.dormitoryChange(change);
        }
        studentService.update(student);
        return "redirect:/student/findAll";
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
