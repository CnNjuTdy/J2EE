package com.hotelworld.entity;

import com.hotelworld.entity.state.MemberState;


/**
 * Created by Tondiyee on 2017/2/1.
 */
public class Member {
    private String id;
    private String name;
    private String phone;
    private int balance;
    private int credits;
    private String account;
    private MemberState state;

    public MemberState getState() {
        return state;
    }

    public void setState(MemberState state) {
        this.state = state;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public int getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }


    public int getCredits() {
        return credits;
    }

    public void setCredits(int credits) {
        this.credits = credits;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }


    @Override
    public String toString() {
        return "Member{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", phone='" + phone + '\'' +
                ", balance=" + balance +
                ", credits=" + credits +
                ", account='" + account + '\'' +
                ", state=" + state +
                '}';
    }
}
