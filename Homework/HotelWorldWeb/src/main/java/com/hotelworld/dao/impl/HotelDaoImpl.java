package com.hotelworld.dao.impl;

import com.hotelworld.dao.HotelDao;
import com.hotelworld.entity.Hotel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;

/**
 * Created by Tondiyee on 2017/2/3.
 */
@Repository
public class HotelDaoImpl implements HotelDao {
    @Autowired
    HibernateTemplate template;

    public void saveHotel(Hotel hotel) {
        template.save(hotel);
    }

    public void delHotel(Hotel hotel) {
        template.delete(hotel);
    }

    public void updateHotel(Hotel hotel) {
        template.update(hotel);
    }

    public Hotel findHotelById(String id) {
        return template.get(Hotel.class,id);
    }
}
