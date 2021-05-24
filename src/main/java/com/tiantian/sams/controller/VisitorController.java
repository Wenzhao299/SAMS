package com.tiantian.sams.controller;

import com.tiantian.sams.dao.VisitorDao;
import com.tiantian.sams.model.*;
import com.tiantian.sams.service.VisitorService;
import com.tiantian.sams.service.impl.VisitorServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Date;
import java.util.List;

/**
 * VisitorController
 * @author tiantian152
 */
@Controller
@RequestMapping("/visitor")
public class VisitorController {

    @Autowired
    private final VisitorService visitorService = new VisitorServiceImpl();

    /**
     * 添加学生访问
     * @author tiantian152
     */
    @RequestMapping("/addVisitor")
    public String addVisitor(Visitor visitor,
                             Model model) {
        visitor.setRecordTime(new Date());
        visitor.setVisitEndTime(new Date(0));
        visitor.setDepartmentId(3);
        visitor.setDormitoryId(3);
        visitor.setStatus("访问中");
        int result = visitorService.insertVisitor(visitor);
        if (result == 1)
            System.out.println("插入成功");
        return "redirect:loadVisitorStudent";
    }

    /**
     * 添加寝室访问
     * @author tiantian152
     */
    @RequestMapping("/addVisitorDormitory")
    public String addVisitorDormitory(VisitorDormitory visitorDormitory,
                                      Model model) {
        visitorDormitory.setRecordTime(new Date());
        visitorDormitory.setVisitEndTime(new Date(0));
        visitorDormitory.setDepartmentId(3);
        visitorDormitory.setDormitoryId(3);
        visitorDormitory.setStatus("访问中");
        int result = visitorService.insertVisitorDormitory(visitorDormitory);
        if (result == 1)
            System.out.println("插入成功");
        return "redirect:loadVisitorDormitory";
    }

    /**
     * 添加学生访问结束时间
     * @author tiantian152
     */
    @RequestMapping("/updateVisitorEndTime")
    public String updateVisitorEndTime(Visitor visitor,
                                       Model model) {
        visitor.setStatus("访问结束");
        visitor.setRecordTime(new Date());
        int result = visitorService.updateVisitorEndTime(visitor);
        if (result == 1)
            System.out.println("插入成功");
        return "redirect:loadVisitorStudent";
    }

    /**
     * 添加寝室访问结束时间
     * @author tiantian152
     */
    @RequestMapping("/updateVisitorDormitoryEndTime")
    public String updateVisitorDormitoryEndTime(VisitorDormitory visitorDormitory,
                                    Model model) {
        visitorDormitory.setStatus("访问结束");
        visitorDormitory.setRecordTime(new Date());
        int result = visitorService.updateVisitorDormitoryEndTime(visitorDormitory);
        if (result == 1)
            System.out.println("插入成功");
        return "redirect:loadVisitorDormitory";
    }

    /**
     * 加载 访问学生记录查询 页面
     * @author tiantian152
     */
    @RequestMapping("/loadVisitorStudent")
    public String loadVisitorStudent(Model model) {
        List<VisitorStudentView> visitors = visitorService.selectVisitorStudentView();
        model.addAttribute("visitors", visitors);
        System.out.println(visitors);
        return "quireVisitorStudent";
    }

    /**
     * 加载 访问寝室记录查询 页面
     * @author tiantian152
     */
    @RequestMapping("/loadVisitorDormitory")
    public String loadVisitorDormitory(Model model) {
        List<VisitorDormitoryView> visitors = visitorService.selectVisitorDormitoryView();
        model.addAttribute("visitors", visitors);
        System.out.println(visitors);
        return "quireVisitorDormitory";
    }

}
