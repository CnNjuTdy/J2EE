package com.ejb.services.impl;

import com.ejb.dao.UserDao;
import com.ejb.services.UserService;

import javax.ejb.EJB;
import javax.ejb.Remote;
import javax.ejb.Stateless;

/**
 * Created by Tondiyee on 2016/12/28.
 */
@Stateless(name = "UserServiceBean")
@Remote(UserService.class)
public class UserServiceBean implements UserService{
    @EJB UserDao dao;



    @Override
    public boolean login(String username, String password) {
        return dao.verify(username,password);
    }
}
