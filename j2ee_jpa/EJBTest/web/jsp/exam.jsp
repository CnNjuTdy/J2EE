<%@ page import="com.ejb.entity.Exam" %><%--
  Created by IntelliJ IDEA.
  User: Tondiyee
  Date: 2016/12/28
  Time: 19:45
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <title>Exam</title>
    <!--<meta name="viewport" content="width=1000, initial-scale=1.0, maximum-scale=1.0">-->
    <link href="http://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">
    <link href="http://cdn.bootcss.com/flat-ui/2.3.0/css/flat-ui.min.css" rel="stylesheet">
    <jsp:useBean id="examList"
                 type="com.ejb.bussiness.ExamListBean"
                 scope="session"></jsp:useBean>
    <jsp:useBean id="onlineNumber"
                 type="com.ejb.bussiness.OnlineBean"
                 scope="session"></jsp:useBean>
    <jsp:useBean id="exam"
                 class="com.ejb.entity.Exam"
                 scope="page"></jsp:useBean>
</head>
<body>
<div class="container">
    <div class="row" style="margin-top: 30px">
        <div class="col-md-12">
            <%
                String username = "";
                if (request.getSession(false) != null && request.getSession().getAttribute("username") != null) {
                    username = (String) request.getSession().getAttribute("username");
                }
            %>
            <p>学生姓名：<strong><%=username%>
            </strong></p>
            <%if (examList.getState().equals("abnormal")) { %>
            <p class="text-danger"><strong id="danger">您有课程未参加测验或测验结果不及格！</strong></p>
            <%}%>
        </div>
    </div>
    <div class="row">
        <div class="col-md-10 col-md-offset-1">
            <%if (examList.getState().equals("abnormal")) {%>
            <div class="panel panel-danger">
                <%} else {%>
                <div class="panel panel-success">
                    <%}%>
                    <div class="panel-heading text-center">
                        测验情况
                    </div>
                    <table class="table">
                        <thead>
                        <tr>
                            <th>课程名称</th>
                            <th>测验总分</th>
                            <th>选择得分</th>
                            <th>填空得分</th>
                            <th>问答得分</th>
                        </tr>
                        </thead>
                        <tbody>
                        <%
                            for (int i = 0; i < examList.getExamList().size(); i++) {
                                pageContext.setAttribute("exam", examList.getExam(i));
                                Exam item = examList.getExam(i);
                                if (item.getExamMark() == -3) {
                        %>
                        <tr class="text-danger">
                                <%}else if(item.getExamMark()<60){%>
                        <tr class="text-warning">
                                <%}else {%>
                        <tr>
                            <%}%>
                            <td>
                                <jsp:getProperty name="exam" property="examName"/>
                            </td>
                            <%if (item.getExamMark() == -3) {%>
                            <td>未参加</td>
                            <td>无分数</td>
                            <td>无分数</td>
                            <td>无分数</td>
                            <%} else {%>
                            <td>
                                <jsp:getProperty name="exam" property="examMark"/>
                            </td>
                            <td>
                                <jsp:getProperty name="exam" property="q1Mark"/>
                            </td>
                            <td>
                                <jsp:getProperty name="exam" property="q2Mark"/>
                            </td>
                            <td>
                                <jsp:getProperty name="exam" property="q3Mark"/>
                            </td>
                            <%}%>
                        </tr>
                        <%}%>
                        </tbody>
                    </table>
                </div>
            </div>
        </div>
        <div class="row">
            <div class="col-md-6 col-md-offset-3">
                <button type="button" class="btn btn-info btn-lg btn-block" onclick="doLogout()">退出登录</button>
            </div>
        </div>
        <div class="row" style="margin-top: 20px">
            <div class="col-md-6 text-center">
                在线人数：<%=onlineNumber.getLoginNumber()%>
            </div>
            <div class="col-md-6 text-center">
                游客人数：<%=onlineNumber.getVisitNumber()%>
            </div>
        </div>
    </div>
    <script src="http://cdn.bootcss.com/jquery/3.1.1/jquery.min.js"></script>
    <script src="http://cdn.bootcss.com/flat-ui/2.3.0/js/vendor/video.js"></script>
    <script src="js/util.js"></script>
</div>
</body>
</html>