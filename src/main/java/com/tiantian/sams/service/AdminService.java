package com.tiantian.sams.service;

import com.tiantian.sams.model.Admin;

import java.util.List;

public interface AdminService {

    public List<Admin> selectAdmin();

    public Admin selectAdminByUsernameAndPassword(String username, String password);

    public Admin selectAdminByUsername(String username);

    public int insertAdmin(Admin admin);
}
