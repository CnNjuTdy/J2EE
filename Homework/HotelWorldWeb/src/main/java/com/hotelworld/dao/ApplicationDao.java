package com.hotelworld.dao;

import com.hotelworld.entity.Application;

import java.util.List;

/**
 * Created by Tondiyee on 2017/3/4.
 */
public interface ApplicationDao {
    public void saveApplication(Application application);

    public void delApplication(Application application);

    public void updateApplication(Application application);

    public Application findApplicationById(String id);

    //返回的应该是所有的Application，按照时间顺序，包括已经处理的Application
    public List<Application> findAllApplication();
}
