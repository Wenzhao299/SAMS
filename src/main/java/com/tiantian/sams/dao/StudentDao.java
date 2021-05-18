package com.tiantian.sams.dao;

import com.tiantian.sams.model.Student;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Component;

import java.util.List;

@Mapper
@Component
public interface StudentDao {

    @Select("select * from student")
    public List<Student> selectStudent();

    @Select("select * from student where username = #{username} and password = #{password}")
    public Student selectStudentByUsernameAndPassword(@Param("username")String username, @Param("password")String password);

    @Select("select * from student where username = #{username}")
    public Student selectUserByUsername(@Param("username")String username);

    @Insert({"insert into student(username, password) values (#{username},#{password})"})
    @Options(useGeneratedKeys = true, keyProperty = "studentId", keyColumn = "studentId")//加入该注解可以保持对象后，查看对象插入id
    public int insertStudent(Student student);
}
