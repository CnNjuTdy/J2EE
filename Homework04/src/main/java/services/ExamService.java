package services;

import model.entity.Exam;

import java.util.List;

/**
 * Created by Tondiyee on 2016/12/28.
 */
public interface ExamService {
    public List getExamList(String username);

    public Exam getExam(String username,String examName);
}
