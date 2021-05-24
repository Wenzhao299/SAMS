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
/**
 * 调宿表
 */
public class DormitoryChange {
    private Integer dormitoryChangeId;  //调宿id
    private String studentId;           //学号
    private Integer dormitoryId;        //调整后的寝室id
    private Integer bedNumber;          //调整后的床位号
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date changeDate;            //调宿日期
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date recordTime;            //登记时间
    private String remarks;             //备注
}
