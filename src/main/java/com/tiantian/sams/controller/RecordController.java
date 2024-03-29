package com.tiantian.sams.controller;

import com.tiantian.sams.dao.DepartmentDao;
import com.tiantian.sams.dao.DormitoryDao;
import com.tiantian.sams.model.DepartmentInformation;
import com.tiantian.sams.model.DormitoryInformation;
import com.tiantian.sams.model.Record;
import com.tiantian.sams.model.RecordView;
import com.tiantian.sams.service.RecordService;
import com.tiantian.sams.service.impl.RecordServiceImpl;
import com.tiantian.sams.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * RecordController
 * @author tiantian152
 */
@Controller
@RequestMapping("/record")
public class RecordController {

    @Autowired
    private final RecordService recordService = new RecordServiceImpl();

    @Autowired
    private DepartmentDao departmentDao;

    @Autowired
    private DormitoryDao dormitoryDao;

    /**
     * @author tiantian152
     */
    @RequestMapping("/loadAddRecordPage")
    public String loadAddRecordPage(Model model) {

        System.out.println("==================读取添加日常登记所需信息开始==================");
        // 查询公寓表
        List<DepartmentInformation> departmentInformationList = departmentDao.selectDepartmentInformation();
        System.out.println("departmentInformationList="+departmentInformationList);
        model.addAttribute("departmentInformationList",departmentInformationList);

        // 查询宿舍表
        List<DormitoryInformation> dormitoryInformationList = dormitoryDao.selectDormitoryInformation();
        System.out.println("dormitoryInformationList="+dormitoryInformationList);
        model.addAttribute("dormitoryInformationList",dormitoryInformationList);

        System.out.println("==================读取添加日常登记所需信息结束==================");
        return "addRecord";
    }

    /**
     * @author tiantian152
     */
    @RequestMapping("/addRecord")
    public String addRecord(Record record,
                            Model model) {
        record.setRecordTime(new Date());
        int result = recordService.insertRecord(record);
        if (result == 1)
            System.out.println("登记记录插入成功");
        return "redirect:quireRecord";
    }

    /**
     * @author tiantian152
     */
    @GetMapping("/quireRecord")
    public String quireRecord(Model model) {
        List<RecordView> records = recordService.selectRecordView();
        model.addAttribute("records", records);
        System.out.println(records);
        return "quireRecord";
    }
}
