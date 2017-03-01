package com.hotelworld.util;

import com.hotelworld.entity.state.WebMessageState;

/**
 * Created by Tondiyee on 2017/2/27.
 */
public class WebMessage {
    String message;
    WebMessageState state;


    public WebMessage(String message, WebMessageState state) {
        this.message = message;
        this.state = state;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public WebMessageState getState() {
        return state;
    }

    public void setState(WebMessageState state) {
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
