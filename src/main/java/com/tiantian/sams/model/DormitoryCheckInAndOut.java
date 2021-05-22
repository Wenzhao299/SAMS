package com.tiantian.sams.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.sql.Timestamp;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DormitoryCheckInAndOut {
    private Integer operateId;      //操作id
    private String operateName;     //操作名称（入住、退宿）
    private String studentId;       //学号
    private Integer departmentId;   //公寓id
    private Integer dormitoryId;    //寝室id
    private Integer bedNumber;      //床位号
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date inAndOutDate;      //入住或退宿日期
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date recordTime;        //登记时间
    private String remarks;         //备注
}
