package com.hotelworld.dao.impl;

import com.hotelworld.dao.OrderDao;
import com.hotelworld.entity.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;

/**
 * Created by Tondiyee on 2017/2/3.
 */
@Repository
public class OrderDaoImpl implements OrderDao{
    @Autowired
    HibernateTemplate template;

    public void saveOrder(Order order) {
        template.save(order);
    }

    public void delOrder(Order order) {
        template.delete(order);
    }

    public void updateOrder(Order order) {
        template.update(order);
    }

    public Order findOrderById(String id) {
        return template.get(Order.class,id);
    }
}
