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
    <meta charset="utf-8">
    <title>Exam</title>
    <!--<meta name="viewport" content="width=1000, initial-scale=1.0, maximum-scale=1.0">-->
    <link href="http://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">
    <link href="http://cdn.bootcss.com/flat-ui/2.3.0/css/flat-ui.min.css" rel="stylesheet">
</head>
<body>
<div class="container">
    <div class="row" style="margin-top: 30px">
        <div class="col-md-12">
            <p>学生姓名：<strong id="username"></strong></p>
            <p class="text-danger"><strong id="danger"></strong></p>
        </div>
    </div>
    <div class="row">
        <div class="col-md-10 col-md-offset-1">
            <div class="panel panel-success" id="resultTable">
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
                    <tbody id="result">
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
            在线人数：<strong id="online"></strong>
        </div>
        <div class="col-md-6 text-center">
            游客人数：<strong id="offline"></strong>
        </div>
    </div>
</div>
<script src="http://cdn.bootcss.com/jquery/3.1.1/jquery.min.js"></script>
<script src="http://cdn.bootcss.com/flat-ui/2.3.0/js/vendor/video.js"></script>
<script src="../js/util.js"></script>
</body>
</html>