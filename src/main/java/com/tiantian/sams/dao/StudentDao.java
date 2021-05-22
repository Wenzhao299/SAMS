package com.tiantian.sams.dao;

import com.tiantian.sams.model.Student;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Component;

import java.util.List;

@Mapper
@Component
public interface StudentDao {
    //按楼查看
    @Select("select * from student where dormitoryId in (select dormitoryId from dormitory where departmentId=#{departmentId})")
    List<Student> findByDepartmentId(@Param("departmentId") Integer departmentId);

    //按学院查看
    @Select("select * from student where college = #{college}")
    List<Student> findByCollege(@Param("college") String college);

    //按班级查看
    @Select("select * from student where studentClass = #{studentClass}")
    List<Student> findByStudentClass(@Param("studentClass") String studentClass);

    //查询全部
    @Select("select * from student")
    List<Student> findAll();

    //按学号查看
    @Select("select * from stuDorInfoView where studentId = #{studentId}")
    Student findByStudentId(String studentId);

    //更新学生信息
    @Update("update student set name=#{name},sex=#{sex},studentClass=#{studentClass},college=#{college}," +
            "dormitoryId=#{dormitoryId},bedNumber=#{bedNumber},telephoneNumber=#{telephoneNumber},email=#{email}," +
            "checkInDate=#{checkInDate},bedStatus=#{bedStatus},stuStatus=#{stuStatus},recordTime=#{recordTime} where studentId = #{studentId}")
    void update(Student student);

    //增加学生
    @Insert("insert into student values(#{studentId},#{name},#{sex},#{studentClass},#{college}," +
            "#{dormitoryId},#{bedNumber},#{telephoneNumber},#{email},#{checkInDate},#{bedStatus},#{stuStatus},#{recordTime})")
    void addStudent(Student student);
}
