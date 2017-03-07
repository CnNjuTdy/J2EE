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

    public List<CheckInLog> findCheckInLogsByHotel(String hotelId);
}
