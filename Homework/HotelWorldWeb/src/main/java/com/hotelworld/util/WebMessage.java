package com.hotelworld.util;

import com.hotelworld.entity.state.WebResultState;

/**
 * Created by Tondiyee on 2017/2/27.
 */
public class WebMessage {
    String message;
    WebResultState state;


    public WebMessage(String message, WebResultState state) {
        this.message = message;
        this.state = state;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public WebResultState getState() {
        return state;
    }

    public void setState(WebResultState state) {
        this.state = state;
    }

    @Override
    public String toString() {
        return "WebMessage{" +
                "message='" + message + '\'' +
                ", state=" + state +
                '}';
    }
}
