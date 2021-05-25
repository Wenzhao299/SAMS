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
        }else if(quireType.equals("bysCheckOut")) {
            return "updateBYSStudentCheckOut";
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
    public String updateInAndOut(String studentId, DormitoryCheckInAndOut check, String operateType, Model model){
        Student student = studentService.findByStudentId(studentId);
        //更新dormitoryCheckInAndOut
        if (operateType.equals("checkIn") && student.getBedStatus()!=1) {
            check.setOperateName("入住");
            student.setBedStatus(1);
            fun_updateInAndOut(student, check);
            System.out.println("入住成功！");
            model.addAttribute("message","入住成功！");
            return "updateStudentCheckInQuire";
        }else if (operateType.equals("checkOut") && student.getBedStatus()!=0) {
            check.setOperateName("退宿");
            student.setBedStatus(0);
            fun_updateInAndOut(student, check);
            System.out.println("退宿成功！");
            model.addAttribute("message","退宿成功！");
            return "updateStudentCheckOutQuire";
        }else if (operateType.equals("bysCheckOut") && student.getBedStatus()!=0) {
            check.setOperateName("退宿");
            student.setBedStatus(0);
            student.setStuStatus(0);
            fun_updateInAndOut(student, check);
            System.out.println("退宿成功！");
            model.addAttribute("message","退宿成功！");
            return "updateBYSStudentCheckOutQuire";
        }
        System.out.println("操作失败，不可重复操作！");
        model.addAttribute("message","操作失败，不可重复操作！");
        return "updateStudentCheckInQuire";
    }

    @PostMapping("/updateChange")
    public String updateChange(Student student, DormitoryChange change, Model model) {
        switch (student.getBedNumber()) {
            case 1:
                if (dormitoryService.findBed1ByDormitoryId(student.getDormitoryId())==1){
                    model.addAttribute("message","当前床位有人，调宿失败！");
                    System.out.println("当前床位有人，调宿失败！");
                } return "updateStudentChangeQuire";
            case 2:
                if (dormitoryService.findBed2ByDormitoryId(student.getDormitoryId())==1){
                    model.addAttribute("message","当前床位有人，调宿失败！");
                    System.out.println("当前床位有人，调宿失败！");
                } return "updateStudentChangeQuire";
            case 3:
                if (dormitoryService.findBed3ByDormitoryId(student.getDormitoryId())==1){
                    model.addAttribute("message","当前床位有人，调宿失败！");
                    System.out.println("当前床位有人，调宿失败！");
                } return "updateStudentChangeQuire";
            case 4:
                if (dormitoryService.findBed4ByDormitoryId(student.getDormitoryId())==1){
                    model.addAttribute("message","当前床位有人，调宿失败！");
                    System.out.println("当前床位有人，调宿失败！");
                } return "updateStudentChangeQuire";
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
            studentService.update(student);
        }
        model.addAttribute("message","调宿成功！");
        return "updateStudentChangeQuire";
    }

    @PostMapping("/addStudent")
    public String addStudent(Student student, DormitoryCheckInAndOut check, Model model) {
        Student studentDB = studentService.findByStudentId(student.getStudentId());
        if(studentDB!=null) {
            model.addAttribute("message","学号已被占用！");
            return "addStudent";
        }
        switch (student.getBedNumber()) {
            case 1:
                if (dormitoryService.findBed1ByDormitoryId(student.getDormitoryId())==1){
                    model.addAttribute("message","当前床位有人，入住失败！");
                    System.out.println("当前床位有人，入住失败！");
                    return "addStudent";
                } break;
            case 2:
                if (dormitoryService.findBed2ByDormitoryId(student.getDormitoryId())==1){
                    model.addAttribute("message","当前床位有人，入住失败！");
                    System.out.println("当前床位有人，入住失败！");
                    return "addStudent";
                } break;
            case 3:
                if (dormitoryService.findBed3ByDormitoryId(student.getDormitoryId())==1){
                    model.addAttribute("message","当前床位有人，入住失败！");
                    System.out.println("当前床位有人，入住失败！");
                    return "addStudent";
                } break;
            case 4:
                if (dormitoryService.findBed4ByDormitoryId(student.getDormitoryId())==1){
                    model.addAttribute("message","当前床位有人，入住失败！");
                    System.out.println("当前床位有人，入住失败！");
                    return "addStudent";
                } break;
        }
        student.setRecordTime(new Date());
        studentService.addStudent(student);

        check.setOperateName("入住");
        check.setDormitoryId(student.getDormitoryId());
        check.setRecordTime(new Date());
        check.setInAndOutDate(new Date());
        dormitoryService.dormitoryCheckInAndOut(check);

        return "addStudent";
    }

    @GetMapping("/toAddStudent")
    public String toAddStudent(){
        return "/addStudent";
    }

    @GetMapping("/toDormitoryExchange")
    public String toDormitoryExchange(){
        return "updateStudentExchange";
    }
}
