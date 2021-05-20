package com.tiantian.sams.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
/**
 * 管理员信息表
 */
public class AdminInformation {
    private String adminId;         //职工号
    private String departmentId;    //管理的公寓的id
    private String name;            //姓名
    private String sex;             //性别
    private String telephoneNumber; //电话号码
    private String email;           //邮箱
}
