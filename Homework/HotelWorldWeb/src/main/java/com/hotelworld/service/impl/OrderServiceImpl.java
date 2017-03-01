package com.hotelworld.service.impl;

import com.hotelworld.dao.OrderDao;
import com.hotelworld.entity.Order;
import com.hotelworld.service.OrderService;
import com.hotelworld.util.WebMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Tondiyee on 2017/3/1.
 */
@Service
public class OrderServiceImpl implements OrderService{
    @Autowired
    OrderDao dao;

    public WebMessage createOrder(Order order) {
        return null;
    }

    public WebMessage cancelOrder(Order order) {
        return null;
    }

    public WebMessage settleOrder(Order order) {
        return null;
    }
}
