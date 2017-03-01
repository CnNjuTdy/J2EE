package services.impl;

import model.dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import services.UserService;

/**
 * Created by Tondiyee on 2016/12/28.
 */
@Service("UserService")
public class UserImpl implements UserService{
    @Autowired
    private UserDao dao ;


    public boolean login(String username, String password) {
        return dao.verify(username,password);
    }
}
