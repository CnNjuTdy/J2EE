package com.ejb.dao.impl;

import com.ejb.dao.DaoHelper;
import com.ejb.dao.ExamDao;
import com.ejb.entity.Exam;

import javax.ejb.Local;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Tondiyee on 2016/12/28.
 */
@Stateless(name = "ExamDaoBean")
@Local(ExamDao.class)
public class ExamDaoBean implements ExamDao{
    @PersistenceContext(unitName = "j2ee_student")
    protected EntityManager em;
    @Override
    public List getListByName(String username) {
        String sql = "SELECT * FROM examresult where username = ?";
        Query query = em.createNativeQuery(sql,Exam.class);
        query.setParameter(1,username);
        List<Exam> examList = query.getResultList();
        return examList;
    }
    @Override
    public Exam getExamByName(String username, String examName) {
        return null;
    }

}
