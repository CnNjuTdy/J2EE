package com.hotelworld.entity;

import java.util.Date;

/**
 * Created by Tondiyee on 2017/3/3.
 */
public class Room {
    private String hotelDate;
    private int singleRoom;
    private int standardRoom;
    private int doubleRoom;
    private int suitRoom;

    public String getHotelDate() {
        return hotelDate;
    }

    public void setHotelDate(String hotelDate) {
        this.hotelDate = hotelDate;
    }


    public int getSingleRoom() {
        return singleRoom;
    }

    public void setSingleRoom(int singleRoom) {
        this.singleRoom = singleRoom;
    }

    public int getStandardRoom() {
        return standardRoom;
    }

    public void setStandardRoom(int standardRoom) {
        this.standardRoom = standardRoom;
    }

    public int getDoubleRoom() {
        return doubleRoom;
    }

    public void setDoubleRoom(int doubleRoom) {
        this.doubleRoom = doubleRoom;
    }

    public int getSuitRoom() {
        return suitRoom;
    }

    public void setSuitRoom(int suitRoom) {
        this.suitRoom = suitRoom;
    }

    public int getRoom(int x){
        switch (x){
            case 1:return singleRoom;
            case 2:return standardRoom;
            case 3:return doubleRoom;
            case 4:return suitRoom;
            default:return 0;
        }
    }

    public void addRoom(int roomType){
        switch (roomType){
            case 1:setSingleRoom(singleRoom+1);break;
            case 2:setStandardRoom(standardRoom+1);break;
            case 3:setDoubleRoom(doubleRoom+1);break;
            case 4:setSuitRoom(suitRoom+1);break;
            default:break;
        }
    }

    public void minRoom(int roomType){
        switch (roomType){
            case 1:setSingleRoom(singleRoom-1);break;
            case 2:setStandardRoom(standardRoom-1);break;
            case 3:setDoubleRoom(doubleRoom-1);break;
            case 4:setSuitRoom(suitRoom-1);break;
            default:break;
        }
    }
    @Override
    public String toString() {
        return "Room{" +
                "hotelDate='" + hotelDate + '\'' +
                ", singleRoom=" + singleRoom +
                ", standardRoom=" + standardRoom +
                ", doubleRoom=" + doubleRoom +
                ", suitRoom=" + suitRoom +
                '}';
    }
}
