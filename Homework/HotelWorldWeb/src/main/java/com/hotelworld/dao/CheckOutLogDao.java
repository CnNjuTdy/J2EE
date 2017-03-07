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

    public List<CheckOutLog> findCheckOutLogsByHotel(String id);
}
