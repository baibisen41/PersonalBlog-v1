<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: 大森
  Date: 2017/9/2
  Time: 11:28
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false" %>
<html>
<head>
    <title>任务下发</title>
</head>
<body>
<table border="1">
    <tr>
        <th>学号</th>
        <th>姓名</th>
        <th>完成情况</th>
        <td>下发时间</td>
        <td>任务内容</td>
        <th>操作</th>
        <th>操作</th>
    </tr>

    <form name="writeTask" method="post" action="/SchoolServer/task/writeTaskMessage.do">
        <c:forEach var="task" items="${taskList}">
            <tr>
                <td>${task.userid}</td>
                <td>${task.username}</td>
                <td>${task.taskstatus}</td>
                <td>${task.tasktime}</td>
                <td>${task.taskcontent}</td>
                <td>查看任务</td>
                <td><input name="writetask" type="text"/> <input name="ok" type="submit" value="ok"/></td>
            </tr>
        </c:forEach>
    </form>
</table>
</body>
</html>
