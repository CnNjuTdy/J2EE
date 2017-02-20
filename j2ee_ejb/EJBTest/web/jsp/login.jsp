<%--
  Created by IntelliJ IDEA.
  User: Tondiyee
  Date: 2016/12/28
  Time: 19:40
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="utf-8">
    <title>Login</title>
    <meta name="viewport" content="width=1000, initial-scale=1.0, maximum-scale=1.0">

    <!-- Loading Bootstrap -->
    <link href="http://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">

    <!-- Loading Flat UI -->
    <link href="//cdn.bootcss.com/flat-ui/2.3.0/css/flat-ui.min.css" rel="stylesheet">
</head>
<body>
<div class="container">
    <div class="row" style="margin-top: 50px">
        <div class="col-md-6 col-md-offset-3">
            <div class="panel panel-success">
                <div class="panel-heading text-center">
                    <strong>学生测验情况查询系统登录</strong>
                </div>
                <div class="panel-body">
                    <div class="row">
                        <div class="col-md-12">
                            <div class="form-group col-md-12">
                                <input id="username" type="text" value="" placeholder="昵称"
                                       class="form-control">
                            </div>
                            <div class="form-group col-md-12">
                                <input id="password" type="password" value="" placeholder="密码"
                                       class="form-control">
                            </div>
                        </div>
                    </div>
                    <div class="row">
                        <div class="col-md-6">
                            <button type="button" class="btn btn-block btn-primary" onclick="doLogin()">确认登录</button>
                        </div>
                        <div class="col-md-6">
                            <button type="button" class="btn btn-block btn-primary" onclick="doVisitIn()">游客模式</button>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>

<script src="http://cdn.bootcss.com/jquery/3.1.1/jquery.min.js"></script>
<script src="http://cdn.bootcss.com/flat-ui/2.3.0/js/vendor/video.js"></script>
<script src="js/util.js"></script>
</body>
</html>
