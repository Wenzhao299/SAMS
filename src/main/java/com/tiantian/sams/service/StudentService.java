package com.tiantian.sams.service;

import com.tiantian.sams.model.Student;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface StudentService {
    //按楼查看
    Student findByDepartmentId(Integer departmentId);

    //按学院查看
    Student findByCollege(String college);

    //按班级查看
    Student findByStudentClass(String studentClass);

    //查询全部
    List<Student> findAll();
}
