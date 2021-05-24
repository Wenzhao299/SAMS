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
 * 换宿表
 */
public class DormitoryExchange {
    private Integer dormitoryExchangeId;    //换宿id
    private String studentAId;              //学生A的学号
    private String studentBId;              //学生B的学号
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date exchangeDate;              //换宿日期
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date recordTime;                //登记时间
    private String remarks;                 //备注
}
