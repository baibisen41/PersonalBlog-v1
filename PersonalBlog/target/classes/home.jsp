<%--
  Created by IntelliJ IDEA.
  User: 大森
  Date: 2017/8/24
  Time: 21:28
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="/SchoolServer/mvc/checkLogin.do" id="homepage" method="post">
    username:<input name="id" type="text"/>
    password:<input name="password" type="text"/>
    <input id="login" type="submit" value="ok"/>
</form>
</body>
</html>
