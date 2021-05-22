package com.tiantian.sams.service.impl;

import com.tiantian.sams.dao.VisitorDao;
import com.tiantian.sams.model.Visitor;
import com.tiantian.sams.model.VisitorStudentView;
import com.tiantian.sams.service.VisitorService;
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
public class VisitorServiceImpl implements VisitorService {

    @Autowired
    private VisitorDao visitorDao;

    @Override
    public List<Visitor> selectVisitor() {
        return visitorDao.selectVisitor();
    }

    @Override
    public List<VisitorStudentView> selectVisitorStudentView() {
        return visitorDao.selectVisitorStudentView();
    }

    @Override
    public int insertVisitor(Visitor visitor) {
        return visitorDao.insertVisitor(visitor);
    }

    @Override
    public int updateVisitorEndTime(Visitor visitor) {
        return visitorDao.updateVisitorEndTime(visitor);
    }
}
