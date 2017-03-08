package com.hotelworld.service.impl;

import com.hotelworld.dao.*;
import com.hotelworld.entity.*;
import com.hotelworld.entity.state.WebResultState;
import com.hotelworld.service.SearchService;
import com.hotelworld.util.DateUtil;
import com.hotelworld.util.WebObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by Tondiyee on 2017/3/6.
 */
@Service
public class SearchServiceImpl implements SearchService {
    @Autowired
    private ApplicationDao applicationDao;
    @Autowired
    private CheckInLogDao checkInLogDao;
    @Autowired
    private CheckOutLogDao checkOutLogDao;
    @Autowired
    private HotelDao hotelDao;
    @Autowired
    private MemberDao memberDao;
    @Autowired
    private MemberLogDao memberLogDao;
    @Autowired
    private OrderDao orderDao;
    @Autowired
    private RoomDao roomDao;
    @Autowired
    private ScheduleDao scheduleDao;

    public WebObject<List<Hotel>> searchHotel(String city, Date date, int type) {
        List<Hotel> hotels = hotelDao.findHotelByCity(city);
        if (hotels == null) {
            return new WebObject<List<Hotel>>(WebResultState.WARNING, null);
        }
        List<Hotel> result = new ArrayList<Hotel>();
        //指定房间类型数量大于0
        for (Hotel hotel : hotels) {
            Room room = roomDao.findRoomById(hotel.getId() + DateUtil.getSix(date));
            if (room.getRoom(type) > 0) {
                result.add(hotel);
            }
        }
        return new WebObject<List<Hotel>>(WebResultState.NORMAL, result);
    }

    public WebObject<List<Order>> searchOrderByMember(String memberId) {
        List<Order> orders = orderDao.findOrderByMember(memberId);
        if (orders == null) {
            return new WebObject<List<Order>>(WebResultState.WARNING, null);
        }
        return new WebObject<List<Order>>(WebResultState.NORMAL, orders);
    }

    public WebObject<List<MemberLog>> searchLogByMember(String memberId) {
        List<MemberLog> memberLogs = memberLogDao.findMemberLogByMember(memberId);
        if (memberLogs == null) {
            return new WebObject<List<MemberLog>>(WebResultState.WARNING, null);
        }
        return new WebObject<List<MemberLog>>(WebResultState.NORMAL, memberLogs);
    }

    public WebObject<HotelBusinessConditions> searchBusinessConditions(String hotelId) {
        Hotel hotel = hotelDao.findHotelById(hotelId);
        int maxSingle = hotel.getMaxSingle();
        int maxStandard = hotel.getMaxStandard();
        int maxDouble = hotel.getMaxDouble();
        int maxSuit = hotel.getMaxSuit();
        List<Room> rooms = roomDao.findRecentRoomsByHotel(hotelId);
        //每天的入住情况
        List<Integer> singleRoomData = new ArrayList<Integer>();
        List<Integer> standardRoomData = new ArrayList<Integer>();
        List<Integer> doubleRoomData = new ArrayList<Integer>();
        List<Integer> suitRoomData = new ArrayList<Integer>();
        for (Room room : rooms) {
            singleRoomData.add(maxSingle - room.getSingleRoom());
            standardRoomData.add(maxStandard - room.getStandardRoom());
            doubleRoomData.add(maxDouble - room.getDoubleRoom());
            suitRoomData.add(maxSuit - room.getSuitRoom());
        }
        //每天的营业额
        List<Integer> turnovers = orderDao.findTurnoversByHotel(hotelId);
        //各种类型房间的营业总额
        int[] roomTurnover = orderDao.findRoomTurnoversByHotel(hotelId);
        //入住和登出
        List<CheckInLog> checkInLogs = checkInLogDao.findCheckInLogsByHotel(hotelId);
        List<CheckOutLog> checkOutLogs = checkOutLogDao.findCheckOutLogsByHotel(hotelId);

        HotelBusinessConditions conditions = new HotelBusinessConditions(singleRoomData, standardRoomData,
                doubleRoomData, suitRoomData, turnovers, roomTurnover[0], roomTurnover[1],
                roomTurnover[2], roomTurnover[3], checkInLogs, checkOutLogs);

        return new WebObject<HotelBusinessConditions>(WebResultState.NORMAL,conditions);
    }

    public WebObject<List<Schedule>> searchSchedule(String hotelId) {
        List<Schedule> schedules = scheduleDao.findScheduleByHotel(hotelId);
        if (schedules == null) {
            return new WebObject<List<Schedule>>(WebResultState.WARNING, null);
        }
        return new WebObject<List<Schedule>>(WebResultState.NORMAL, schedules);
    }

    public WebObject<List<Application>> searchAllApplication() {
        List<Application> applications = applicationDao.findAllApplication();
        return new WebObject<List<Application>>(WebResultState.NORMAL, applications);
    }

    public WebObject<AllBusinessConditions> searchAllBusinessConditions() {
        List<Hotel> hotels = hotelDao.findAllHotel();
        //人数变化不知道怎么从数据库里获得……
        int[] memberNumbers = {12,11,18,24,29,32,28,31,32,40,41,42,53,44,45,56,57,60,61,63,64,72,71,75,86,80,87,90,101,100};
        //收入和支出
        int money = orderDao.findAllMoney();
        int income = money/20;
        int expenses = money/100;
        return new WebObject<AllBusinessConditions>(WebResultState.NORMAL,
                new AllBusinessConditions(hotels,memberNumbers,money,income,expenses));
    }

    //search by id
    public WebObject<Application> searchApplicationById(String id) {
        Application application = applicationDao.findApplicationById(id);
        WebResultState state = WebResultState.NORMAL;
        if (application == null) {
            state = WebResultState.WARNING;
        }
        return new WebObject<Application>(state, application);
    }

    public WebObject<CheckInLog> searchCheckInLogById(String id) {
        CheckInLog checkInLog = checkInLogDao.findCheckInLogById(id);
        WebResultState state = WebResultState.NORMAL;
        if (checkInLog == null) {
            state = WebResultState.WARNING;
        }
        return new WebObject<CheckInLog>(state, checkInLog);
    }

    public WebObject<CheckOutLog> searchCheckOutLogById(String id) {
        CheckOutLog checkOutLog = checkOutLogDao.findCheckOutLogById(id);
        WebResultState state = WebResultState.NORMAL;
        if (checkOutLog == null) {
            state = WebResultState.WARNING;
        }
        return new WebObject<CheckOutLog>(state, checkOutLog);

    }

    public WebObject<Hotel> searchHotelById(String id) {
        Hotel hotel = hotelDao.findHotelById(id);
        WebResultState state = WebResultState.NORMAL;
        if (hotel == null) {
            state = WebResultState.WARNING;
        }
        return new WebObject<Hotel>(state, hotel);
    }

    public WebObject<Member> searchMemberById(String id) {
        Member member = memberDao.findMemberById(id);
        WebResultState state = WebResultState.NORMAL;
        if (member == null) {
            state = WebResultState.WARNING;
        }
        return new WebObject<Member>(state, member);
    }

    public WebObject<MemberLog> searchMemberLogById(String id) {
        MemberLog memberLog = memberLogDao.findMemberLogById(id);
        WebResultState state = WebResultState.NORMAL;
        if (memberLog == null) {
            state = WebResultState.WARNING;
        }
        return new WebObject<MemberLog>(state, memberLog);
    }

    public WebObject<Order> searchOrderById(String id) {
        Order order = orderDao.findOrderById(id);
        WebResultState state = WebResultState.NORMAL;
        if (order == null) {
            state = WebResultState.WARNING;
        }
        return new WebObject<Order>(state, order);
    }

    public WebObject<Room> searchRoomById(String id) {
        Room room = roomDao.findRoomById(id);
        WebResultState state = WebResultState.NORMAL;
        if (room == null) {
            state = WebResultState.WARNING;
        }
        return new WebObject<Room>(state, room);
    }

    public WebObject<Schedule> searchScheduleById(String id) {
        Schedule schedule = scheduleDao.findScheduleById(id);
        WebResultState state = WebResultState.NORMAL;
        if (schedule == null) {
            state = WebResultState.WARNING;
        }
        return new WebObject<Schedule>(state, schedule);
    }
}
