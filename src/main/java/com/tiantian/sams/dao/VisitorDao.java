package com.tiantian.sams.dao;

import com.tiantian.sams.model.Visitor;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
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
     * 插入 visitor 信息
     * @author tiantian152
     * @return 插入结果
     */
    @Insert({"insert into visitor(visitorName, visitorTelephoneNumber, visitedStudentId, departmentId, dormitoryId, remarks, status, visitStartTime, visitEndTime, recordTime) " +
            "values(#{visitorName}, #{visitorTelephoneNumber}, #{visitedStudentId}, #{departmentId}, #{dormitoryId}, #{remarks}, #{status}, #{visitStartTime}, #{visitEndTime}, #{recordTime})"})
    public int insertVisitor(Visitor visitor);

}
