package servlets;

import action.bussiness.OnlineBean;
import net.sf.json.JSONObject;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Tonndiyee on 2016/12/20.
 */
@WebServlet("/visit.do")
public class VisitServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    public VisitServlet() {
        super();
    }

    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession(false);
        if (session == null) {
            resp.sendRedirect("login.do");
        } else {
            String visitorId = (String) session.getAttribute("visitUser");
            if (visitorId == null) {
                resp.sendRedirect("login.do");
            }else{
                // TODO: 2016/12/29 设置一个bean属性
                OnlineBean onlineBean = new OnlineBean();
                onlineBean.setLoginNumber((Integer) getServletContext().getAttribute("online"));
                onlineBean.setVisitNumber((Integer) getServletContext().getAttribute("offline"));
                session.setAttribute("onlineNumber",onlineBean);


                RequestDispatcher dispatcher = req.getRequestDispatcher("/jsp/visit.jsp");
                if (dispatcher != null) {
                    dispatcher.include(req, resp);
                }
            }
        }
    }
}
