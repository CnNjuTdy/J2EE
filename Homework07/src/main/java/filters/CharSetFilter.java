package filters;


import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by Tonndiyee on 2016/12/20.
 */
@WebFilter("/*")
public class CharSetFilter implements Filter {
    String encoding = null;

    public void init(FilterConfig filterConfig) throws ServletException {
        this.encoding = "UTF-8";
    }

    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {

        if(servletRequest instanceof HttpServletRequest && servletResponse instanceof HttpServletResponse) {
            servletResponse.setCharacterEncoding(encoding);
            servletRequest.setCharacterEncoding(encoding);
        }
        filterChain.doFilter(servletRequest,servletResponse);
    }

    public void destroy() {
        this.encoding=null;
    }
}
