package com.hotelworld.entity;

import com.hotelworld.entity.state.MemberOperateType;

import java.util.Date;

/**
 * Created by Tondiyee on 2017/2/3.
 */
public class MemberLog {
    private String id;
    private String memberId;
    private MemberOperateType type;
    private int money;
    private Date date;
    private int reason;


    public MemberLog(){}
    public MemberLog(String memberId, MemberOperateType type, int money, Date date, int reason) {
        this.memberId = memberId;
        this.type = type;
        this.money = money;
        this.date = date;
        this.reason = reason;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getMemberId() {
        return memberId;
    }

    public void setMemberId(String memberId) {
        this.memberId = memberId;
    }

    public MemberOperateType getType() {
        return type;
    }

    public void setType(MemberOperateType type) {
        this.type = type;
    }

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public int getReason() {
        return reason;
    }

    public void setReason(int reason) {
        this.reason = reason;
    }

    @Override
    public String toString() {
        return "MemberLog{" +
                "id='" + id + '\'' +
                ", memberId='" + memberId + '\'' +
                ", type=" + type +
                ", money=" + money +
                ", date=" + date +
                ", reason=" + reason +
                '}';
    }
}
