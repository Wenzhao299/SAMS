package com.tiantian.sams.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Visitor 表的实体类
 * @author tiantian152
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Visitor {

    private int visitorId;                  // 来访id
    private String visitorName;             // 访问者
    private String visitorTelephoneNumber;  // 访问者电话
    private String visitedStudentId;        // 被访学生学号
    private String departmentId;            // 公寓id
    private String dormitoryId;             // 寝室id
    private String remarks;                 // 备注
    private String status;                  // 状态
    private String visitStartTime;          // 来访开始时间
    private String visitEndTime;            // 来访结束时间
    private String recordTime;              // 登记时间
}
