package model.dao;

import model.entity.User;

/**
 * Created by Tondiyee on 2016/12/28.
 */
public interface UserDao {
    public User findByName(String username);

    public boolean save(User user);

    public boolean verify(String user,String password);
}
