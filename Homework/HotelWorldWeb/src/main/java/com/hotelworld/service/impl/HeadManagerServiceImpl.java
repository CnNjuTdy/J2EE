package com.hotelworld.service.impl;

import com.hotelworld.dao.*;
import com.hotelworld.entity.*;
import com.hotelworld.entity.state.ApplicationState;
import com.hotelworld.entity.state.MemberOperateType;
import com.hotelworld.entity.state.OrderState;
import com.hotelworld.entity.state.WebResultState;
import com.hotelworld.service.HeadManagerService;
import com.hotelworld.util.DateUtil;
import com.hotelworld.util.IdUtil;
import com.hotelworld.util.WebMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Tondiyee on 2017/3/4.
 */
@Service
public class HeadManagerServiceImpl implements HeadManagerService{
    @Autowired
    OrderDao orderDao;
    @Autowired
    MemberDao memberDao;
    @Autowired
    HotelDao hotelDao;
    @Autowired
    MemberLogDao memberLogDao;
    @Autowired
    ApplicationDao applicationDao;

    public WebMessage settleByHotel(String hotelId) {
        //第一步拿到所有的未结算的order
        List<Order> orders = orderDao.findUnSettleOrderByHotel(hotelId);
        /**
         * 第二步，遍历，做下面几件事
         * 1. 设置order属性为over
         * 2. 给member添加积分
         * 3. 给hotel钱
         * 4. 创建一个memberLog 消费
         */
        for(Order order :orders){
            //设置状态
            order.setState(OrderState.OVER);
            //20%的积分返还
            Member member = memberDao.findMemberById(order.getMemberId());
            member.addCredits((int)(order.getMoney()/5));
            memberDao.updateMember(member);
            //给hotel 95%的钱
            Hotel hotel = hotelDao.findHotelById(order.getHotelId());
            hotel.addBalance((int)(order.getMoney()*0.95));
            hotelDao.updateHotel(hotel);
            //memberLog
            MemberLog log = new MemberLog(IdUtil.getMemberLogId(),member.getId(), MemberOperateType.CONSUME,
                    order.getMoney(),DateUtil.getToday(),1);
            memberLogDao.saveMemberLog(log);

        }
        return new WebMessage("成功结算", WebResultState.NORMAL);
    }

    public WebMessage agreeApplication(Application application) {
        //第一步：改Application状态
        application.setState(ApplicationState.SUCCESS);
        applicationDao.updateApplication(application);
        //第二步：更新hotel
        Hotel hotel = new Hotel(application.getHotelId(),application.getHotelBoss(),application.getHotelCity(),application.getHotelAddress()
        ,application.getHotelMaxSingle(),application.getHotelMaxStandard(),application.getHotelMaxDouble(),application.getHotelMaxSuit()
        ,application.getBalance(),1);
        hotelDao.updateHotel(hotel);
        //第三步：发邮件

        // TODO: 2017/3/4  
        return new WebMessage("通过一个申请",WebResultState.NORMAL);
    }

    public WebMessage disagreeApplication(Application application) {
        //第一步：修改状态
        application.setState(ApplicationState.FAILURE);
        applicationDao.updateApplication(application);
        //第二步：发邮件
        // TODO: 2017/3/4

        return null;
    }
}
