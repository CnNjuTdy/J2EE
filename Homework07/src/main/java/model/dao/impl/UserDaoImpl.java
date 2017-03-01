package model.dao.impl;

import model.dao.UserDao;
import model.entity.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

/**
 * Created by Tondiyee on 2016/12/28.
 */
public class UserDaoImpl implements UserDao {
    private static UserDaoImpl instance = null;
    private UserDaoImpl() {
    }

    public static UserDaoImpl getInstance() {
        if (instance == null) {
            return new UserDaoImpl();
        } else {
            return instance;
        }
    }

    public boolean verify(String username, String password) {
        Configuration config = new Configuration().configure("hibernate.cfg.xml");
        config.addResource("User.hbm.xml");
        ServiceRegistry registry = new StandardServiceRegistryBuilder().applySettings(config.getProperties()).build();
        SessionFactory sessionFactory = config.buildSessionFactory(registry);

        Session session = sessionFactory.openSession();
        Transaction tx = session.beginTransaction();
        User user = session.get(User.class, username);
        Boolean b = false;
        if (user == null) {
            b = false;
        } else {
            b = user.getPassword().equals(password);
        }
        tx.commit();
        session.close();
        return b;
    }
}
