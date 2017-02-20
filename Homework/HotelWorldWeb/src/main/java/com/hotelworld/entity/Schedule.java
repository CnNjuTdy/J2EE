package com.hotelworld.entity;

import java.util.Date;

/**
 * Created by Tondiyee on 2017/2/3.
 */
public class Schedule {
    private String id;
    private String hotelId;
    private Date startDate;
    private Date endDate;
    private int priceSingle;
    private int priceStandard;
    private int priceDouble;
    private int priceSuit;
    private int isDefault;

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

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public int getPriceSingle() {
        return priceSingle;
    }

    public void setPriceSingle(int priceSingle) {
        this.priceSingle = priceSingle;
    }

    public int getPriceStandard() {
        return priceStandard;
    }

    public void setPriceStandard(int priceStandard) {
        this.priceStandard = priceStandard;
    }

    public int getPriceDouble() {
        return priceDouble;
    }

    public void setPriceDouble(int priceDouble) {
        this.priceDouble = priceDouble;
    }

    public int getPriceSuit() {
        return priceSuit;
    }

    public void setPriceSuit(int priceSuit) {
        this.priceSuit = priceSuit;
    }

    public int getIsDefault() {
        return isDefault;
    }

    public void setIsDefault(int isDefault) {
        this.isDefault = isDefault;
    }

    @Override
    public String toString() {
        return "Schedule{" +
                "id='" + id + '\'' +
                ", hotelId='" + hotelId + '\'' +
                ", startDate=" + startDate +
                ", endDate=" + endDate +
                ", priceSingle=" + priceSingle +
                ", priceStandard=" + priceStandard +
                ", priceDouble=" + priceDouble +
                ", priceSuit=" + priceSuit +
                ", isDefault=" + isDefault +
                '}';
    }
}
