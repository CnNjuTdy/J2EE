package services.impl;

import factory.DaoFactory;
import model.dao.UserDao;
import services.UserService;

/**
 * Created by Tondiyee on 2016/12/28.
 */
public class UserImpl implements UserService{
    private static UserImpl instance = null;
    private UserDao dao = null;

    private UserImpl() {
        dao = DaoFactory.getUserDao();
    }

    public static UserImpl getInstance() {
        if (instance == null) {
            return new UserImpl();
        } else {
            return instance;
        }
    }

    public boolean login(String username, String password) {
        return dao.verify(username,password);
    }
}
