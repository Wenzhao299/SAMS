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

    private Integer dormitoryId;        //寝室id
    private Integer departmentId;       //公寓id
    private String dormitoryNumber;     //寝室号
    private Integer liveInNumber;        //可入住数
    private Integer actualLiveInNumber;  //已入住数
    private Integer bedStatus1;           //1号床入住状态
    private Integer bedStatus2;           //2号床入住状态
    private Integer bedStatus3;           //3号床入住状态
    private Integer bedStatus4;           //4号床入住状态
}
