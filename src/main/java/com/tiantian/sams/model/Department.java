package com.tiantian.sams.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Department 表的实体类
 * @author tiantian152
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Department {

    private int departmentId;               // 公寓id
    private String departmentNumber;        // 公寓楼号
    private String campus;                  // 公寓校区
    private String floorNumber;             // 公寓楼层数
    private String dormitoryNumber;         // 公寓寝室数
}
