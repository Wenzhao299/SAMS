package com.tiantian.sams.service.impl;

import com.tiantian.sams.dao.DormitoryDao;
import com.tiantian.sams.dao.StudentDao;
import com.tiantian.sams.model.*;
import com.tiantian.sams.service.DormitoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author: Wenzhao
 * Date: 2021/5/21
 */
@Service
@Transactional
public class DormitoryServiceImpl implements DormitoryService {
    @Autowired
    private DormitoryDao dormitoryDao;

    @Autowired
    private StudentDao studentDao;

    @Override
    public void dormitoryCheckInAndOut(DormitoryCheckInAndOut check) {
        dormitoryDao.dormitoryCheckInAndOut(check);
    }

    @Override
    public void dormitoryChange(DormitoryChange change) {
        dormitoryDao.dormitoryChange(change);
    }

    @Override
    public void dormitoryExchange(DormitoryExchange exchange) {
        dormitoryDao.dormitoryExchange(exchange);
    }

    @Override
    public void dormitoryUpdate(Dormitory dormitory) {
        dormitoryDao.dormitoryUpdate(dormitory);
    }

    @Override
    public Dormitory findByDorId(Integer dormitoryId) {
        return dormitoryDao.findByDorId(dormitoryId);
    }

    @Override
    public Student findViewByStudentId(String studentId) {
        return dormitoryDao.findViewByStudentId(studentId);
    }

    @Override
    public List<Student> findAllView() {
        return dormitoryDao.findAllView();
    }

    @Override
    public Integer findBed1ByDormitoryId(Integer dormitoryId) {
        return dormitoryDao.findBed1ByDormitoryId(dormitoryId);
    }

    @Override
    public Integer findBed2ByDormitoryId(Integer dormitoryId) {
        return dormitoryDao.findBed2ByDormitoryId(dormitoryId);
    }

    @Override
    public Integer findBed3ByDormitoryId(Integer dormitoryId) {
        return dormitoryDao.findBed3ByDormitoryId(dormitoryId);
    }

    @Override
    public Integer findBed4ByDormitoryId(Integer dormitoryId) {
        return dormitoryDao.findBed4ByDormitoryId(dormitoryId);
    }
}
