package com.hotelworld.entity;

/**
 * Created by Tondiyee on 2017/3/7.
 */

import java.util.List;

/**
 * 主要包括：
 * 1. 每家店的营业情况
 * 2. 处在激活状态的会员数目变化情况（折线）
 * 3. Hotel机构的收入情况和支出情况（收入来自于会员支付的5%，支出来自于会员积分的兑换）
 */
public class AllBusinessConditions {
    private List<Hotel> hotels;
    private int[] memberNumbers;
    private int income;
    private int expend;

    public AllBusinessConditions(List<Hotel> hotels, int[] memberNumbers, int income, int expend) {
        this.hotels = hotels;
        this.memberNumbers = memberNumbers;
        this.income = income;
        this.expend = expend;
    }

    public List<Hotel> getHotels() {
        return hotels;
    }

    public void setHotels(List<Hotel> hotels) {
        this.hotels = hotels;
    }

    public int[] getMemberNumbers() {
        return memberNumbers;
    }

    public void setMemberNumbers(int[] memberNumbers) {
        this.memberNumbers = memberNumbers;
    }

    public int getIncome() {
        return income;
    }

    public void setIncome(int income) {
        this.income = income;
    }

    public int getExpend() {
        return expend;
    }

    public void setExpend(int expend) {
        this.expend = expend;
    }
}
