package edu.nju.homework02.servlets;

import edu.nju.homework02.DBHelper;
import edu.nju.homework02.model.Exam;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.sql.DataSource;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

/**
 * Servlet implementation class Login
 */
@WebServlet("/exam.result")
public class ExamResultServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private DBHelper dbHelper = null;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public ExamResultServlet() {
        super();
    }

    public void init() {
        dbHelper = DBHelper.getInstance();
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession(false);
        if (session == null) {
            resp.sendRedirect("user.log");
        } else {
            String username = (String) session.getAttribute("loginUser");
            if (username == null) {
                resp.sendRedirect("user.log");
            }else{
                RequestDispatcher dispatcher = req.getRequestDispatcher("/exam/result.html");
                if (dispatcher != null) {
                    dispatcher.include(req, resp);
                }
            }
        }

    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // TODO Auto-generated method stub
        HttpSession session = req.getSession(false);
        String username = (String) session.getAttribute("loginUser");
        PrintWriter pw = resp.getWriter();
        System.out.println(getResult(username));
        pw.write(getResult(username));
    }

    private String getResult(String username) {
        Map params =  new HashMap();
        String state = "normal";

        Connection connection = null;
        PreparedStatement stmt = null;
        ArrayList list = new ArrayList();
        ResultSet rs = null;
        try {
            connection = dbHelper.getConnection();
            stmt = connection.prepareStatement("select * from examResult where username = ?");
            stmt.setString(1, username);
            rs = stmt.executeQuery();
            while (rs.next()){
                Exam exam = new Exam(rs.getString("examName"),rs.getInt("examMark"),rs.getInt("q1Mark"),rs.getInt("q2Mark"),rs.getInt("q3Mark"));
                if(rs.getInt("examMark")<=60){
                    state = "abnormal";
                }
                list.add(exam);
            }
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        params.put("online", getServletContext().getAttribute("online"));
        params.put("offline", getServletContext().getAttribute("offline"));
        params.put("username",username);
        params.put("examState", state);
        params.put("examResult", JSONArray.fromObject(list));
        JSONObject object = JSONObject.fromObject(params);
        return object.toString();
    }

}
