package com.tiantian.sams.service.impl;

import com.tiantian.sams.dao.StudentDao;
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
    private StudentDao studentDao;

    @Override
    public List<Student> findByDepartmentId(Integer departmentId) {
        return studentDao.findByDepartmentId(departmentId);
    }

    @Override
    public List<Student> findViewByDepartmentId(Integer departmentId) {
        return studentDao.findViewByDepartmentId(departmentId);
    }

    @Override
    public List<Student> findByCollege(String college) {
        return studentDao.findByCollege(college);
    }

    @Override
    public List<Student> findByStudentClass(String studentClass) {
        return studentDao.findByStudentClass(studentClass);
    }

    @Override
    public List<Student> findAll() {
        return studentDao.findAll();
    }

    @Override
    public Student findByStudentId(String studentId) {
        return studentDao.findByStudentId(studentId);
    }

    @Override
    public void update(Student student) {
        studentDao.update(student);
    }

    @Override
    public void addStudent(Student student) {
        studentDao.addStudent(student);
    }
}
