<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2020/2/17 0017
  Time: 12:34
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>XXX银行登陆界面</title>
    <link href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
<div style="margin-top: 300px;margin-left: 500px;">
    <form class="form-horizontal" action="login" method="post" role="form">
        <div class="form-group">
            <label for="accNo" class="col-sm-2 control-label">用户名</label>
            <div class="col-sm-3">
                <input type="text" id="accNo" name="accNo" class="form-control" placeholder="请输入用户名">
            </div>
        </div>
        <div class="form-group">
            <label for="password" class="col-sm-2 control-label">密码</label>
            <div class="col-sm-3">
                <input type="password" id="password" name="password" class="form-control" placeholder="请输入密码">
            </div>
        </div>
        <div class="form-group">
            <div class="col-sm-offset-2 col-sm-10">
                <div class="checkbox">
                    <label>
                        <input type="checkbox">请记住我
                    </label>
                </div>
            </div>
        </div>
        <div class="form-group">
            <div class="col-sm-offset-2 col-sm-10">
                <button type="submit" class="btn btn-default">登录</button>
            </div>
        </div>
    </form>
</div>

</body>
</html>
