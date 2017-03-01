<%--
  Created by IntelliJ IDEA.
  User: Tondiyee
  Date: 2017/1/18
  Time: 17:52
  To change this template use File | Settings | File Templates.
--%>
<%@page import="javax.naming.InitialContext"%>
<%@page import="com.ejb.HelloWorld"%>
<%@page import="javax.naming.NamingException"%>
<%@ page import="java.util.Hashtable" %>
<%@ page import="javax.naming.Context" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>$Title$</title>
  </head>
  <body>
  <%
    final String appName = "";
    final String moduleName = "EJBTest_war_exploded";
    final String distinctName = "";
    final String beanName = "HelloWorldEJB";
    final String viewClassName = HelloWorld.class.getName();
    final String namespace = "ejb:" + appName + "/" + moduleName
            + "/" + distinctName + "/" + beanName + "!" + viewClassName;
    System.out.println(namespace);
    String outString = "ok";
    try {
      final Hashtable jndiProperties = new Hashtable();
      jndiProperties.put(Context.URL_PKG_PREFIXES, "org.jboss.ejb.client.naming");
      final Context context = new InitialContext(jndiProperties);
      HelloWorld helloWorld = (HelloWorld) context.lookup(namespace);
      System.out.println(helloWorld);
      outString = helloWorld.sayHello("world");
      System.out.println(outString);
    }catch (NamingException e) {
      e.printStackTrace();
    }
  %>
  <%=outString%>
  </body>
</html>
