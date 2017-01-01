package servlets;


import factory.ServiceFactory;
import services.UserService;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class Login
 */
@WebServlet("/login.do")
public class LoginServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private UserService service = null;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
    }

    public void init() {
        service = ServiceFactory.getUserService();
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response);
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if (request.getSession() != null) {
            if (request.getSession().getAttribute("loginUser") != null) {
                response.sendRedirect("exam.do");
                return;
            }
            if (request.getSession().getAttribute("visitUser") != null) {
                response.sendRedirect("visit.do");
                return;
            }
        }
        ServletContext context = getServletContext();
        try {
            context.getRequestDispatcher("/jsp/login.jsp").forward(request, response);
        } catch (ServletException e) {
            response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR,
                    "This is a ServletException.");
        }
    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String actionType = req.getParameter("type");
        if (actionType.equals("login")) {
            String username = req.getParameter("username");
            String password = req.getParameter("password");
            boolean state = service.login(username, password);
            PrintWriter pw = resp.getWriter();
            if (state) {
                HttpSession session = req.getSession();
                session.setAttribute("loginUser", username);
                pw.write("right");
            } else {
                pw.write("error");
            }
        } else if (actionType.equals("logout")) {
            HttpSession session = req.getSession();
            session.removeAttribute("loginUser");
        } else if (actionType.equals("visitIn")) {
            HttpSession session = req.getSession();
            session.setAttribute("visitUser", session.getId());
        } else if (actionType.equals("visitOut")) {
            HttpSession session = req.getSession();
            session.removeAttribute("visitUser");
        }
    }

//    private String verifyUser(String username, String password) {
//        System.out.println(username+" "+password);
//        Connection connection = null;
//        PreparedStatement stmt = null;
//        ResultSet rs = null;
//        try {
//            connection = dbHelper.getConnection();
//            stmt = connection.prepareStatement("select count(*) from user where username = ? and password = ?");
//            stmt.setString(1,username);
//            stmt.setString(2,password);
//            rs = stmt.executeQuery();
//            rs.next();
//            if (rs.getInt("count(*)") == 0) {
//                System.out.println(rs.getInt("count(*)"));
//                return "loginError";
//            }
//            connection.close();
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//        return "loginRight";
//    }


}
