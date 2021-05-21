package com.tiantian.sams.dao;

import com.tiantian.sams.model.Admin;
import com.tiantian.sams.model.Record;
import com.tiantian.sams.model.RecordView;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Record 登记表的操作实现
 * @author tiantian152
 */
@Mapper
@Component
public interface RecordDao {

    /**
     * 查询所有的 record 中的信息
     * @author tiantian152
     * @return Record实体类列表
     */
    @Select("select * from record")
    public List<Record> selectRecord();

    /**
     * 调用视图查询
     * @author tiantian152
     * @return RecordView实体类列表
     */
    @Select("select * from recordView")
    public List<RecordView> selectRecordView();

    /**
     * 向record表中插入一条记录
     * @author tiantian152
     * @return 是否插入成功
     */
    @Insert({"insert into record(type, inAndOutTime, studentId, departmentId, dormitoryId, recordTime, remarks) " +
            "values(#{type}, #{inAndOutTime}, #{studentId}, #{departmentId}, #{dormitoryId}, #{recordTime}, #{remarks})"})
    public int insertRecord(Record record);
}
