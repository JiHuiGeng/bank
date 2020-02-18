<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2020/2/12 0012
  Time: 15:17
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>日志页面</title>
    <!-- 引入 Bootstrap -->
    <link href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">
    <script src="https://cdn.staticfile.org/jquery/2.1.1/jquery.min.js"></script>
    <script src="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<body>
<div class="table-responsive">
    <table class="table table-bordered table-hover">
        <caption style="text-align: center;">转账交易日志</caption>
        <thead>
        <tr>
            <th>转出账户</th>
            <th>转入账户</th>
            <th>转账金额</th>
        </tr>
        </thead>
        <thead>
        <c:forEach items="${pageHelper.list}" var="list">
            <tr>
                <td>${list.outAccNo}</td>
                <td>${list.inAccNo}</td>
                <td>${list.money}</td>
            </tr>
        </c:forEach>
        </thead>
    </table>
    <a href="show?pageSize=${pageHelper.pageSize}&pageNumber=${pageHelper.pageNumber-1}"
            <c:if test="${pageHelper.pageNumber<=1}">
                onclick="javaScript:return false";
            </c:if>>上一页</a>
    <a href="show?pageSize=${pageHelper.pageSize}&pageNumber=${pageHelper.pageNumber+1}"
            <c:if test="${pageHelper.pageNumber>=pageHelper.total}">
                onclick="javaScript:return false";
            </c:if>>下一页</a>
</div>

</body>
</html>
