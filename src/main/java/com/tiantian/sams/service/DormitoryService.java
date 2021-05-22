package com.tiantian.sams.service;

import com.tiantian.sams.model.*;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

/**
 * @author: Wenzhao
 * Date: 2021/5/21
 */
public interface DormitoryService {
    //入住
    void dormitoryCheckin(DormitoryCheckInAndOut checkin);

    //退宿
    void dormitoryCheckout(DormitoryCheckInAndOut checkout);

    //调宿change
    void dormitoryChange(DormitoryChange change);

    //换宿exchange
    void dormitoryExchange(DormitoryExchange exchange);

    //更新寝室表的已入住数、入住状态
    void dormitoryUpdate(Dormitory dormitory);

    //根据学号查询视图
    Student findViewByStudentId(String studentId);

    //查询stuDorInfoView视图
    List<Student> findAllView();
}
