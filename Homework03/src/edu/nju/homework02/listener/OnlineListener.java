package edu.nju.homework02.listener;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionBindingEvent;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

//在线人数统计监听器实现类
/**
 * 构想是这样的，监听HttpSessionAttribute
 * 访问ExamResult时,session添加一个loginUser
 * 访问Visitor时，session添加一个visitUser
 * 在以上两个页面退出时，分别移除相关的session
 **/
@WebListener
public class OnlineListener implements ServletContextListener,
        HttpSessionAttributeListener, HttpSessionListener {
    private ServletContext application = null;

    public void contextDestroyed(ServletContextEvent arg0) {
        // TODO Auto-generated method stub
    }

    public void contextInitialized(ServletContextEvent arg0) {
        //初始化一个application对象
        this.application = arg0.getServletContext();
        //设置一个列表属性，用于保存在想用户名
        this.application.setAttribute("online", 0);
        this.application.setAttribute("offline",0);
    }
    //往会话中添加属性时会回调的方法
    public void attributeAdded(HttpSessionBindingEvent arg0) {
        int online = (Integer) this.application.getAttribute("online");
        int offline = (Integer) this.application.getAttribute("offline");
        if ("loginUser".equals(arg0.getName())) {
            online++;
        }else if("visitName".equals(arg0.getName())){
            offline++;
        }
        //将添加后的列表重新设置到application属性中
        this.application.setAttribute("online", online);
        this.application.setAttribute("offline", offline);
    }
    //往会话中删除属性时会回调的方法
    public void attributeRemoved(HttpSessionBindingEvent arg0) {
        // TODO Auto-generated method stub
        int online = (Integer) this.application.getAttribute("online");
        int offline = (Integer) this.application.getAttribute("offline");
        if ("loginUser".equals(arg0.getName())) {
            online--;
        }else if("visitName".equals(arg0.getName())){
            offline--;
        }
        //将添加后的列表重新设置到application属性中
        this.application.setAttribute("online", online);
        this.application.setAttribute("offline", offline);
    }

    public void attributeReplaced(HttpSessionBindingEvent arg0) {
        // TODO Auto-generated method stub
    }

    public void sessionCreated(HttpSessionEvent arg0) {
        // TODO Auto-generated method stub
    }
    //会话销毁时会回调的方法
    public void sessionDestroyed(HttpSessionEvent arg0) {
        // TODO Auto-generated method stub
    }

}
