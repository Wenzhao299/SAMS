package com.tiantian.sams.dao;

import com.tiantian.sams.model.Visitor;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Department 表的操作实现
 * @author tiantian152
 */
@Mapper
@Component
public interface DepartmentDao {

    /**
     * 查询所有的 Department 中 departmentId（公寓楼号） 信息
     * @author tiantian152
     * @return departmentIdList
     */
    @Select("select departmentId from department")
    public List<Integer> selectDepartmentId();

}
