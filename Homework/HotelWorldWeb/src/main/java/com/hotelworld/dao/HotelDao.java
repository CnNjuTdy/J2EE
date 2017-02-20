package com.hotelworld.dao;

import com.hotelworld.entity.Hotel;

/**
 * Created by Tondiyee on 2017/2/3.
 */
public interface HotelDao {
    public void saveHotel(Hotel hotel);

    public void delHotel(Hotel hotel);

    public void updateHotel(Hotel hotel);

    public Hotel findHotelById(String id);
}
