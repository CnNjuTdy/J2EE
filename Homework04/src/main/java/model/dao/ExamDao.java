package model.dao;

import model.entity.Exam;

import java.util.List;

/**
 * Created by Tondiyee on 2016/12/28.
 */
public interface ExamDao {
    public boolean save(Exam exam);

    public List getListByName(String username);

    public Exam getExamByName(String username,String examName);
}
