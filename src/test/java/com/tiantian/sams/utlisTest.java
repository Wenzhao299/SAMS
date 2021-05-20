package com.tiantian.sams;

import com.tiantian.sams.model.AdminInformation;
import com.tiantian.sams.model.Visitor;
import com.tiantian.sams.utils.GetDaoInsertUtil;
import org.junit.jupiter.api.Test;

public class utlisTest {

    @Test
    public void test01() {
//        Visitor visitor = new Visitor();
//        System.out.println(GetDaoInsertUtil.getDaoInsert(visitor, "visitor"));
        AdminInformation adminInformation = new AdminInformation();
        System.out.println(GetDaoInsertUtil.getDaoInsert(adminInformation, "adminInformation"));
    }
}
