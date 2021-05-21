package com.tiantian.sams.service;

import com.tiantian.sams.model.Visitor;

import java.util.List;

/**
 * Record 服务层
 * @author tiantian152
 */
public interface VisitorService {

    /**
     * 查询所有的 visitor 信息
     * @author tiantian152
     * @return Visitor实体类列表
     */
    public List<Visitor> selectVisitor();

    /**
     * 插入 visitor 信息
     * @author tiantian152
     * @return 插入结果
     */
    public int insertVisitor(Visitor visitor);
}
