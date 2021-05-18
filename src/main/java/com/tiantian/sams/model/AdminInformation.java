package com.tiantian.sams.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AdminInformation {

    private int adminId;                // 管理员id
    private String departmentNumber;    // 楼号
}
