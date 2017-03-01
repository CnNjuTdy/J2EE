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
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Tondiyee on 2016/12/28.
 */
@Repository
public class ExamDaoImpl implements ExamDao{
    @Autowired
    private SessionFactory sessionFactory;

    public List getListByName(String username) {
        Session session = sessionFactory.openSession();
        String sql = "select * from examResult where username = \""+username+"\"";
        Query query = session.createSQLQuery(sql);
        List<Object[]> list = query.list();
        List<Exam> list2 = new ArrayList<Exam>();
        for(Object[] objects:list){
            Exam exam = new Exam(objects[1]+"",(Integer) objects[2],(Integer)objects[3],
                    (Integer)objects[4],(Integer) objects[5]);
            list2.add(exam);
        }
        return list2;
    }

}
