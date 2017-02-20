package com.hotelworld.dao;

import com.hotelworld.entity.Order;

/**
 * Created by Tondiyee on 2017/2/3.
 */
public interface OrderDao {
    public void saveOrder(Order oder);

    public void delOrder(Order order);

    public void updateOrder(Order order);

    public Order findOrderById(String id);
}
