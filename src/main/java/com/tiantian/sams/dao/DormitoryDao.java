package com.tiantian.sams.dao;

import com.tiantian.sams.model.*;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author: Wenzhao
 * Date: 2021/5/21
 */
@Mapper
@Component
public interface DormitoryDao {
    //入住
    @Insert("insert dormitoryCheckInAndOut values(#{operateId},#{operateName},#{studentId},#{departmentId},#{dormitoryId},#{bedNumber},#{inAndOutDate},#{recordTime},#{remarks})")
    void dormitoryCheckin(DormitoryCheckInAndOut checkin);

    //退宿
    @Insert("insert dormitoryCheckInAndOut values(#{operateId},#{operateName},#{studentId},#{departmentId},#{dormitoryId},#{bedNumber},#{inAndOutDate},#{recordTime},#{remarks})")
    void dormitoryCheckout(DormitoryCheckInAndOut checkout);

    //调宿change
    @Insert("insert dormitoryChange values(#{dormitoryChangeId},#{studentId},#{dormitoryId},#{bedNumber},#{changeDate},#{recordTime},#{remarks})")
    void dormitoryChange(DormitoryChange change);

    //换宿exchange
    @Insert("insert dormitoryExchange values(#{dormitoryExchangeId},#{studentAId},#{studentBId},#{exchangeDate},#{recordTime},#{remarks})")
    void dormitoryExchange(DormitoryExchange exchange);

    //更新寝室表的已入住数、入住状态
    @Update("update dormitory set actualLiveInNumber=#{actualLiveInNumber},bedStatus1=#{bedStatus1},bedStatus2=#{bedStatus2},bedStatus3=#{bedStatus3},bedStatus4=#{bedStatus4} where dormitoryId=#{dormitoryId}")
    void dormitoryUpdate(Dormitory dormitory);

    //根据学号查询stuDorInfoView视图
    @Select("select * from stuDorInfoView where studentId=#{studentId}")
    Student findViewByStudentId(String studentId);

    //查询stuDorInfoView视图
    @Select("select * from stuDorInfoView")
    List<Student> findAllView();
}
