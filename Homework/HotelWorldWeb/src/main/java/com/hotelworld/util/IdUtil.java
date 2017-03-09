package com.hotelworld.util;

/**
 * Created by Tondiyee on 2017/3/1.
 */
public class IdUtil {
    public static String getMemberId() {
        int num = (int) (Math.random() * 9999999) + 1;
        return String.format("%07d", num);
    }

    public static String getMemberLogId(String id) {
        int num = (int) (Math.random() * 9999999) + 1;
        return id + String.format("%07d", num);
    }

    public static String getHotelId() {
        int num = (int) (Math.random() * 9999999) + 1;
        return String.format("%07d", num);
    }

    public static String getScheduleId(String hotelId) {
        int num = (int) (Math.random() * 9999999) + 1;
        return hotelId + String.format("%07d", num);
    }

    public static String getOrderId(String hotelId) {
        int num = (int) (Math.random() * 9999999) + 1;
        return hotelId + String.format("%07d", num);
    }

    public static String getApplicationId(String hotelId) {
        int num = (int) (Math.random() * 9999999) + 1;
        return hotelId + String.format("%07d", num);
    }

    public static String getCheckInLogId(String hotelId) {
        int num = (int) (Math.random() * 9999999) + 1;
        return hotelId + String.format("%07d", num);
    }

    public static String getCheckOutLogId(String hotelId) {
        int num = (int) (Math.random() * 9999999) + 1;
        return hotelId + String.format("%07d", num);
    }

}
