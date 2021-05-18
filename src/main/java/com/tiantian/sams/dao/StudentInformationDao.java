package com.tiantian.sams.dao;

import com.tiantian.sams.model.Student;
import com.tiantian.sams.model.StudentInformation;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Component;

import java.util.List;

@Mapper
@Component
public interface StudentInformationDao {

    @Select("select * from studentInformation")
    public List<StudentInformation> selectStudentInformation();

    @Select("select * from studentInformation where studentId = #{studentId}")
    public StudentInformation selectUserByStudentId(@Param("studentId")int studentId);

//    studentId, college, studentClass, studentNumber, name, sex, status, telephoneNumber, birthdate, politicalAppearance, martialStatus, idNumber, nativePlace
    @Insert({"insert into studentInformation(username, password) values (#{username},#{password})"})
    @Options(useGeneratedKeys = true, keyProperty = "studentId", keyColumn = "studentId")//加入该注解可以保持对象后，查看对象插入id
    public int insertStudent(StudentInformation studentInformation);
}
