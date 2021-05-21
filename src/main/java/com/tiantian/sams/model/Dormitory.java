package com.tiantian.sams.model;

import lombok.Data;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
/**
 * 寝室表
 */
public class Dormitory {

    private Integer dormitoryId;        //寝室id
    private Integer departmentId;       //公寓id
    private String dormitoryNumber;     //寝室号
    private String liveInNumber;        //可入住数
    private String actualLiveInNumber;  //已入住数
    private String bedStatus;           //入住状态
}
