package com.tiantian.sams.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

/**
 * VisitorView 视图的实体类
 * @author tiantian152
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class VisitorDormitoryView {

    private int visitorId;                  // 来访id
    private String visitorName;             // 访问者
    private String visitorTelephoneNumber;  // 访问者电话
    private Integer departmentId;            // 公寓id
    private String departmentNumber;        // 公寓号
    private Integer dormitoryId;             // 寝室id
    private String dormitoryNumber;        // 寝室号
    private String status;                  // 状态 (访问中、访问结束)
    @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm")
    private Date visitStartTime;            // 来访开始时间
    @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm")
    private Date visitEndTime;              // 来访结束时间
    @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm")
    private Date recordTime;                // 登记时间
    private String remarks;                 // 备注
}
