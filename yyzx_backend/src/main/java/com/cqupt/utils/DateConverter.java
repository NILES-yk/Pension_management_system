package com.cqupt.utils;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.*;


@Component
public class DateConverter implements Converter<String,Date>{

    private static final List<String> formats = new ArrayList<>();
    static {
        formats.add("yyyy-MM");
        formats.add("yyyy-MM-dd");
        formats.add("yyyy-MM-dd hh:mm");
        formats.add("yyyy-MM-dd hh:mm:ss");
    }

    @Override
    public Date convert(String source) {
        //去除头尾的空格
        String value=source.trim();
        //若得到空字符串,则返回空
        if(value.equals("")){
            return null;
        }
        //^表示开头,$表示结尾
        // \表示转义字符 \d表示数字
        // {4}表示重复4次,{1,2}表示重复1次或2次
        //表示 4个数字-1或2个数字 表示年份+月份
        if(source.matches("^\\d{4}-\\d{1,2}$")){ //yyyy-mm
             return parseDate(source,formats.get(0));
        }
        else if(source.matches("^\\d{4}-\\d{1,2}-\\d{1,2}$")){ //yyyy-mm-dd
            return parseDate(source,formats.get(1));
        }
        else if(source.matches("^\\d{4}-\\d{1,2}-\\d{1,2} {1}\\d{1,2}:\\d{1,2}$")){ //yyyy-mm-dd hh:mm
            return parseDate(source,formats.get(2));
        }
        else if(source.matches("^\\d{4}-\\d{1,2}-\\d{1,2} {1}\\d{1,2}:\\d{1,2}:\\d{1,2}$")){ //yyyy-mm-dd hh:mm:ss
            return parseDate(source,formats.get(3));
        }
        else{
            throw new IllegalArgumentException("日期格式异常，需要yyyy-MM-dd:'"+source+"'");
        }
    }

    //日期格式化
    public Date parseDate(String dateStr, String format) {
        Date date=null;
        try{
            SimpleDateFormat sdf = new SimpleDateFormat(format);
            date=sdf.parse(dateStr);
        }
        catch(Exception e){
            e.printStackTrace();
        }
        return date;
    }
}
