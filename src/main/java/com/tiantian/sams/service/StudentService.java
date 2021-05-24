package com.tiantian.sams.service;

import com.tiantian.sams.model.Student;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface StudentService {
    //按楼查看
    List<Student> findByDepartmentId(Integer departmentId);

    //按楼查看
    List<Student> findViewByDepartmentId(@Param("departmentId") Integer departmentId);

    //按学院查看
    List<Student> findByCollege(String college);

    //按班级查看
    List<Student> findByStudentClass(String studentClass);

    //查询全部
    List<Student> findAll();

    //按学号查看
    Student findByStudentId(String studentId);

    //更新学生信息
    void update(Student student);

    //添加学生
    void addStudent(Student student);
}
