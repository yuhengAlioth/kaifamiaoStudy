<%--
  Created by IntelliJ IDEA.
  User: 15322
  Date: 2023/10/25
  Time: 20:09
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false" %>
<%--引入jstl核心库--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
    <style>
        td {
            width: 150px;
        }
    </style>
</head>
<body>
hello
<%--test 条件 true/false ${条件表达式}--%>
<c:if test="${1 > 2}">
    一大于2
</c:if>
<c:if test="${1 < 2}">
    一小于2
</c:if>

<br>

<%--items 要遍历的对象（容器）--%>
<%--for (KfmUser u : list) {}--%>
<table border="1" cellpadding="1">
    <tr>
        <th>序号</th>
        <th>ID</th>
        <th>用户名</th>
        <th>密码</th>
        <th>邮箱</th>
        <th>操作</th>
    </tr>
    <c:forEach items="${all}" var="users" varStatus="state">
        <%--count 1 开始计数--%>
        <%--index 0 开始计数--%>
    <tr>
            <%--    index: ${state.index}--%>
        <td>${state.count}</td>
        <td>${users.id}</td>
        <td>${users.username}</td>
        <td>${users.password}</td>
        <td>${users.email}</td>
        <td>
            <a href="">修改</a>
            <a href="/delete?id=${users.id}">删除</a>
        </td>
    <tr>
        </c:forEach>
</table>
</body>
</html>
