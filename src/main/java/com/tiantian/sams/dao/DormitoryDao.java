package com.tiantian.sams.dao;

import com.tiantian.sams.model.DormitoryChange;
import com.tiantian.sams.model.DormitoryCheckInAndOut;
import com.tiantian.sams.model.DormitoryExchange;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;

/**
 * @author: Wenzhao
 * Date: 2021/5/21
 */
@Mapper
@Component
public interface DormitoryDao {
    //入住
    @Insert("insert dormitoryCheckInAndOut values(#{operateId},#{operateName},#{studentId},#{dormitoryId},#{inAndOutTime},#{recordTime},#{remarks})")
    void dormitoryCheckin(DormitoryCheckInAndOut checkin);

    //退宿
    @Insert("insert dormitoryCheckInAndOut values(#{operateId},#{operateName},#{studentId},#{dormitoryId},#{inAndOutTime},#{recordTime},#{remarks})")
    void dormitoryCheckout(DormitoryCheckInAndOut checkout);

    //调宿change
    @Insert("insert dormitoryChange values(#{dormitoryChangeId},#{studentId},#{dormitoryId},#{bedNumber},#{changeDate},#{recordTime},#{remarks})")
    void dormitoryChange(DormitoryChange change);

    //换宿exchange
    @Insert("insert dormitoryExchange values(#{dormitoryExchangeId},#{studentAId},#{studentBId},#{exchangeDate},#{recordTime},#{remarks})")
    void dormitoryExchange(DormitoryExchange exchange);

}
