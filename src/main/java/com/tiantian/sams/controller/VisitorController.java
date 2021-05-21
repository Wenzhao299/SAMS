package com.tiantian.sams.controller;

import com.tiantian.sams.dao.VisitorDao;
import com.tiantian.sams.model.Visitor;
import com.tiantian.sams.service.VisitorService;
import com.tiantian.sams.service.impl.VisitorServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Date;

/**
 * VisitorController
 * @author tiantian152
 */
@Controller
@RequestMapping("/visitor")
public class VisitorController {

    @Autowired
    private VisitorService visitorService = new VisitorServiceImpl();

    /**
     * @author tiantian152
     */
    @RequestMapping("/addVisitor")
    public String addVisitor(Visitor visitor,
                             Model model) {
        visitor.setRecordTime(new Date());
        visitor.setDepartmentId(3);
        visitor.setDormitoryId(3);
        int result = visitorService.insertVisitor(visitor);
        if (result == 1)
            System.out.println("插入成功");
        return "redirect:quireRecord";
    }
}
