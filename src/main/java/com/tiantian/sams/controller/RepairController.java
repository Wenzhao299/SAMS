package com.tiantian.sams.controller;

import com.tiantian.sams.model.Repair;
import com.tiantian.sams.model.RepairView;
import com.tiantian.sams.model.Visitor;
import com.tiantian.sams.model.VisitorStudentView;
import com.tiantian.sams.service.RepairService;
import com.tiantian.sams.service.impl.RepairServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Date;
import java.util.List;

/**
 * RepairController
 * @author tiantian152
 */
@Controller
@RequestMapping("/repair")
public class RepairController {

    @Autowired
    private RepairService repairService = new RepairServiceImpl();

    /**
     * 添加维修
     * @author tiantian152
     */
    @RequestMapping("/addRepair")
    public String addRepair(Repair repair,
                            Model model) {
        // 从界面获得的数据有：公寓Id,寝室Id,维修内容,备注

        repair.setStatus("等待维修");
        repair.setRecordTime(new Date());
        repair.setStartTime(new Date(0));
        repair.setEndTime(new Date(0));

        int result = repairService.insertRepair(repair);
        if (result == 1)
            System.out.println("插入成功");
        return "redirect:loadRepair";
    }

    /**
     * 加载 维修查询 页面
     * @author tiantian152
     */
    @RequestMapping("/loadRepair")
    public String loadRepair(Model model) {
        List<RepairView> repairs = repairService.selectRepairView();
        model.addAttribute("repairs", repairs);
        System.out.println(repairs);
        return "quireRepair";
    }

}
