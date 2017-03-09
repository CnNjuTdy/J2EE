package com.hotelworld.service.impl;

import com.hotelworld.dao.*;
import com.hotelworld.entity.*;
import com.hotelworld.entity.state.ApplicationState;
import com.hotelworld.entity.state.OrderState;
import com.hotelworld.entity.state.WebResultState;
import com.hotelworld.service.BranchManagerService;
import com.hotelworld.util.DateUtil;
import com.hotelworld.util.IdUtil;
import com.hotelworld.util.WebMessage;
import org.aspectj.weaver.ast.Or;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * Created by Tondiyee on 2017/3/4.
 */
@Service
public class BranchManagerServiceImpl implements BranchManagerService {
    @Autowired
    private HotelDao hotelDao;
    @Autowired
    private ApplicationDao applicationDao;
    @Autowired
    private CheckInLogDao checkInLogDao;
    @Autowired
    private CheckOutLogDao checkOutLoDao;
    @Autowired
    private OrderDao orderDao;

    public WebMessage registerHotel(String bossName, String city, String address, int[] rooms) {
        //第一步生成一个hotel，不能被find
        String hotelId = IdUtil.getHotelId();
        Hotel hotel = new Hotel(hotelId, bossName, city, address, rooms[0], rooms[1], rooms[2], rooms[3], 0, 0);
        //第二步保存hotel
        hotelDao.saveHotel(hotel);
        return new WebMessage("成功注册hotel，编号是" + hotelId, WebResultState.NORMAL);
    }

    public WebMessage submitApplication(Hotel hotel, String info, String mailAddress) {
        String applicationId = IdUtil.getApplicationId(hotel.getId());
        ApplicationState state = ApplicationState.UNCHECK;
        Application application = new Application(applicationId, hotel.getId(), info, mailAddress, state, hotel.getBoss(), hotel.getCity(),
                hotel.getAddress(), hotel.getMaxRoom(1), hotel.getMaxRoom(2), hotel.getMaxRoom(3), hotel.getMaxRoom(4),hotel.getBalance());
        //提交一个申请，
        applicationDao.saveApplication(application);
        return new WebMessage("您已经提交一个申请，请等待总经理的审批，审批结果会发到邮箱中", WebResultState.NORMAL);
    }

    public WebMessage checkIn(Order order, String name, String number) {
        //第一步：生成checkInId
        String checkInLogId = IdUtil.getCheckInLogId(order.getHotelId());
        //第二步：判断是预定的还是直接进的
        int type = -1;
        String memberId = order.getMemberId();
        if (memberId.equals("0000000")) {
            type = 1;
            //钱给hotel
            Hotel hotel = hotelDao.findHotelById(order.getHotelId());
            hotel.addBalance(order.getMoney());
        } else {
            type = 0;
        }
        order.setState(OrderState.CHECK_IN);
        orderDao.updateOrder(order);
        //第三步：生成一个checkInLog并且保存
        CheckInLog checkInLog = new CheckInLog(checkInLogId, order.getHotelId(), number, DateUtil.getToday(), type);
        checkInLogDao.saveCheckInLog(checkInLog);
        return new WebMessage("成功登记入住", WebResultState.NORMAL);
    }

    public WebMessage checkOut(Order order, String name, String number) {
        String checkOutLogId = IdUtil.getCheckOutLogId(order.getHotelId());

        int type = -1;
        String memberId = order.getMemberId();
        if (memberId.equals("0000000")) {
            type = 1;
            //如果是非会员的直接改成over，不需要结算
            order.setState(OrderState.OVER);
            orderDao.updateOrder(order);
        } else {
            type = 0;
        }

        CheckOutLog checkOutLog = new CheckOutLog(checkOutLogId, order.getHotelId(), number, DateUtil.getToday(),type);
        checkOutLoDao.saveCheckOutLog(checkOutLog);
        return new WebMessage("成功登记离店，欢迎下次光临！",WebResultState.NORMAL);
    }
}
