package action.bussiness;

import model.entity.Exam;

import java.io.Serializable;
import java.util.List;

/**
 * Created by Tondiyee on 2016/12/28.
 */

public class ExamListBean implements Serializable {
    private static final long serialVersionUID = 1L;

    private List<Exam> examList;
    private String state;

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public List getExamList() {
        return examList;
    }

    public void setExamList(List<Exam> examList2) {
        examList = examList2;
        // TODO: 2016/12/28 业务逻辑！
        for (int i=0;i<examList2.size();i++){
            Exam exam = examList2.get(i);
            if(exam.getExamMark()<60){
                state = "abnormal";
                return;
            }
        }
        state = "normal";
    }

    public Exam getExam(int index) {
        return (Exam) examList.get(index);
    }

    public void setExam(Exam exam, int index) {
        examList.set(index, exam);
        // TODO: 2016/12/28 业务逻辑!
        if(exam.getExamMark()<60){
            state = "abnormal";
        }
    }


}
