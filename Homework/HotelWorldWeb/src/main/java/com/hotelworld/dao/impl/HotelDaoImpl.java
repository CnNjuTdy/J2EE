package com.hotelworld.dao.impl;

import com.hotelworld.dao.HotelDao;
import com.hotelworld.entity.Hotel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.web.filter.OncePerRequestFilter;

import java.util.List;

/**
 * Created by Tondiyee on 2017/2/3.
 */
@Repository
public class HotelDaoImpl extends BaseDaoImpl implements HotelDao {
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
        return template.get(Hotel.class, id);
    }

    public List<Hotel> findHotelByCity(String city) {
        Object[] params = {city};
        return findBySQL("select * from hotel where h_city = ? and h_canFound = 1", params, Hotel.class);
    }

    public List<Hotel> findAllHotel() {
        return findBySQL("select * from hotel where h_canFound = 1", null, Hotel.class);
    }
}
