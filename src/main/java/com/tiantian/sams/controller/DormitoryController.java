package com.tiantian.sams.controller;

import com.tiantian.sams.model.DormitoryChange;
import com.tiantian.sams.model.DormitoryCheckInAndOut;
import com.tiantian.sams.model.DormitoryExchange;
import com.tiantian.sams.model.Student;
import com.tiantian.sams.service.DormitoryService;
import com.tiantian.sams.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Date;

/**
 * @author: Wenzhao
 * Date: 2021/5/21
 */
@Controller
@RequestMapping("/dormitory")
public class DormitoryController {
    @Autowired
    private DormitoryService dormitoryService;

    @PostMapping("/dormitoryCheckin")
    public String dormitoryCheckin(DormitoryCheckInAndOut checkin) {
        checkin.setOperateName("入住");
        checkin.setRecordTime(new Date());
        dormitoryService.dormitoryCheckInAndOut(checkin);
        return "redirect:/student/findAll";
    }

    @PostMapping("/dormitoryCheckout")
    public String dormitoryCheckout(DormitoryCheckInAndOut checkout) {
        checkout.setOperateName("退宿");
        checkout.setRecordTime(new Date());
        dormitoryService.dormitoryCheckInAndOut(checkout);
        return "redirect:/student/findAll";
    }

    @PostMapping("/dormitoryChange")
    public String dormitoryChange(DormitoryChange change) {
        change.setChangeDate(new Date());
        change.setRecordTime(new Date());
        dormitoryService.dormitoryChange(change);
        return "redirect:/student/findAll";
    }

    @GetMapping("/dormitoryExchange")
    public String dormitoryExchange(DormitoryExchange exchange, Model model) {
        exchange.setExchangeDate(new Date());
        exchange.setRecordTime(new Date());
        dormitoryService.dormitoryExchange(exchange);
        model.addAttribute("message","换宿成功！");
        return "updateStudentExchange";
    }
}
