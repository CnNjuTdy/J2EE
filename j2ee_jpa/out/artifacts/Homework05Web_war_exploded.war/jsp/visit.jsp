<%--
  Created by IntelliJ IDEA.
  User: Tondiyee
  Date: 2016/12/28
  Time: 19:45
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <title>Visit</title>
    <meta name="viewport" content="width=1000, initial-scale=1.0, maximum-scale=1.0">

    <!-- Loading Bootstrap -->
    <link href="http://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">

    <!-- Loading Flat UI -->
    <link href="//cdn.bootcss.com/flat-ui/2.3.0/css/flat-ui.min.css" rel="stylesheet">
    <jsp:useBean id="onlineNumber"
                 type="com.ejb.action.bussiness.OnlineBean"
                 scope="session"></jsp:useBean>
</head>
<body>
<div class="container" >
    <div class="row" style="margin-top: 50px">
        <div class="col-md-8 col-md-offset-2">
            <p>
                <strong>
                    这里是游客页面
                </strong>
            </p>
        </div>
    </div>
    <div class="row">
        <div class="col-md-8 col-md-offset-2">
            <%
                String sessionID = "";
                if(request.getSession(false)!=null){
                    sessionID = (String)request.getSession(false).getId();
                }
            %>
            <p>游客sessionID:<strong><%=sessionID%></strong></p>
        </div>
    </div>
    <div class="row">
        <div class="col-md-8 col-md-offset-2">
            <p>在线人数：<strong><%=onlineNumber.getLoginNumber()%></strong></p>
        </div>
    </div>
    <div class="row">
        <div class="col-md-8 col-md-offset-2">
            <p>游客人数：<strong><%=onlineNumber.getVisitNumber()%></strong></p>
        </div>
    </div>
    <div class="row">
        <div class="col-md-8 col-md-offset-2">
            <p>点击<a href="" onclick="doVisitOut()">这里</a>返回登录</p>
        </div>
    </div>
</div>

<script src="http://cdn.bootcss.com/jquery/3.1.1/jquery.min.js"></script>
<script src="http://cdn.bootcss.com/flat-ui/2.3.0/js/vendor/video.js"></script>
<script src="../js/util.js"></script>
</body>
</html>
