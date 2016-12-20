package edu.nju.homework02.servlets;

import edu.nju.homework02.DBHelper;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class Login
 */
@WebServlet("/user.log")
public class LoginServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private DBHelper dbHelper = null;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
    }

    public void init() {
        dbHelper = DBHelper.getInstance();
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response);
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("/user/login.html");
        if (dispatcher != null) {
            dispatcher.include(request, response);
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
            String state = verifyUser(username, password);
            if (state.equals("loginRight")) {
                HttpSession session = req.getSession();
                session.setAttribute("loginUser", username);
            }
            PrintWriter pw = resp.getWriter();
            pw.write(state);
        }else if(actionType.equals("logout")){
            HttpSession session = req.getSession();
            session.removeAttribute("loginUser");
        }
    }

    private String verifyUser(String username, String password) {
        Connection connection = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try {
            connection = dbHelper.getConnection();
            stmt = connection.prepareStatement("select COUNT(*) as count from user where username = ? and password = ?");
            stmt.setString(1, username);
            stmt.setString(2, password);
            rs = stmt.executeQuery();
            rs.next();
            if (rs.getInt("count") == 0) {
                return "loginError";
            }
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return "loginRight";
    }


}
