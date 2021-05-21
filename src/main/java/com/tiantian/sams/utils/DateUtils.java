package com.tiantian.sams.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtils {

    /**
     * 获取当前时间
     * @author tiantian152
     * @return Date对象
     */
    public static Date getDate() {
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm");//设置日期格式
        String date_str = df.format(new Date());
        Date date = null;
        try {
            date = df.parse(date_str);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return date;
    }

    /**
     * 转化为当前时间
     * @author tiantian152
     * @return Date对象
     */
    public static Date mergeDateAndTime(Date time, Date date) {
        String date_time = getTimeString(date) + " " + getDateString(date);
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm");//设置日期格式
        Date result = null;
        try {
            result = df.parse(date_time);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return result;
    }

    public static String getTimeString(Date time) {
        SimpleDateFormat df = new SimpleDateFormat("HH:mm");//设置日期格式
        return df.format(time);
    }

    public static String getDateString(Date date) {
        SimpleDateFormat df = new SimpleDateFormat("HH:mm");//设置日期格式
        return df.format(date);
    }
}
