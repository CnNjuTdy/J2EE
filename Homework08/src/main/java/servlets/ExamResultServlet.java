package servlets;

import action.bussiness.ExamListBean;
import action.bussiness.OnlineBean;
import model.entity.Exam;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;
import services.ExamService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

/**
 * Servlet implementation class Login
 */
@WebServlet("/exam.do")
public class ExamResultServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public ExamService service = null;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public ExamResultServlet() {
        super();
    }

    @Override
    public void init() throws ServletException{
        WebApplicationContext wac = WebApplicationContextUtils.getWebApplicationContext(this.getServletContext());
        service = wac.getBean("ExamService",ExamService.class);
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession(false);
        if (session == null) {
            resp.sendRedirect("login.do");
        } else {
            String username = (String) session.getAttribute("loginUser");
            if (username == null) {
                resp.sendRedirect("login.do");
            } else {
                RequestDispatcher dispatcher = req.getRequestDispatcher("/jsp/exam.jsp");
                // TODO: 2016/12/29 设置两个bean属性
                ExamListBean examListBean = new ExamListBean();
                examListBean.setExamList((List<Exam>) service.getExamList(username));
                session.setAttribute("examList",examListBean);

                OnlineBean onlineBean = new OnlineBean();
                onlineBean.setLoginNumber((Integer) getServletContext().getAttribute("online"));
                onlineBean.setVisitNumber((Integer) getServletContext().getAttribute("offline"));
                session.setAttribute("onlineNumber",onlineBean);

                session.setAttribute("username",username);
                if (dispatcher != null) {
                    dispatcher.include(req, resp);
                }
            }
        }

    }


}
