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
 * 调宿表
 */
public class DormitoryChange {
    private Integer dormitoryChangeId;  //调宿id
    private String studentId;           //学号
    private Integer dormitoryId;        //调整后的寝室id
    private String bedNumber;           //调整后的床位号
    private Date changeDate;            //调宿日期
    private Timestamp recordTime;       //登记时间
    private String remarks;             //备注
}
