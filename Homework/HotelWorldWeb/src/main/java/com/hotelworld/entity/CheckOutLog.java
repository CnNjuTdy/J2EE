package com.hotelworld.entity;

import java.util.Date;

/**
 * Created by Tondiyee on 2017/3/2.
 */
public class CheckOutLog {
    private String id;
    private String hotelId;
    private String number;
    private Date date;
    private int type;

    public CheckOutLog() {
    }

    public CheckOutLog(String id, String hotelId, String number, Date date, int type) {
        this.id = id;
        this.hotelId = hotelId;
        this.number = number;
        this.date = date;
        this.type = type;
    }

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

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }
}
