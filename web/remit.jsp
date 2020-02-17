<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2020/2/9 0009
  Time: 12:58
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>转账页面</title>
    <!-- 引入 Bootstrap -->
    <link href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
<form class="form-horizontal" action="remit" method="post" role="form">
    <div class="form-group">
        <label for="outAccNo" class="col-sm-2 control-label">转账账户</label>
        <div class="col-sm-2">
            <input type="text" class="form-control" id="outAccNo" name="outAccNo" placeholder="请输入转账账户">
        </div>
    </div>

    <div class="form-group">
        <label for="outPassword" class="col-sm-2 control-label">密码</label>
        <div class="col-sm-2">
            <input type="password" class="form-control" id="outPassword" name="outPassword" placeholder="请输入密码">
        </div>
    </div>

    <div class="form-group">
        <label for="outBalance" class="col-sm-2 control-label">金额</label>
        <div class="col-sm-2">
            <input type="text" class="form-control" id="outBalance" name="outBalance" placeholder="请输入金额">
        </div>
    </div>

    <div class="form-group">
        <label for="inAccNo" class="col-sm-2 control-label">收款账号</label>
        <div class="col-sm-2">
            <input type="text" class="form-control" id="inAccNo" name="inAccNo" placeholder="请输入收款账号">
        </div>
    </div>

    <div class="form-group">
        <label for="inName" class="col-sm-2 control-label">收款人姓名</label>
        <div class="col-sm-2">
            <input type="text" class="form-control" id="inName" name="inName" placeholder="请输入收款人姓名">
        </div>
    </div>
    <div class="form-group">
        <div class="col-sm-offset-2 col-sm-10">
            <button type="submit" class="btn btn-default">转账</button>
        </div>
    </div>
</form>
</body>
</html>
