package model.dao.impl;

import model.dao.ExamDao;

import model.entity.Exam;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Tondiyee on 2016/12/28.
 */
public class ExamDaoImpl implements ExamDao{
    private static ExamDaoImpl instance = null;
    private ExamDaoImpl(){
    }
    public static ExamDaoImpl getInstance(){
        if(instance == null){
            return new ExamDaoImpl();
        }
        else {
            return instance;
        }
    }

    public List getListByName(String username) {
        Configuration config = new Configuration().configure("hibernate.cfg.xml");
        config.addResource("Exam.hbm.xml");
        ServiceRegistry registry = new StandardServiceRegistryBuilder().applySettings(config.getProperties()).build();
        SessionFactory sessionFactory = config.buildSessionFactory(registry);

        Session session = sessionFactory.openSession();
        Transaction tx = session.beginTransaction();
        String sql = "select * from examResult where username = \""+username+"\"";
        Query query = session.createSQLQuery(sql);
        List<Object[]> list = query.list();
        List<Exam> list2 = new ArrayList<Exam>();
        for(Object[] objects:list){
            Exam exam = new Exam(objects[1]+"",(Integer) objects[2],(Integer)objects[3],
                    (Integer)objects[4],(Integer) objects[5]);
            list2.add(exam);
        }
        tx.commit();
        session.close();
        return list2;
    }

}
