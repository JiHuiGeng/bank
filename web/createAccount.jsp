<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2020/2/18 0018
  Time: 14:31
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>用款账户创建</title>
    <!-- 引入 Bootstrap -->
    <link href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">
    <script src="https://cdn.staticfile.org/jquery/2.1.1/jquery.min.js"></script>
    <script src="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<body>
<div style="margin-top: 200px;margin-left: 600px;">
    <form class="form-horizontal" action="create" method="post" role="form">
        <div class="form-group">
            <label for="accNo" class="col-sm-2 control-label">账号</label>
            <div class="col-sm-3">
                <input type="text" id="accNo" name="accNo" class="form-control" placeholder="请输入账号">
            </div>
        </div>
        <div class="form-group">
            <label for="password" class="col-sm-2 control-label">密码</label>
            <div class="col-sm-3">
                <input type="password" id="password" name="password" class="form-control" placeholder="请输入密码">
            </div>
        </div>
        <div class="form-group">
            <label for="balance" class="col-sm-2 control-label">金额</label>
            <div class="col-sm-3">
                <input type="text" id="balance" name="balance" class="form-control" placeholder="请输入金额">
            </div>
        </div>
        <div class="form-group">
            <label for="password" class="col-sm-2 control-label">姓名</label>
            <div class="col-sm-3">
                <input type="text" id="name" name="name" class="form-control" placeholder="请输入姓名">
            </div>
        </div>
        <div class="form-group">
            <div class="col-sm-offset-2 col-sm-10">
                <button type="submit" class="btn btn-default">创建</button>
            </div>
        </div>
    </form>
</div>
</body>
</html>
