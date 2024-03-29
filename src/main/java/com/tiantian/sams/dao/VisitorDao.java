package com.tiantian.sams.dao;

import com.tiantian.sams.model.Visitor;
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
public interface VisitorDao {

    /**
     * 查询所有的 visitor 信息
     * @author tiantian152
     * @return Visitor实体类列表
     */
    @Select("select * from visitor")
    public List<Visitor> selectVisitor();

    /**
     * 查询所有的 visitorView 信息
     * @author tiantian152
     * @return VisitorView实体类列表
     */
    @Select("select * from visitorStudentView")
    public List<VisitorStudentView> selectVisitorStudentView();

    /**
     * 插入 visitor 信息
     * @author tiantian152
     * @return 插入结果
     */
    @Insert({"insert into visitor(visitorName, visitorTelephoneNumber, visitedStudentId, departmentId, dormitoryId, remarks, status, visitStartTime, visitEndTime, recordTime) " +
            "values(#{visitorName}, #{visitorTelephoneNumber}, #{visitedStudentId}, #{departmentId}, #{dormitoryId}, #{remarks}, #{status}, #{visitStartTime}, #{visitEndTime}, #{recordTime})"})
    public int insertVisitor(Visitor visitor);

    /**
     * 插入 访问结束时间
     * @author tiantian152
     * @return 插入结果
     */
    @Update("update visitor set status=#{status},visitEndTime=#{visitEndTime} where visitorId = #{visitorId}")
    public int updateVisitorEndTime(Visitor visitor);
}
