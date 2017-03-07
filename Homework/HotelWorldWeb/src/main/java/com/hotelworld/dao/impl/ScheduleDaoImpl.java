package com.hotelworld.dao.impl;

import com.hotelworld.dao.ScheduleDao;
import com.hotelworld.entity.Schedule;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

/**
 * Created by Tondiyee on 2017/2/3.
 */
@Repository
public class ScheduleDaoImpl implements ScheduleDao {
    @Autowired
    HibernateTemplate template;
    public void saveSchedule(Schedule schedule) {
        template.save(schedule);
    }

    public void delSchedule(Schedule schedule) {
        template.delete(schedule);
    }

    public void updateSchedule(Schedule schedule) {
        template.update(schedule);
    }

    public Schedule findScheduleById(String id) {
        return template.get(Schedule.class,id);
    }

    public Schedule findScheduleByDateAndHotel(String hotelId, Date date) {
        return null;
    }

    public List<Schedule> findScheduleByHotel(String hotelId) {
        return null;
    }
}
