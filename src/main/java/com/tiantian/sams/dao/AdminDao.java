package com.tiantian.sams.dao;

import com.tiantian.sams.model.Admin;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Component;

import java.util.List;

@Mapper
@Component
public interface AdminDao {

    @Select("select * from admin")
    public List<Admin> selectAdmin();

    @Select("select * from admin where adminId = #{adminId} and password = #{password}")
    public Admin selectAdminByAdminIdAndPassword(@Param("adminId")String adminId, @Param("password")String password);

    @Select("select * from admin where adminId = #{adminId}")
    public Admin selectAdminByAdminId(@Param("adminId")String adminId);

    @Insert({"insert into admin(adminId, password) values (#{adminId},#{password})"})
    public int insertAdmin(Admin admin);
}
