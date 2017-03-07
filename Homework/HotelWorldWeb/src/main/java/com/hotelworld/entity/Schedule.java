package com.hotelworld.entity;

import java.util.Date;

/**
 * Created by Tondiyee on 2017/2/3.
 */
public class Schedule {
    private String id;
    private String hotelId;
    private Date date;
    private int priceSingle;
    private int priceStandard;
    private int priceDouble;
    private int priceSuit;
    private int isDefault;

    public Schedule() {
    }

    public Schedule(String id, String hotelId, Date date, int priceSingle, int priceStandard, int priceDouble, int priceSuit, int isDefault) {
        this.id = id;
        this.hotelId = hotelId;
        this.date = date;
        this.priceSingle = priceSingle;
        this.priceStandard = priceStandard;
        this.priceDouble = priceDouble;
        this.priceSuit = priceSuit;
        this.isDefault = isDefault;
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

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
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


    public int getPrice(int roomType){
        switch (roomType){
            case 1:return priceSingle;
            case 2:return priceStandard;
            case 3:return priceDouble;
            case 4:return priceSuit;
            default:return 0;
        }
    }

    @Override
    public String toString() {
        return "Schedule{" +
                "id='" + id + '\'' +
                ", hotelId='" + hotelId + '\'' +
                ", startDate=" + date +
                ", priceSingle=" + priceSingle +
                ", priceStandard=" + priceStandard +
                ", priceDouble=" + priceDouble +
                ", priceSuit=" + priceSuit +
                ", isDefault=" + isDefault +
                '}';
    }
}
