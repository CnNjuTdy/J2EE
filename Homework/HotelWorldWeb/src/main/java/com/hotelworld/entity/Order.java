package com.hotelworld.entity;

import com.hotelworld.entity.state.OrderState;

import java.util.Date;

/**
 * Created by Tondiyee on 2017/2/3.
 * 在这里写一下吧，order这个生命周期，包括与之相关的钱
 * 第一种情况：会员在线支付的
 * 1. 会员预定的时候create，此时状态是ready，这时候钱已经变少了，钱在总经理那里
 * 2. 会员去住的时候check_in，此时状态是check_in，生成log，这时候钱还是在总经理那里
 * 3. 订单被结算的时候，状态变成over，这时候钱从总经理那里到hotel老板那里，这时候会员的积分变多，增加消费的记录
 * 4. 如果check_in之前取消，那么状态变成cancel，钱退回
 * 5. 如果超时，那么钱不退回，等待订单结算
 * 第二种情况：直接付现金的
 * 1. 去交钱的时候先create，此时状态是ready
 * 2. 然后check_in,状态变成check_in,之后hotel钱变多，生成log
 * 3. 然后check out的时候状态变成over
 */
public class Order {
    private String id;
    private String hotelId;
    private String memberId;
    private int money;
    private int roomType;
    private int roomNumber;
    private Date start;
    private OrderState state;


    public Order(String id, String hotelId, String memberId, int money, int roomType, int roomNumber, Date start, OrderState state) {
        this.id = id;
        this.hotelId = hotelId;
        this.memberId = memberId;
        this.money = money;
        this.roomType = roomType;
        this.roomNumber = roomNumber;
        this.start = start;
        this.state = state;
    }

    public Order(){}

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getHotelId() {
        return hotelId;
    }

    public void setHotelId(String hotelId) {
        this.hotelId = hotelId;
    }

    public String getMemberId() {
        return memberId;
    }

    public void setMemberId(String memberId) {
        this.memberId = memberId;
    }

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }

    public int getRoomType() {
        return roomType;
    }

    public void setRoomType(int roomType) {
        this.roomType = roomType;
    }

    public int getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(int roomNumber) {
        this.roomNumber = roomNumber;
    }

    public Date getStart() {
        return start;
    }

    public void setStart(Date start) {
        this.start = start;
    }

    public OrderState getState() {
        return state;
    }

    public void setState(OrderState state) {
        this.state = state;
    }

    @Override
    public String toString() {
        return "Order{" +
                "id='" + id + '\'' +
                ", hotelId='" + hotelId + '\'' +
                ", memberId='" + memberId + '\'' +
                ", money=" + money +
                ", roomType=" + roomType +
                ", roomNumber=" + roomNumber +
                ", start=" + start +
                ", state=" + state +
                '}';
    }
}
