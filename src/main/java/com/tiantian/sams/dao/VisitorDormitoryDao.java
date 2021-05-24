package com.tiantian.sams.dao;

import com.tiantian.sams.model.Visitor;
import com.tiantian.sams.model.VisitorDormitory;
import com.tiantian.sams.model.VisitorDormitoryView;
import com.tiantian.sams.model.VisitorStudentView;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Visitor 表的操作实现
 * @author tiantian152
 */
@Mapper
@Component
public interface VisitorDormitoryDao {

    /**
     * 查询所有的 visitorDormitory 信息
     * @author tiantian152
     * @return Visitor实体类列表
     */
    @Select("select * from visitorDormitory")
    public List<Visitor> selectVisitorDormitory();

    /**
     * 查询所有的 visitorDormitoryView 信息
     * @author tiantian152
     * @return VisitorView实体类列表
     */
    @Select("select * from visitorDormitoryView")
    public List<VisitorDormitoryView> selectVisitorDormitoryView();

    /**
     * 插入 visitorDormitory 信息
     * @author tiantian152
     * @return 插入结果
     */
    @Insert({"insert into visitorDormitory(visitorName, visitorTelephoneNumber, departmentId, dormitoryId, remarks, status, visitStartTime, visitEndTime, recordTime) " +
            "values(#{visitorName}, #{visitorTelephoneNumber}, #{departmentId}, #{dormitoryId}, #{remarks}, #{status}, #{visitStartTime}, #{visitEndTime}, #{recordTime})"})
    public int insertVisitorDormitory(VisitorDormitory visitorDormitory);

    /**
     * 插入 访问结束时间
     * @author tiantian152
     * @return 插入结果
     */
    @Update("update visitorDormitory set status=#{status},visitEndTime=#{visitEndTime} where visitorId = #{visitorId}")
    public int updateVisitorDormitoryEndTime(VisitorDormitory visitorDormitory);
}
