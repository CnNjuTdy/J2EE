package com.ejb.services;

import com.ejb.entity.Exam;

import javax.ejb.Remote;
import java.util.List;

/**
 * Created by Tondiyee on 2016/12/28.
 */
@Remote
public interface ExamService {
    public List getExamList(String username);

    public Exam getExam(String username,String examName);
}
