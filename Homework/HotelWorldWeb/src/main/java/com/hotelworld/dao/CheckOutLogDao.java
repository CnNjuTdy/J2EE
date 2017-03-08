package com.hotelworld.dao;

import com.hotelworld.entity.CheckOutLog;

import java.util.List;

/**
 * Created by Tondiyee on 2017/2/3.
 */
public interface CheckOutLogDao {
    public void saveCheckOutLog(CheckOutLog checkOutLog);

    public void delCheckOutLog(CheckOutLog checkOutLog);

    public void updateCheckOutLog(CheckOutLog checkOutLog);

    public CheckOutLog findCheckOutLogById(String id);

    //返回一个月的CheckInLog，如果不足一个月全部返回
    public List<CheckOutLog> findCheckOutLogsByHotel(String hotelId);
}
