package com.hotelworld.dao;

import com.hotelworld.entity.Order;
import com.hotelworld.entity.Room;

import java.util.Date;
import java.util.List;

/**
 * Created by Tondiyee on 2017/3/3.
 */
public interface RoomDao {
    public void saveRoom(Room room);

    public void delRoom(Room room);

    public void updateRoom(Room room);

    public Room findRoomById(String hotelDate);
    //一个月内的room
    public List<Room> findRecentRoomsByHotel(String hotelId);

}
