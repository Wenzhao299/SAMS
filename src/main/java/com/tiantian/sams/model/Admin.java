package com.tiantian.sams.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
/**
 * 管理员表
 */
public class Admin {
    private String adminId;    //职工号
    private String password;    //密码
}
