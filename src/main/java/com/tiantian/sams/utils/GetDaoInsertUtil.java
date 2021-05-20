package com.tiantian.sams.utils;

import java.lang.reflect.Field;
import java.util.Arrays;

/**
 * 由于有的时候写Dao的语句很麻烦，干脆写个工具类
 * @author tiantian152
 */
public class GetDaoInsertUtil {

    /**
     * 获取插入语句
     * @param o 对象
     * @return insert语句
     */
    public static String getDaoInsert(Object o, String objectName) {
        StringBuilder result = new StringBuilder("insert into " + objectName + "(");
        String[] filedNames = getFiledName(o);
        for (int i = 0; i < filedNames.length-1; i++) {
            result.append(filedNames[i]).append(", ");
        }
        result.append(filedNames[filedNames.length-1]).append(") values(");
        for (int i = 0; i < filedNames.length-1; i++) {
            result.append("#{").append(filedNames[i]).append("}, ");
        }
        result.append("#{").append(filedNames[filedNames.length-1]).append("})");
        return result.toString();
    }


    /**
     * 获取属性名数组
     * @author tiantian152
     * */
    private static String[] getFiledName(Object o){
        Field[] fields=o.getClass().getDeclaredFields();
        String[] fieldNames=new String[fields.length];
        for(int i=0;i<fields.length;i++){
            System.out.println(fields[i].getType());
            fieldNames[i]=fields[i].getName();
        }
        return fieldNames;
    }
}
