package com.hotelworld.util;

/**
 * Created by Tondiyee on 2017/3/1.
 */
public class IdUtil {
    public static String getMemberId(){
        int num = (int)(Math.random()*9999999)+1;
        return String.format("%07d", num);
    }
    public static String getMemberLogId(){
        return null;
    }
    public static String getHotelId(){
        return null;
    }
    public static String getScheduleId(){
        return null;
    }
    public static String getOrderId(){
        return null;
    }
    public static String getApplicationId(){return null;}
    public static String getCheckInLogId(){return null;}
    public static String getCheckOutLogId(){return null;}

}
