package com.tiantian.sams.service;

import com.tiantian.sams.model.DormitoryChange;
import com.tiantian.sams.model.DormitoryCheckInAndOut;
import com.tiantian.sams.model.DormitoryExchange;
import org.apache.ibatis.annotations.Insert;

/**
 * @author: Wenzhao
 * Date: 2021/5/21
 */
public interface DormitoryService {
    //入住
    void dormitoryCheckin(DormitoryCheckInAndOut checkin);

    //退宿
    void dormitoryCheckout(DormitoryCheckInAndOut checkout);

    //调宿change
    void dormitoryChange(DormitoryChange change);

    //换宿exchange
    void dormitoryExchange(DormitoryExchange exchange);
}
