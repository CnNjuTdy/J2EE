package com.hotelworld.entity;

import com.hotelworld.entity.state.MemberState;
import com.hotelworld.entity.state.MemberType;


/**
 * Created by Tondiyee on 2017/2/1.
 */
public class Member {
    private String id;
    private String name;
    private String password;
    private String phone;
    private int balance;
    private int credits;
    private String account;
    private MemberState state;

    public Member() {
    }

    public Member(String id, String name, String password, String phone, int balance, int credits, String account, MemberState state) {
        this.id = id;
        this.name = name;
        this.password = password;
        this.phone = phone;
        this.balance = balance;
        this.credits = credits;
        this.account = account;
        this.state = state;
    }

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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
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


    public void addBalance(int add){
        this.balance = balance+add;
    }


    public int getCredits() {
        return credits;
    }

    public void setCredits(int credits) {
        this.credits = credits;
    }

    public void addCredits(int add){
        this.credits = credits+add;
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
