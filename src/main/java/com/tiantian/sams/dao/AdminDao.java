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

    @Select("select * from admin where username = #{username} and password = #{password}")
    public Admin selectAdminByUsernameAndPassword(@Param("username")String username, @Param("password")String password);

    @Select("select * from admin where username = #{username}")
    public Admin selectAdminByUsername(@Param("username")String username);

    @Insert({"insert into admin(username, password) values (#{username},#{password})"})
    @Options(useGeneratedKeys = true, keyProperty = "adminId", keyColumn = "adminId")//加入该注解可以保持对象后，查看对象插入id
    public int insertAdmin(Admin admin);
}
