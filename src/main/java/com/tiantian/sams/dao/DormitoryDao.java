package com.tiantian.sams.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Dormitory 宿舍表的操作实现
 * @author tiantian152
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
}
