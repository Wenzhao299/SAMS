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

    @Insert({"insert into studentInformation(studentId, college, studentClass, studentNumber, name, sex, status, telephoneNumber, birthdate, politicalAppearance, martialStatus, idNumber, nativePlace) " +
            "values (#{studentId},#{college},#{studentClass},#{studentNumber},#{name},#{sex},#{status},#{telephoneNumber},#{birthdate},#{politicalAppearance},#{martialStatus},#{idNumber},#{nativePlace})"})
    public int insertStudent(StudentInformation studentInformation);
}
