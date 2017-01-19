package com.ejb.services.impl;

import com.ejb.dao.ExamDao;
import com.ejb.entity.Exam;
import com.ejb.services.ExamService;

import javax.ejb.EJB;
import javax.ejb.Remote;
import javax.ejb.Stateless;
import java.util.List;

/**
 * Created by Tondiyee on 2016/12/28.
 */
@Stateless(name = "ExamServiceBean")
@Remote(ExamService.class)
public class ExamServiceBean implements ExamService {
    private static ExamServiceBean instance = null;
    @EJB private ExamDao dao;


    @Override
    public List getExamList(String username) {
        return dao.getListByName(username);
    }

    @Override
    public Exam getExam(String username, String examName) {
        return dao.getExamByName(username,examName);
    }
}
