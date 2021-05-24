package com.tiantian.sams.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Department 公寓表的实体类
 * @author tiantian152
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Department {

    private Integer departmentId;               // 公寓id
    private String departmentNumber;        // 公寓楼号
    private String campus;                  // 公寓校区
    private Integer floorNumber;            // 公寓楼层数
    private Integer dormitoryNumber;        // 公寓寝室数
}
