package com.tiantian.sams.service;

import com.tiantian.sams.model.Visitor;
import com.tiantian.sams.model.VisitorDormitory;
import com.tiantian.sams.model.VisitorDormitoryView;
import com.tiantian.sams.model.VisitorStudentView;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

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
     * 查询所有的 visitorView 信息
     * @author tiantian152
     * @return VisitorView实体类列表
     */
    public List<VisitorStudentView> selectVisitorStudentView();

    /**
     * 插入 visitor 信息
     * @author tiantian152
     * @return 插入结果
     */
    public int insertVisitor(Visitor visitor);

    /**
     * 插入 访问结束时间
     * @author tiantian152
     * @return 插入结果
     */
    public int updateVisitorEndTime(Visitor visitor);

    /**
     * 查询所有的 visitorDormitory 信息
     * @author tiantian152
     * @return Visitor实体类列表
     */
    public List<Visitor> selectVisitorDormitory();

    /**
     * 查询所有的 visitorDormitoryView 信息
     * @author tiantian152
     * @return VisitorView实体类列表
     */
    public List<VisitorDormitoryView> selectVisitorDormitoryView();

    /**
     * 插入 visitorDormitory 信息
     * @author tiantian152
     * @return 插入结果
     */
    public int insertVisitorDormitory(VisitorDormitory visitorDormitory);

    /**
     * 插入 访问结束时间
     * @author tiantian152
     * @return 插入结果
     */
    public int updateVisitorDormitoryEndTime(VisitorDormitory visitorDormitory);
}
