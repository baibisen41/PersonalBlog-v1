<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: 大森
  Date: 2017/9/20
  Time: 22:16
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false" %>
<html>
<head>
    <title>用户信息列表</title>
</head>
<body>

<form name="changePasswordFrom" action="" method="post">
    修改密码：<input type="submit" name="changePassword" id="changePassword">
</form>

<table border="1">

    <tr>
        <th>已发布的帖子如下：</th>
    </tr>
    <c:forEach var="forum" items="${forumList}">
        <tr>
            <td>${forum.forumid}</td>
            <td>${forum.forumcontent}</td>
            <td>${forum.forumtime}</td>
        </tr>


    </c:forEach>

    <tr>
        <th>已回复的信息如下：</th>
    </tr>
    <c:forEach var="reply" items="${replyList}">
        <tr>
            <td>${reply.replyid}</td>
            <td>${reply.replycontent}</td>
            <td>${reply.replytime}</td>
        </tr>

    </c:forEach>

    <tr>
        <th>本周任务如下：</th>
    </tr>
    <c:forEach var="task" items="${taskList}">
        <tr>
            <td>${task.tasktime}</td>
            <td>${task.taskcontent}</td>
            <td>${task.taskstatus}</td>
        </tr>

    </c:forEach>

</table>

</body>
</html>
