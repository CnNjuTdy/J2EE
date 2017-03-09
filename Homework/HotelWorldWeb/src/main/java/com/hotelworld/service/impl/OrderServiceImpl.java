package com.hotelworld.service.impl;

import com.hotelworld.dao.MemberDao;
import com.hotelworld.dao.OrderDao;
import com.hotelworld.dao.RoomDao;
import com.hotelworld.dao.ScheduleDao;
import com.hotelworld.entity.Member;
import com.hotelworld.entity.Order;
import com.hotelworld.entity.Room;
import com.hotelworld.entity.state.OrderState;
import com.hotelworld.entity.state.WebResultState;
import com.hotelworld.service.OrderService;
import com.hotelworld.util.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * Created by Tondiyee on 2017/3/1.
 */
@Service
public class OrderServiceImpl implements OrderService {
    @Autowired
    OrderDao orderDao;
    @Autowired
    RoomDao roomDao;
    @Autowired
    MemberDao memberDao;
    @Autowired
    ScheduleDao scheduleDao;


    public WebObject<Order> createOrder(String hotelId, String memberId,
                                        int roomType, Date start) {
        //第一步判断是否有要求的房间
        Room room = roomDao.findRoomById(hotelId + DateUtil.getSix(start));
        int number = room.getRoom(roomType);
        if (number <= 0) {
            return new WebObject<Order>(WebResultState.ERROR, null);
        }
        //第二步算出价格，生成房间号
        int money = scheduleDao.findScheduleByDateAndHotel(hotelId, start).getPrice(roomType);
        int roomNumber = 0;
        if (number >= 10) {
            roomNumber = Integer.parseInt("8" + roomType + number);
        } else {
            roomNumber = Integer.parseInt("8" + roomType + "0" + number);
        }
        //第三步判断是会员还是非会员，如果是会员减少余额
        OrderState state = OrderState.READINESS;
        if (memberId.equals("0000000")) {
        } else {
            //数据库处理，减少member余额，不足时返回错误
            Member member = memberDao.findMemberById(memberId);
            if (member.getBalance() < money) {
                return new WebObject<Order>(WebResultState.WARNING, null);
            } else {
                member.addBalance(-money);
                memberDao.updateMember(member);
            }
        }
        //第四步，生成订单并保存
        Order order = new Order(IdUtil.getOrderId(hotelId), hotelId, memberId, money, roomType, roomNumber, start, state);
        orderDao.saveOrder(order);
        //第五步，减少房间数目并且保存
        room.minRoom(roomType);
        roomDao.updateRoom(room);
        return new WebObject<Order>(WebResultState.NORMAL, order);
    }

    public WebMessage cancelOrder(Order order) {
        //第一步，判断这个订单能不能取消
        if (!order.getState().equals(OrderState.READINESS)) {
            return new WebMessage("您的订单不能取消！", WebResultState.WARNING);
        }

        //第二步，取消这个订单并且保存
        order.setState(OrderState.CANCEL);
        orderDao.updateOrder(order);
        //第三步，增加房间数目并且保存
        Room room = roomDao.findRoomById(order.getHotelId() + DateUtil.getSix(order.getStart()));
        room.addRoom(order.getRoomType());
        roomDao.updateRoom(room);
        //第四步，钱退回去
        Member member = memberDao.findMemberById(order.getMemberId());
        member.addBalance(order.getMoney());

        return new WebMessage("您的订单已经取消", WebResultState.NORMAL);
    }
}
