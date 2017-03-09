package com.hotelworld.service.impl;

import com.hotelworld.dao.ScheduleDao;
import com.hotelworld.entity.Schedule;
import com.hotelworld.entity.state.WebResultState;
import com.hotelworld.service.ScheduleService;
import com.hotelworld.util.DateUtil;
import com.hotelworld.util.IdUtil;
import com.hotelworld.util.WebMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * Created by Tondiyee on 2017/3/5.
 */
@Service
public class ScheduleServiceImpl implements ScheduleService{
    @Autowired
    private ScheduleDao scheduleDao;
    public WebMessage addSchedule(Date start1, Date end1, int[] prices, String hotelId) {
        //检查有没有重合
        Date date = start1;
        while(DateUtil.equalDate(date,end1)){
            WebMessage message = addSchedule(date,prices,hotelId);
            if(message.getState()==WebResultState.WARNING){
                return message;
            }
            date = DateUtil.nextDay(date);
        }
        return new WebMessage("您选择的时间段的价目表创建成功！",WebResultState.NORMAL);
    }

    public WebMessage addSchedule(Date date,int[] prices,String hotelId){
        Schedule scheduleDB = scheduleDao.findScheduleByDateAndHotel(hotelId,date);
        if(scheduleDB.getIsDefault()==0){
            return new WebMessage("您选择的日期："+ DateUtil.getStandardDate(date)+"已存在价目表，请尝试修改当天的计划！", WebResultState.WARNING);
        }else {
            Schedule schedule = new Schedule(IdUtil.getScheduleId(hotelId),hotelId,date,prices[0],prices[1],prices[2],prices[3],0);
            scheduleDao.saveSchedule(schedule);
        }
        return new WebMessage("创建"+DateUtil.getStandardDate(date)+"的价目表成功",WebResultState.NORMAL);
    }

    public WebMessage editSchedule(Schedule schedule) {
        String message = "";
        if (schedule.getIsDefault() == 1) {
            message = "修改默认价目表成功！";
        }else {
            message = "修改"+DateUtil.getStandardDate(schedule.getDate())+"的价目表成功！";
        }
        scheduleDao.updateSchedule(schedule);
        return new WebMessage(message,WebResultState.NORMAL);
    }
}
