package model.dao.impl;

import model.dao.UserDao;
import model.entity.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;

/**
 * Created by Tondiyee on 2016/12/28.
 */
@Repository
public class UserDaoImpl implements UserDao {
    @Autowired
    private HibernateTemplate template;

    public boolean verify(String username, String password) {
        User user = template.get(User.class,username);
        Boolean b = false;
        if (user == null) {
            b = false;
        } else {
            b = user.getPassword().equals(password);
        }
        return b;
    }
}
