package com.tiantian.sams.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RecordView {

    private Integer recordId;       // 登记id
    private String type;            // 登记类型（晚出、晚归）
    @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm")
    private Date inAndOutTime;      // 晚出或晚归时间
    private String studentId;       // 学号
    private String name;            // 学生姓名
    private Integer departmentId;   // 公寓id
    private String departmentNumber;// 公寓号
    private Integer dormitoryId;    // 寝室id
    private String dormitoryNumber; // 寝室号
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date recordTime;        // 登记时间
    private String remarks;         // 备注
}
