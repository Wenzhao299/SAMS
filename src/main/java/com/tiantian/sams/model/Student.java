package com.tiantian.sams.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.sql.Timestamp;
import java.util.Date;


/**
 * 学生表
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Student {
    private String studentId;           //学号
    private String name;                //姓名
    private String sex;                 //性别
    private String studentClass;        //班级
    private String college;             //学院
    private String campus;              //校区，来自stuDorInfoView视图
    private Integer departmentId;       //公寓id，来自stuDorInfoView视图
    private String departmentNumber;   //公寓号，来自stuDorInfoView视图
    private Integer dormitoryId;        //寝室id
    private String dormitoryNumber;    //寝室号，来自stuDorInfoView视图
    private Integer bedNumber;          //床位号
    private String telephoneNumber;     //电话号码
    private String email;               //邮箱
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date checkInDate;           //入住日期
    private Integer bedStatus;          //入住状态（0：不在住，1：在住）
    private Integer stuStatus;          //学籍状态（0：不在籍，1：在籍）
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date recordTime;            //登记时间
}
