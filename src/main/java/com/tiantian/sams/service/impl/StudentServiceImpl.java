package com.tiantian.sams.service.impl;

import com.tiantian.sams.model.Student;
import com.tiantian.sams.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class StudentServiceImpl implements StudentService {
    @Autowired
    private StudentService studentService;

    @Override
    public Student findByDepartmentId(Integer departmentId) {
        return studentService.findByDepartmentId(departmentId);
    }

    @Override
    public Student findByCollege(String college) {
        return studentService.findByCollege(college);
    }

    @Override
    public Student findByStudentClass(String studentClass) {
        return studentService.findByStudentClass(studentClass);
    }

    @Override
    public List<Student> findAll() {
        return studentService.findAll();
    }
}
