package com.tiantian.sams.service;

import com.tiantian.sams.model.Admin;
import com.tiantian.sams.model.Student;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface AdminService {

    public List<Admin> selectAdmin();

    public Admin selectAdminByUsernameAndPassword(String username, String password);

    public Admin selectAdminByUsername(String username);

    public int insertAdmin(Admin admin);
}
