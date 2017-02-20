package com.hotelworld.dao;

import com.hotelworld.entity.Schedule;

/**
 * Created by Tondiyee on 2017/2/3.
 */
public interface ScheduleDao {
    public void saveSchedule(Schedule schedule);

    public void delSchedule(Schedule schedule);

    public void updateSchedule(Schedule schedule);

    public Schedule findScheduleById(String id);
}
