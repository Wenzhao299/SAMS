package com.tiantian.sams.dao;

import com.tiantian.sams.model.AdminInformation;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;

import java.util.List;

@Mapper
@Component
public interface AdminInformationDao {

    @Select("select * from adminInformation")
    public List<AdminInformation> selectAdminInformation();

    @Select("select * from adminInformation where adminId = #{adminId}")
    public AdminInformation selectUserByAdminId(@Param("adminId")int adminId);

    @Insert({"insert into adminInformation(adminId, departmentNumber) " +
            "values(#{adminId},#{departmentNumber})"})
    public int insertAdmin(AdminInformation adminInformation);
}
