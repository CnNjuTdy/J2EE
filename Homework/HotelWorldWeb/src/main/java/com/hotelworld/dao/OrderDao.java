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

    //根据hotelId返回所有没有结算的order
    public List<Order> findUnSettleOrderByHotel(String hotelId);
    //根据memberId返回所有的order
    public List<Order> findOrderByMember(String memberId);
    //根据hotelId返回一个月内每天的收入情况
    public List<Integer> findTurnoversByHotel(String hotelId);
    //根据hotelId返回一个月内各种类型房间的营业总额
    public int[] findRoomTurnoversByHotel(String hotelId);
    //返回一个月内的总收入
    public int findAllMoney();
}
