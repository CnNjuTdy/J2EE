package com.hotelworld.util;

import com.hotelworld.entity.state.WebResultState;

/**
 * Created by Tondiyee on 2017/3/2.
 */
public class WebObject<T> {
    private WebResultState state;
    private T object;

    public WebObject(WebResultState state, T object) {
        this.state = state;
        this.object = object;
    }

    public WebResultState getState() {
        return state;
    }

    public void setState(WebResultState state) {
        this.state = state;
    }

    public T getObject() {
        return object;
    }

    public void setObject(T object) {
        this.object = object;
    }
}
