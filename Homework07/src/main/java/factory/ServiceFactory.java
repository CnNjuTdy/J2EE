package factory;

import services.ExamService;
import services.UserService;
import services.impl.ExamImpl;
import services.impl.UserImpl;

/**
 * Created by Tondiyee on 2016/12/28.
 */
public class ServiceFactory {
    public static ExamService getExamService (){
        return ExamImpl.getInstance();
    }
    public static UserService getUserService (){
        return UserImpl.getInstance();
    }
}
