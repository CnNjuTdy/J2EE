package com.hotelworld.entity;

/**
 * Created by Tondiyee on 2017/3/7.
 */

import java.util.List;

/**
 * 某个hotel的最近一个月的经营情况
 * 1. 每天的每种房间预定情况（折线图）
 * 2. 每天的营业额（折线图）
 * 3. 各种房间的营业额（柱状图和扇形图）
 * 4. 每天的入住情况和离店情况（列表）
 */
public class HotelBusinessConditions {
    private List<Integer> singleRoomData;
    private List<Integer> standardRoomData;
    private List<Integer> doubleRoomData;
    private List<Integer> suitRoomData;
    private List<Integer> turnovers;
    private int singleTurnover;
    private int standardTurnover;
    private int doubleTurnover;
    private int suitTurnover;
    private List<CheckInLog> checkInLogs;
    private List<CheckOutLog> checkOutLogs;

    public HotelBusinessConditions(List<Integer> singleRoomData, List<Integer> standardRoomData,
                                   List<Integer> doubleRoomData, List<Integer> suitRoomData, List<Integer> turnovers,
                                   int singleTurnover, int standardTurnover, int doubleTurnover, int suitTurnover,
                                   List<CheckInLog> checkInLogs, List<CheckOutLog> checkOutLogs) {
        this.singleRoomData = singleRoomData;
        this.standardRoomData = standardRoomData;
        this.doubleRoomData = doubleRoomData;
        this.suitRoomData = suitRoomData;
        this.turnovers = turnovers;
        this.singleTurnover = singleTurnover;
        this.standardTurnover = standardTurnover;
        this.doubleTurnover = doubleTurnover;
        this.suitTurnover = suitTurnover;
        this.checkInLogs = checkInLogs;
        this.checkOutLogs = checkOutLogs;
    }

    public void setSingleRoomData(List<Integer> singleRoomData) {
        this.singleRoomData = singleRoomData;
    }


    public void setStandardRoomData(List<Integer> standardRoomData) {
        this.standardRoomData = standardRoomData;
    }


    public void setDoubleRoomData(List<Integer> doubleRoomData) {
        this.doubleRoomData = doubleRoomData;
    }


    public void setSuitRoomData(List<Integer> suitRoomData) {
        this.suitRoomData = suitRoomData;
    }

    public void setSingleTurnover(int singleTurnover) {
        this.singleTurnover = singleTurnover;
    }

    public void setStandardTurnover(int standardTurnover) {
        this.standardTurnover = standardTurnover;
    }

    public void setDoubleTurnover(int doubleTurnover) {
        this.doubleTurnover = doubleTurnover;
    }

    public void setSuitTurnover(int suitTurnover) {
        this.suitTurnover = suitTurnover;
    }

    public List<Integer> getTurnovers() {
        return turnovers;
    }

    public void setTurnovers(List<Integer> turnovers) {
        this.turnovers = turnovers;
    }


    public List<CheckInLog> getCheckInLogs() {
        return checkInLogs;
    }

    public void setCheckInLogs(List<CheckInLog> checkInLogs) {
        this.checkInLogs = checkInLogs;
    }

    public List<CheckOutLog> getCheckOutLogs() {
        return checkOutLogs;
    }

    public void setCheckOutLogs(List<CheckOutLog> checkOutLogs) {
        this.checkOutLogs = checkOutLogs;
    }

    private List<Integer> getRoomDataByType(int type) {
        switch (type) {
            case 1:
                return singleRoomData;
            case 2:
                return standardRoomData;
            case 3:
                return doubleRoomData;
            case 4:
                return suitRoomData;
            default:
                return null;
        }
    }

    private int getTurnoverByType(int type) {
        switch (type) {
            case 1:
                return singleTurnover;
            case 2:
                return standardTurnover;
            case 3:
                return doubleTurnover;
            case 4:
                return suitTurnover;
            default:
                return 0;
        }
    }
}
