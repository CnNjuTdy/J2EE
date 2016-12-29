package model.dao.impl;

import model.dao.DaoHelper;
import model.dao.ExamDao;
import model.entity.Exam;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Tondiyee on 2016/12/28.
 */
public class ExamDaoImpl implements ExamDao{
    private static ExamDaoImpl instance = null;
    private DaoHelper helper= null;
    private ExamDaoImpl(){
        helper = DaoHelperImpl.getInstance();
    }
    public static ExamDaoImpl getInstance(){
        if(instance == null){
            return new ExamDaoImpl();
        }
        else {
            return instance;
        }
    }

    @Override
    public boolean save(Exam exam) {
        return false;
    }

    @Override
    public List getListByName(String username) {
        String sql = "select * from examResult where username = ?";
        List params = new ArrayList();
        params.add(username);
        ResultSet rs = helper.find(sql,params);
        ArrayList list = new ArrayList();
        try {
            while (rs.next()){
                Exam exam = new Exam(
                        rs.getString("examName"),
                        rs.getInt("examMark"),
                        rs.getInt("q1Mark"),
                        rs.getInt("q2Mark"),
                        rs.getInt("q3Mark"));
                list.add(exam);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }finally {
            helper.closeResultSet(rs);
        }
        return list;
    }

    @Override
    public Exam getExamByName(String username, String examName) {
        return null;
    }
}
