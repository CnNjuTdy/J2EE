package services.impl;

import model.dao.ExamDao;
import model.entity.Exam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import services.ExamService;

import java.util.List;

/**
 * Created by Tondiyee on 2016/12/28.
 */
@Service("ExamService")
public class ExamImpl implements ExamService {
    @Autowired
    private ExamDao dao ;


    public List getExamList(String username) {
        return dao.getListByName(username);
    }

}
