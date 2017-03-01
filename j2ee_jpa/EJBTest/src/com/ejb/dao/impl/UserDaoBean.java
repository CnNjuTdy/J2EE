package com.ejb.dao.impl;

import com.ejb.dao.DaoHelper;
import com.ejb.dao.ExamDao;
import com.ejb.dao.UserDao;
import com.ejb.entity.User;

import javax.ejb.Local;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * Created by Tondiyee on 2016/12/28.
 */
@Stateless(name = "UserDaoBean")
@Local(UserDao.class)
public class UserDaoBean implements UserDao {
    @PersistenceContext(unitName = "j2ee_student")
    protected EntityManager em;

    @Override
    public User findByName(String username) {
        return null;
    }

    @Override
    public boolean save(User user) {
        return false;
    }

    @Override
    public boolean verify(String username, String password) {
        User user = em.find(User.class,username);
        System.out.println(user.getUsername());
        System.out.println(user.getPassword());
        return user.getPassword().equals(password);
    }
}
