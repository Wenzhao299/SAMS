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

    /**
     * 查询所有的 Dormitory 中 dormitoryId（寝室id） 信息
     * @author tiantian152
     * @return dormitoryIdList
     */
    @Select("select dormitoryId from dormitory")
    public List<Integer> selectDormitoryId();

    /**
     * 查询所有的 Dormitory 中 dormitoryId（寝室id）和 dormitoryName 信息
     * @author tiantian152
     * @return DormitoryInformationList
     */
    @Select("select dormitoryId,departmentId,dormitoryNumber from dormitory")
    public List<DormitoryInformation> selectDormitoryInformation();

    //入住、退宿
    @Insert("insert into dormitoryCheckInAndOut values(#{operateId},#{operateName},#{studentId},#{departmentId},#{dormitoryId},#{bedNumber},#{inAndOutDate},#{recordTime},#{remarks})")
    void dormitoryCheckInAndOut(DormitoryCheckInAndOut check);

    //调宿change
    @Insert("insert into dormitoryChange values(#{dormitoryChangeId},#{studentId},#{dormitoryId},#{bedNumber},#{changeDate},#{recordTime},#{remarks})")
    void dormitoryChange(DormitoryChange change);

    //换宿exchange
    @Insert("insert into dormitoryExchange values(#{dormitoryExchangeId},#{studentAId},#{studentBId},#{exchangeDate},#{recordTime},#{remarks})")
    void dormitoryExchange(DormitoryExchange exchange);

    //更新寝室表的床状态
    @Update("update dormitory set bedStatus1=#{bedStatus1},bedStatus2=#{bedStatus2},bedStatus3=#{bedStatus3},bedStatus4=#{bedStatus4} where dormitoryId=#{dormitoryId}")
    void dormitoryUpdate(Dormitory dormitory);

    //通过寝室id查询寝室表
    @Select("select * from dormitory where dormitoryId=#{dormitoryId}")
    Dormitory findByDorId(Integer dormitoryId);

    //根据学号查询stuDorInfoView视图
    @Select("select * from stuDorInfoView where studentId=#{studentId}")
    Student findViewByStudentId(String studentId);

    //查询stuDorInfoView视图
    @Select("select * from stuDorInfoView")
    List<Student> findAllView();

    //根据寝室id查询1号床状态，判断能否调宿
    @Select("select bedStatus1 from dormitory where dormitoryId=#{dormitoryId}")
    Integer findBed1ByDormitoryId(Integer dormitoryId);

    //根据寝室id查询2号床状态，判断能否调宿
    @Select("select bedStatus2 from dormitory where dormitoryId=#{dormitoryId}")
    Integer findBed2ByDormitoryId(Integer dormitoryId);

    //根据寝室id查询3号床状态，判断能否调宿
    @Select("select bedStatus3 from dormitory where dormitoryId=#{dormitoryId}")
    Integer findBed3ByDormitoryId(Integer dormitoryId);

    //根据寝室id查询4号床状态，判断能否调宿
    @Select("select bedStatus4 from dormitory where dormitoryId=#{dormitoryId}")
    Integer findBed4ByDormitoryId(Integer dormitoryId);
}
