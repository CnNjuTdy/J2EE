package com.hotelworld.dao;

import com.hotelworld.entity.Order;

import java.util.List;

/**
 * Created by Tondiyee on 2017/2/3.
 */
public interface OrderDao {
    public void saveOrder(Order oder);

    public void delOrder(Order order);

    public void updateOrder(Order order);

    public Order findOrderById(String id);

    public List<Order> findOrderByHotel(String hotelId);

    public List<Order> findUnSettleOrderByHotel(String hotelId);

    public List<Order> findOrderByMember(String memberId);

    public List<Integer> findTurnoversByHotel(String hotelId);

    public List<Integer> findRoomTurnoversByHotel(String hotelId);
}
