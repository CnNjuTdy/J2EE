package com.hotelworld.util;

import com.sun.org.apache.xerces.internal.impl.dv.xs.DateDV;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * Created by Tondiyee on 2017/3/1.
 */
public class DateUtil {
    public static DateFormat df1 = new SimpleDateFormat("YYYY-MM-dd");
    public static DateFormat df2 = new SimpleDateFormat("YYMMdd");

    public static Date getToday() {
        return new Date();
    }

    public static String getSix() {
        String six = df2.format(getToday());
        return six;
    }

    public static String getSix(Date date){
        return df2.format(date);
    }

    public static Date nextDay(Date date){
        return nextNDay(date,1);
    }
    public static Date lastDay(Date date){
        return nextNDay(date,-1);
    }
    public static Date nextNDay(Date date,int n){
        Calendar c = Calendar.getInstance();
        c.setTime(date);
        c.add(Calendar.DATE,n);
        return c.getTime();
    }
    public static boolean equalDate(Date date1,Date date2){
        String s1 = df1.format(date1);
        String s2 = df1.format(date2);
        return s1.equals(s2);
    }

    public static String getStandardDate(Date date){
        return df1.format(date);
    }

}
