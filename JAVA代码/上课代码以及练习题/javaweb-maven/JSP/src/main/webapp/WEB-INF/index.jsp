<%@ page import="cn.aliothstar.model.KfmUser" %>
<%--
  Created by IntelliJ IDEA.
  User: 15322
  Date: 2023/10/25
  Time: 15:15
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%KfmUser LoginUser = (KfmUser) session.getAttribute("loginUser");System.out.println(LoginUser.getUsername());%>
${loginUser.username},你好，欢迎登录
</body>
</html>
