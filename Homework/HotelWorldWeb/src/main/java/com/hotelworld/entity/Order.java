package com.hotelworld.entity;

import com.hotelworld.entity.state.OrderState;

/**
 * Created by Tondiyee on 2017/2/3.
 */
public class Order {
    private String id;
    private String hotelId;
    private String memberId;
    private int roomType;
    private int roomNumber;
    private OrderState state;

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
                ", roomType=" + roomType +
                ", roomNumber=" + roomNumber +
                ", state=" + state +
                '}';
    }
}
