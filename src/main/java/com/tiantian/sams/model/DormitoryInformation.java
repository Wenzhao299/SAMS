package com.tiantian.sams.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DormitoryInformation {

    private Integer dormitoryId;        //寝室id
    private Integer departmentId;       //公寓id
    private String dormitoryNumber;     //寝室号
}
