package edu.nju.homework02.servlets;

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
@WebServlet("/user.visit")
public class VisitServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    public VisitServlet() {
        super();
    }

    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession(false);
        if (session == null) {
            resp.sendRedirect("user.log");
        } else {
            String visitorId = (String) session.getAttribute("visitUser");
            if (visitorId == null) {
                resp.sendRedirect("user.log");
            }else{
                RequestDispatcher dispatcher = req.getRequestDispatcher("/user/visit.html");
                if (dispatcher != null) {
                    dispatcher.include(req, resp);
                }
            }
        }
    }
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter pw = resp.getWriter();
        Map params =  new HashMap();
        params.put("visitorId", req.getSession().getId());
        params.put("online", getServletContext().getAttribute("online"));
        params.put("offline", getServletContext().getAttribute("offline"));
        JSONObject object = JSONObject.fromObject(params);
        pw.write(object.toString());
    }
}
