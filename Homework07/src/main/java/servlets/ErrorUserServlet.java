package servlets;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by Tonndiyee on 2016/12/20.
 */
@WebServlet("/error.do")
public class ErrorUserServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    public ErrorUserServlet() {
        super();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("/jsp/error.jsp");
        if (dispatcher!= null){
            dispatcher.include(request,response);
        }
    }
}
