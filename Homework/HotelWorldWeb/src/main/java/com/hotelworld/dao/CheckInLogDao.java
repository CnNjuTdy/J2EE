package com.hotelworld.dao;

import com.hotelworld.entity.CheckInLog;

import java.util.List;

/**
 * Created by Tondiyee on 2017/2/3.
 */
public interface CheckInLogDao {
    public void saveCheckInLog(CheckInLog checkInLog);

    public void delCheckInLog(CheckInLog checkInLog);

    public void updateCheckInLog(CheckInLog checkInLog);

    public CheckInLog findCheckInLogById(String id);

    //返回一个月的CheckInLog，如果不足一个月全部返回
    public List<CheckInLog> findCheckInLogsByHotel(String hotelId);
}
