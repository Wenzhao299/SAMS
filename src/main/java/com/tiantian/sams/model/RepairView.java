package com.tiantian.sams.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RepairView {

    private int repairId;           // 维修id
    private int departmentId;       // 公寓id
    private String departmentNumber;   // 维修内容
    private int dormitoryId;        // 寝室id
    private String dormitoryNumber;   // 维修内容
    private String repairContent;   // 维修内容
    @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm")
    private Date startTime;         // 维修开始时间
    @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm")
    private Date endTime;           // 维修结束时间
    private String status;          // 维修状态
    @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm")
    private Date recordTime;        // 登记时间
    private String remarks;         // 备注
}
