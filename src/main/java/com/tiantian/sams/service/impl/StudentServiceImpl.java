package com.tiantian.sams.service.impl;

import com.tiantian.sams.dao.StudentDao;
import com.tiantian.sams.model.Student;
import com.tiantian.sams.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Component
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentDao studentDao;

    @Override
    public List<Student> selectStudent() {
        return studentDao.selectStudent();
    }

    @Override
    public Student selectStudentByUsernameAndPassword(String username, String password) {
        return studentDao.selectStudentByUsernameAndPassword(username, password);
    }

    @Override
    public Student selectUserByUsername(String username) {
        return studentDao.selectUserByUsername(username);
    }

    @Override
    public int insertStudent(Student student) {
        studentDao.insertStudent(student);
        return student.getStudentId();
    }
}
