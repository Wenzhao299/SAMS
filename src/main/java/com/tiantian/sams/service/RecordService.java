package com.tiantian.sams.service;

import com.tiantian.sams.model.Record;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * Record 服务层
 * @author tiantian152
 */
public interface RecordService {

    /**
     * 查询所有的 record 中的信息
     * @author tiantian152
     * @return Record实体类列表
     */
    public List<Record> selectRecord();

    /**
     * 向record表中插入一条记录
     * @author tiantian152
     * @return 是否插入成功
     */
    public int insertRecord(Record record);
}
