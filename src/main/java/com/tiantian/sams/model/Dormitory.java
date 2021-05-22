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
    private Integer liveInNumber;        //可入住数
    private Integer actualLiveInNumber;  //已入住数
    private String bedStatus1;           //1号床入住状态
    private String bedStatus2;           //2号床入住状态
    private String bedStatus3;           //3号床入住状态
    private String bedStatus4;           //4号床入住状态
}
