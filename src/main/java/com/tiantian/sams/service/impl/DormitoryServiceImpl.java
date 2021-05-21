package com.tiantian.sams.service.impl;

import com.tiantian.sams.dao.DormitoryDao;
import com.tiantian.sams.model.DormitoryChange;
import com.tiantian.sams.model.DormitoryCheckInAndOut;
import com.tiantian.sams.model.DormitoryExchange;
import com.tiantian.sams.service.DormitoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author: Wenzhao
 * Date: 2021/5/21
 */
@Service
@Transactional
public class DormitoryServiceImpl implements DormitoryService {
    @Autowired
    private DormitoryDao dormitoryDao;

    @Override
    public void dormitoryCheckin(DormitoryCheckInAndOut checkin) {
        dormitoryDao.dormitoryCheckin(checkin);
    }

    @Override
    public void dormitoryCheckout(DormitoryCheckInAndOut checkout) {
        dormitoryDao.dormitoryCheckout(checkout);
    }

    @Override
    public void dormitoryChange(DormitoryChange change) {
        dormitoryDao.dormitoryChange(change);
    }

    @Override
    public void dormitoryExchange(DormitoryExchange exchange) {
        dormitoryDao.dormitoryExchange(exchange);
    }
}
