package com.ejb.dao;

import com.ejb.entity.User;

import javax.ejb.Local;
import javax.ejb.Remote;
import javax.ejb.Stateless;

/**
 * Created by Tondiyee on 2016/12/28.
 */
@Local
public interface UserDao {
    public User findByName(String username);

    public boolean save(User user);

    public boolean verify(String user, String password);
}
