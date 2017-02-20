package com.hotelworld.entity;

/**
 * Created by Tondiyee on 2017/2/3.
 */
public class Hotel {
    private String id;
    private String boss;
    private String city;
    private String address;
    private int maxSingle;
    private int maxStandard;
    private int maxDouble;
    private int maxSuit;


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getBoss() {
        return boss;
    }

    public void setBoss(String boss) {
        this.boss = boss;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getMaxSingle() {
        return maxSingle;
    }

    public void setMaxSingle(int maxSingle) {
        this.maxSingle = maxSingle;
    }

    public int getMaxStandard() {
        return maxStandard;
    }

    public void setMaxStandard(int maxStandard) {
        this.maxStandard = maxStandard;
    }

    public int getMaxDouble() {
        return maxDouble;
    }

    public void setMaxDouble(int maxDouble) {
        this.maxDouble = maxDouble;
    }

    public int getMaxSuit() {
        return maxSuit;
    }

    public void setMaxSuit(int maxSuit) {
        this.maxSuit = maxSuit;
    }

    @Override
    public String toString() {
        return "Hotel{" +
                "id='" + id + '\'' +
                ", boss='" + boss + '\'' +
                ", city='" + city + '\'' +
                ", address='" + address + '\'' +
                ", maxSingle=" + maxSingle +
                ", maxStandard=" + maxStandard +
                ", maxDouble=" + maxDouble +
                ", maxSuit=" + maxSuit +
                '}';
    }
}

