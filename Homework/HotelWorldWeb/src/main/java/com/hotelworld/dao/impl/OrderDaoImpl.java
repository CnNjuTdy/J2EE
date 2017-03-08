package com.hotelworld.dao.impl;

import com.hotelworld.dao.OrderDao;
import com.hotelworld.entity.Member;
import com.hotelworld.entity.Order;
import com.hotelworld.util.DateUtil;
import com.sun.org.apache.xpath.internal.operations.Or;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;

import javax.persistence.criteria.CriteriaBuilder;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by Tondiyee on 2017/2/3.
 */
@Repository
public class OrderDaoImpl extends BaseDaoImpl implements OrderDao {
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
        return template.get(Order.class, id);
    }

    public List<Order> findUnSettleOrderByHotel(String hotelId) {
        String start = DateUtil.getStandardDate(DateUtil.lastMonth());
        Object[] params = {hotelId, start};
        return findBySQL("select * from h_order where o_hotel_id = ? and o_start > ? and (o_state = 1 or o_state=4)", params, Order.class);
    }

    public List<Order> findOrderByMember(String memberId) {
        if (memberId.equals("0000000")) {
            return null;
        }
        Object[] params = {memberId};
        return findBySQL("select * from h_order where o_member_id = ?", params, Order.class);
    }

    public List<Integer> findTurnoversByHotel(String hotelId) {
        List<Integer> list = new ArrayList<Integer>();
        for (int i = -30; i < 1; i++) {
            String date = DateUtil.getStandardDate(DateUtil.nextNDay(new Date(), i));
            Object[] params = {hotelId, date};
            List<Order> orders = findBySQL("SELECT * FROM `h_order` WHERE o_hotel_id=? and o_start = ?", params, Order.class);
            int turnover = 0;
            for (Order order : orders) {
                turnover += order.getMoney();
            }
            list.add(turnover);
        }
        return list;
    }

    public int[] findRoomTurnoversByHotel(String hotelId) {
        Object[] params = {hotelId,DateUtil.lastMonth()};
        List<Order> orders = findBySQL("select * from h_order where o_hotel_id = ? and o_start > ? and (o_state = 1 or o_state=4)",params,Order.class);
        int[] list = {0,0,0,0};
        for(Order order:orders){
            list[order.getRoomType()-1]+=order.getMoney();
        }
        return list;
    }

    public int findAllMoney() {
        Object[] params = {DateUtil.lastMonth()};
        List<Order> orders = findBySQL("select * from h_order where o_start > ? and (o_state = 1 or o_state=4)",params,Order.class);
        int sum = 0;
        for(Order order:orders){
            sum+=order.getMoney();
        }
        return sum;
    }
}
