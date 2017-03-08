package com.hotelworld.dao.impl;

import com.hotelworld.dao.BaseDao;
import com.hotelworld.dao.CheckOutLogDao;
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
public class CheckOutLogDaoImpl extends BaseDaoImpl implements CheckOutLogDao {
    public void saveCheckOutLog(CheckOutLog checkOutLog) {
        template.save(checkOutLog);
    }

    public void delCheckOutLog(CheckOutLog checkOutLog) {
        template.delete(checkOutLog);
    }

    public void updateCheckOutLog(CheckOutLog checkOutLog) {
        template.update(checkOutLog);
    }

    public CheckOutLog findCheckOutLogById(String id) {
        return template.get(CheckOutLog.class, id);
    }

    public List<CheckOutLog> findCheckOutLogsByHotel(String hotelId) {
        Object[] params = {hotelId};
        return findBySQL("select * from check_out where co_hotel_id=?", params, CheckOutLog.class);
    }
}
