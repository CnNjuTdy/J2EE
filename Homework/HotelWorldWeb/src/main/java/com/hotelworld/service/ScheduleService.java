package com.hotelworld.service;

import com.hotelworld.entity.Schedule;
import com.hotelworld.util.WebMessage;

import java.util.Date;

/**
 * Created by Tondiyee on 2017/3/1.
 */
public interface ScheduleService {
    //为某个店某段时间添加一个schedule
    public WebMessage addSchedule(Date start1, Date end1, int[] princes, String hotelId);

    public WebMessage addSchedule(Date date, int[] prices, String hotelId);

    //修改某个schedule
    public WebMessage editSchedule(Schedule schedule);
}
