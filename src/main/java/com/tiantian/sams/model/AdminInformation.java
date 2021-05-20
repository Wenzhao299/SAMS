package com.tiantian.sams.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AdminInformation {

    private String adminId;                // 管理员id
    private String departmentId;           // 公寓Id
    private String name;                   // 姓名
    private String sex;                    // 性别
    private String telephoneNumber;        // 手机号码
    private String email;                  // 邮箱
}
