package com.tiantian.sams.service.impl;

import com.tiantian.sams.dao.RepairDao;
import com.tiantian.sams.model.Repair;
import com.tiantian.sams.model.RepairView;
import com.tiantian.sams.model.Visitor;
import com.tiantian.sams.service.RepairService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Record 服务层实现
 * @author tiantian152
 */
@Service
@Transactional
public class RepairServiceImpl implements RepairService {

    @Autowired
    private RepairDao repairDao;

    @Override
    public List<Repair> selectRepair() {
        return repairDao.selectRepair();
    }

    @Override
    public Repair selectRepairByRepairId(int repairId) {
        return repairDao.selectRepairByRepairId(repairId);
    }

    @Override
    public List<RepairView> selectRepairView() {
        return repairDao.selectRepairView();
    }

    @Override
    public int insertRepair(Repair repair) {
        return repairDao.insertRepair(repair);
    }

    @Override
    public int updateStartTime(Repair repair) {
        return repairDao.updateStartTime(repair);
    }

    @Override
    public int updateEndTime(Repair repair) {
        return repairDao.updateEndTime(repair);
    }

    @Override
    public boolean judgeStatusForStart(int repairId) {
        String status = repairDao.selectRepairByRepairId(repairId).getStatus();
        return status.equals("等待维修");
    }

    @Override
    public boolean judgeStatusForEnd(int repairId) {
        String status = repairDao.selectRepairByRepairId(repairId).getStatus();
        return status.equals("维修中");
    }
}
