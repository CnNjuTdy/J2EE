package model.dao.impl;

import model.dao.DaoHelper;
import model.dao.UserDao;
import model.entity.User;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * Created by Tondiyee on 2016/12/28.
 */
public class UserDaoImpl implements UserDao {
    private static UserDaoImpl instance = null;
    private DaoHelper helper= null;
    private UserDaoImpl(){
        helper = DaoHelperImpl.getInstance();
    }

    public static UserDaoImpl getInstance() {
        if (instance == null) {
            return new UserDaoImpl();
        } else {
            return instance;
        }
    }

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
        String sql = "select count(*) as count from user where username = ? and password = ?";
//        String sql = "select count(*) as count from user where username = \""+username+"\" and password = \""+password+"\"";
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
