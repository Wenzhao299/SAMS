package com.tiantian.sams.service.impl;

import com.tiantian.sams.dao.RecordDao;
import com.tiantian.sams.model.Record;
import com.tiantian.sams.model.RecordView;
import com.tiantian.sams.service.RecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Service
@Transactional
public class RecordServiceImpl implements RecordService {

    @Autowired
    private RecordDao recordDao;

    @Override
    public List<Record> selectRecord() {
        return recordDao.selectRecord();
    }

    @Override
    public List<RecordView> selectRecordView() {
        return recordDao.selectRecordView();
    }

    @Override
    public int insertRecord(Record record) {
        return recordDao.insertRecord(record);
    }
}
