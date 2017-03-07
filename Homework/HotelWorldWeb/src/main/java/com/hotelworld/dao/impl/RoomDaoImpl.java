package com.hotelworld.dao.impl;

import com.hotelworld.dao.RoomDao;
import com.hotelworld.entity.Room;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;

import javax.xml.ws.Action;
import java.util.Date;
import java.util.List;

/**
 * Created by Tondiyee on 2017/3/3.
 */
@Repository
public class RoomDaoImpl implements RoomDao {
    @Autowired
    HibernateTemplate template;

    public void saveRoom(Room room) {
        template.save(room);
    }

    public void delRoom(Room room) {
        template.delete(room);
    }

    public void updateRoom(Room room) {
        template.update(room);
    }

    public Room findRoomById(String hotelDate) {
        return template.get(Room.class,hotelDate);
    }

    public List<Room> findRecentRoomsByHotel(String hotelId) {
        return null;
    }
}
