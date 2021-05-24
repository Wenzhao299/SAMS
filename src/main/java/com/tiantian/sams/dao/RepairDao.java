package com.tiantian.sams.dao;

import com.tiantian.sams.model.Repair;
import com.tiantian.sams.model.RepairView;
import com.tiantian.sams.model.Visitor;
import com.tiantian.sams.model.VisitorStudentView;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Repair 表的操作实现
 * @author tiantian152
 */
@Mapper
@Component
public interface RepairDao {

    /**
     * 查询所有的 repair 信息
     * @author tiantian152
     * @return Repair实体类列表
     */
    @Select("select * from repair")
    public List<Repair> selectRepair();

    /**
     * 查询所有的 repairView 信息
     * @author tiantian152
     * @return RepairView实体类列表
     */
    @Select("select * from repairView")
    public List<RepairView> selectRepairView();


    /**
     * 插入 repair 信息
     * @author tiantian152
     * @return 插入结果
     */
    @Insert({"insert into repair(departmentId, dormitoryId, repairContent, startTime, endTime, status, recordTime, remarks) " +
            "values(#{departmentId}, #{dormitoryId}, #{repairContent}, #{startTime}, #{endTime}, #{status}, #{recordTime}, #{remarks})"})
    public int insertRepair(Repair repair);

    /**
     * 更新维修状态和时间
     * @author tiantian152
     * @return 更新结果
     */
    @Update("update repair set status=#{status},endTime=#{endTime} where repairId = #{repairId}")
    public int updateEndTime(Repair repair);

}
