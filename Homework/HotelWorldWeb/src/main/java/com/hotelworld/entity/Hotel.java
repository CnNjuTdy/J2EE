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
    private int balance;
    private int canFound;

    public Hotel(){}

    public Hotel(String id, String boss, String city, String address, int maxSingle, int maxStandard, int maxDouble, int maxSuit, int balance, int canFound) {
        this.id = id;
        this.boss = boss;
        this.city = city;
        this.address = address;
        this.maxSingle = maxSingle;
        this.maxStandard = maxStandard;
        this.maxDouble = maxDouble;
        this.maxSuit = maxSuit;
        this.balance = balance;
        this.canFound = canFound;
    }

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

    public int getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }

    public void addBalance(int add){
        this.balance = balance+add;
    }

    public int getCanFound() {
        return canFound;
    }

    public void setCanFound(int canFound) {
        this.canFound = canFound;
    }

    public int getMaxRoom(int i){
        switch (i){
            case 1:return maxSingle;
            case 2:return maxStandard;
            case 3:return maxDouble;
            case 4:return maxSuit;
            default:return 0;
        }
    }

    public void setMaxRoom(int i,int maxRoom){
        switch (i){
            case 1:maxSingle = maxRoom;break;
            case 2:maxStandard = maxRoom;break;
            case 3:maxDouble = maxRoom;break;
            case 4:maxSuit = maxRoom;break;
            default:break;
        }
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

