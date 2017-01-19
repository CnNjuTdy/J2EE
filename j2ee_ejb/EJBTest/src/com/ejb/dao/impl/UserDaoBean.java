package com.ejb.dao.impl;

import com.ejb.dao.DaoHelper;
import com.ejb.dao.UserDao;
import com.ejb.entity.User;

import javax.ejb.Local;
import javax.ejb.Stateless;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * Created by Tondiyee on 2016/12/28.
 */
@Stateless
@Local(UserDao.class)
public class UserDaoBean implements UserDao {
    private DaoHelper helper= DaoHelperImpl.getInstance();

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
//        return true;
        String sql = "select count(*) as count from user where username = ? and password = ?";
        ArrayList params = new ArrayList();
        params.add(username);
        params.add(password);
        ResultSet rs = helper.find(sql,params);
        boolean login = false;
        try {
            rs.next();
            login  = (rs.getInt("count")==1);
            System.out.println(rs.getInt("count"));
        }catch (SQLException e){
            e.printStackTrace();
        }finally {
            helper.closeConnection();
            helper.closeStatement();
            helper.closeResultSet(rs);
        }
        return login;
    }
}
