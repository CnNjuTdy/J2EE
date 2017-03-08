package com.hotelworld.dao;

import com.hotelworld.entity.Schedule;

import java.util.Date;
import java.util.List;

/**
 * Created by Tondiyee on 2017/2/3.
 */
public interface ScheduleDao {
    public void saveSchedule(Schedule schedule);

    public void delSchedule(Schedule schedule);

    public void updateSchedule(Schedule schedule);

    public Schedule findScheduleById(String id);

    //根据hotel和date返回当天的价目表，没有的时候返回默认
    public Schedule findScheduleByDateAndHotel(String hotelId,Date date);
    //根据hotel返回所有的价目表
    public List<Schedule> findScheduleByHotel(String hotelId);
}
