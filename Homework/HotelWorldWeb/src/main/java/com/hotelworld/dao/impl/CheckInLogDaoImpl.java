package com.hotelworld.dao.impl;

import com.hotelworld.dao.CheckInLogDao;
import com.hotelworld.entity.CheckInLog;
import com.hotelworld.entity.CheckOutLog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Tondiyee on 2017/3/4.
 */
@Repository
public class CheckInLogDaoImpl extends BaseDaoImpl implements CheckInLogDao{
    public void saveCheckInLog(CheckInLog checkInLog) {
        template.save(checkInLog);
    }

    public void delCheckInLog(CheckInLog checkInLog) {
        template.delete(checkInLog);
    }

    public void updateCheckInLog(CheckInLog checkInLog) {
        template.update(checkInLog);
    }

    public CheckInLog findCheckInLogById(String id) {
        return template.get(CheckInLog.class,id);
    }

    public List<CheckInLog> findCheckInLogsByHotel(String hotelId) {
        Object[] params = {hotelId};
        return findBySQL("select * from check_in where ci_hotel_id=?", params, CheckInLog.class);
    }
}
