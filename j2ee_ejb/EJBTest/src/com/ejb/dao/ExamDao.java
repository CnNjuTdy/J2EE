package com.ejb.dao;

import com.ejb.entity.Exam;

import javax.ejb.Local;
import javax.ejb.Remote;
import java.util.List;

/**
 * Created by Tondiyee on 2016/12/28.
 */
@Local
public interface ExamDao {
    public boolean save(Exam exam);

    public List getListByName(String username);

    public Exam getExamByName(String username, String examName);
}
