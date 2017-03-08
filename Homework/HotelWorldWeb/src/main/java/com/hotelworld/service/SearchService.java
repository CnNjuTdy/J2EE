package com.hotelworld.service;

import com.hotelworld.entity.*;
import com.hotelworld.util.WebObject;

import java.util.Date;
import java.util.List;

/**
 * 这个类很重要
 * Created by Tondiyee on 2017/3/2.
 */
public interface SearchService {

    /**
     * 使用者：会员
     * 使用时机：预定
     * 根据住宿时间，城市返回hotel
     *
     * @param city
     * @param date
     * @param type
     * @return
     */
    public WebObject<List<Hotel>> searchHotel(String city, Date date, int type);

    /**
     * 使用者：会员
     * 使用时机：查看自己全部订单的时候
     * 根据会员id返回所有它的历史order
     *
     * @param memberId
     * @return
     */
    public WebObject<List<Order>> searchOrderByMember(String memberId);

    /**
     * 使用者：会员
     * 使用时机：查看会员举动记录
     * 根据会员id返回所有的会员记录
     *
     * @param memberId
     * @return
     */
    public WebObject<List<MemberLog>> searchLogByMember(String memberId);

    /**
     * 使用者：hotel经理或者总经理
     * 使用时机：查看hotel的经营情况
     * 根据id返回hotel的最近一个月的经营情况（不足一个月全部返回），主要包括以下内容
     * 详见HotelBusinessConditions类
     * @param hotelId
     * @return
     */
    public WebObject<HotelBusinessConditions> searchBusinessConditions(String hotelId);

    /**
     * 使用者：hotel经理
     * 使用者：查看hotel的计划
     * 根据id返回hotel的所有计划
     *
     * @param hotelId
     * @return
     */
    public WebObject<List<Schedule>> searchSchedule(String hotelId);

    /**
     * 使用者：总经理
     * 使用时机：按照时间返回所有的申请
     * 按照时间返回所有的申请，包括开店申请和修改申请
     *
     * @return
     */
    public WebObject<List<Application>> searchAllApplication();

    /**
     * 使用者：总经理
     * 使用时机：查看整个hotel world的经营情况
     * 返回hotel world的经营情况，主要包括以下内容
     * 详见AllBusinessConditions类
     * @return
     */
    public WebObject<AllBusinessConditions> searchAllBusinessConditions();

    public WebObject<Order> searchOrderById(String id);

    public WebObject<Hotel> searchHotelById(String id);

    public WebObject<Schedule> searchScheduleById(String id);

    public WebObject<Application> searchApplicationById(String id);

    public WebObject<CheckInLog> searchCheckInLogById(String id);

    public WebObject<CheckOutLog> searchCheckOutLogById(String id);

    public WebObject<Member> searchMemberById(String id);

    public WebObject<MemberLog> searchMemberLogById(String id);

    public WebObject<Room> searchRoomById(String id);
}
