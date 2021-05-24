package com.tiantian.sams.service;

import com.tiantian.sams.model.Repair;
import com.tiantian.sams.model.RepairView;

import java.util.List;

public interface RepairService {

    /**
     * 查询所有的 repair 信息
     * @author tiantian152
     * @return Repair实体类列表
     */
    public List<Repair> selectRepair();

    /**
     * 查询所有的 repairView 信息
     * @author tiantian152
     * @return RepairView实体类列表
     */
    public List<RepairView> selectRepairView();


    /**
     * 插入 repair 信息
     * @author tiantian152
     * @return 插入结果
     */
    public int insertRepair(Repair repair);

    /**
     * 更新维修状态和时间
     * @author tiantian152
     * @return 更新结果
     */
    public int updateEndTime(Repair repair);

}
