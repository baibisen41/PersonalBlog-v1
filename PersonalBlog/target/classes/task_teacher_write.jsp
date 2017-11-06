<%--
  Created by IntelliJ IDEA.
  User: 大森
  Date: 2017/9/9
  Time: 20:52
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>下达任务</title>
</head>
<body>
<form id="writeTaskForm" method="post" action="/SchoolServer/task/writeTaskMessage.do">
    任务信息：<input id="writeTask" name="writeTask" type="text"/>
    <input id="submitTask" name="submitTask" type="submit" value="提交"/>
</form>
</body>
</html>
