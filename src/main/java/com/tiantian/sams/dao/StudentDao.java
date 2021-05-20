package com.tiantian.sams.dao;

import com.tiantian.sams.model.Student;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;

@Mapper
@Component
public interface StudentDao {
    //按楼查看
    @Select("select * from student where dormitoryId = #{select dormitoryId from dormitory where departmentId = #{departmentId}}")
    Student findByDepartmentId(@Param("departmentId") Integer departmentId);

    //按学院查看
    @Select("select * from student where college = #{college}")
    Student findByCollege(@Param("college") String college);

    //按班级查看
    @Select("select * from student where studentClass = #{studentClass}")
    Student findByStudentClass(@Param("studentClass") String studentClass);

    //查询全部
    @Select("select * from student")
    Student findAll();
}
