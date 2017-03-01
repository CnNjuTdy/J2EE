package factory;

import model.dao.ExamDao;
import model.dao.UserDao;
import model.dao.impl.ExamDaoImpl;
import model.dao.impl.UserDaoImpl;

/**
 * Created by Tondiyee on 2016/12/28.
 */
public class DaoFactory {
    public static ExamDao getExamDao (){
        return ExamDaoImpl.getInstance();
    }
    public static UserDao getUserDao (){
        return UserDaoImpl.getInstance();
    }
}
