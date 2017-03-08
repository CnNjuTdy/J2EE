package com.hotelworld.dao.impl;

import com.hotelworld.dao.ApplicationDao;
import com.hotelworld.entity.Application;
import com.hotelworld.entity.Hotel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Tondiyee on 2017/3/4.
 */
@Repository
public class ApplicationDaoImpl extends BaseDaoImpl implements ApplicationDao{
    public void saveApplication(Application application) {
        template.save(application);
    }

    public void delApplication(Application application) {
        template.delete(application);
    }

    public void updateApplication(Application application) {
        template.update(application);
    }

    public Application findApplicationById(String id) {
        return template.get(Application.class,id);
    }

    public List<Application> findAllApplication() {
        return findBySQL("select * from application",null,Application.class);
    }
}
