package com.tiantian.sams.service.impl;

import com.tiantian.sams.dao.AdminDao;
import com.tiantian.sams.model.Admin;
import com.tiantian.sams.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Component
public class AdminServiceImpl implements AdminService {

    @Autowired
    private AdminDao adminDao;

    @Override
    public List<Admin> selectAdmin() {
        return adminDao.selectAdmin();
    }

    @Override
    public Admin selectAdminByUsernameAndPassword(String username, String password) {
        return adminDao.selectAdminByUsernameAndPassword(username, password);
    }

    @Override
    public Admin selectAdminByUsername(String username) {
        return adminDao.selectAdminByUsername(username);
    }

    @Override
    public int insertAdmin(Admin admin) {
        adminDao.insertAdmin(admin);
        return admin.getAdminId();
    }
}
