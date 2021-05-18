package com.tiantian.sams.service;

import com.tiantian.sams.model.Student;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface StudentService {

    public List<Student> selectStudent();

    public Student selectStudentByUsernameAndPassword(String username, String password);

    public Student selectUserByUsername(String username);

    public int insertStudent(Student student);
}
