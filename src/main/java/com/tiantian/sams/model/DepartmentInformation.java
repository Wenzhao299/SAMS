package com.tiantian.sams.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DepartmentInformation {

    private Integer departmentId;       //公寓id
    private String departmentNumber;     //公寓号
}
