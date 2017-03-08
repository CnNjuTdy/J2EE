package com.hotelworld.dao;

import com.hotelworld.entity.Hotel;

import java.util.List;

/**
 * Created by Tondiyee on 2017/2/3.
 */
public interface HotelDao {
    public void saveHotel(Hotel hotel);

    public void delHotel(Hotel hotel);

    public void updateHotel(Hotel hotel);

    public Hotel findHotelById(String id);

    public List<Hotel> findHotelByCity(String city);

    //返回所有可以被搜索到的hotel，即已经被总经理批准可以营业的hotel
    public List<Hotel> findAllHotel();
}
