package com.tiantian.sams.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
/**
 * 学生表
 */
public class Student {
    private String studentId;       //学号
    private String name;            //姓名
    private String sex;             //性别
    private String studentClass;    //班级
    private String college;         //学院
    private Integer dormitoryId;    //寝室id
    private String bedNumber;       //床位号
    private String telephoneNumber; //电话号码
    private String email;           //邮箱
    private Date checkInDate;       //入住日期
    private Timestamp datetime;     //登记时间

}
