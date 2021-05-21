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
    private Integer dormitoryId;    //寝室id
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date inAndOutTime; //入住或退宿时间
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date recordTime;   //登记时间
    private String remarks;         //备注
}
