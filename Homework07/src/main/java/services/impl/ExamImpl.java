package services.impl;

import factory.DaoFactory;
import model.dao.ExamDao;
import model.entity.Exam;
import services.ExamService;

import java.util.List;

/**
 * Created by Tondiyee on 2016/12/28.
 */
public class ExamImpl implements ExamService {
    private static ExamImpl instance = null;
    private ExamDao dao = null;

    private ExamImpl() {
        dao = DaoFactory.getExamDao();
    }

    public static ExamImpl getInstance() {
        if (instance == null) {
            return new ExamImpl();
        } else {
            return instance;
        }
    }

    public List getExamList(String username) {
        return dao.getListByName(username);
    }

}
