<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: 大森
  Date: 2017/9/10
  Time: 21:58
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false" %>

<html>
<head>
    <title>问题详情</title>
</head>
<body>
<table border="1">


    <c:forEach var="forumDetail" items="${forumDetailList}">
        <tr>
            <td>帖子:</td>
            <td>${forumDetail.forumcontent}</td>
            <td>${forumDetail.forumusername}</td>
            <td>${forumDetail.forumtime}</td>
        </tr>
        <tr>
            <td>回复如下:</td>
            <td>${forumDetail.replycontent}</td>
            <td>${forumDetail.replyusername}</td>
            <td>${forumDetail.replytime}</td>
        </tr>
    </c:forEach>

</table>
<form name="sendReplyForm" action="/SchoolServer/forum/sendReplyMessage.do" method="post">
    <textarea name="replyContent" cols=40 rows=10 style="background-color:#40b2da"></textarea>
    <input name="replyforumid" type="hidden" value="${forumId}"/>
    <input name="sendReplyButton" type="submit" value="回复"/>
</form>
</body>
</html>
