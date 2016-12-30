package action.bussiness;

import java.io.Serializable;

/**
 * Created by Tondiyee on 2016/12/29.
 */
public class OnlineBean implements Serializable{
    private static final long serialVersionUID = 1L;

    private int loginNumber;
    private int visitNumber;

    public int getLoginNumber() {
        return loginNumber;
    }

    public void setLoginNumber(int loginNumber) {
        this.loginNumber = loginNumber;
    }

    public int getVisitNumber() {
        return visitNumber;
    }

    public void setVisitNumber(int visitNumber) {
        this.visitNumber = visitNumber;
    }
}
