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
    <title>问题列表</title>
</head>
<body>
<form name="sendForum" method="post" action="/SchoolServer/forum/forwardForumMessage.do">
    <input name="sendForumButton" type="submit" value="发帖"/>
</form>

<table border="1">


    <c:forEach var="forum" items="${forumlist}">
        <tr>
            <td>${forum.forumid}</td>
            <td>${forum.forumuserid}</td>
            <td>${forum.forumusername}</td>
            <td>${forum.forumtime}</td>
            <td>${forum.forumcontent}</td>
            <td>
                <form id="forumid" action="/SchoolServer/forum/showForumDetail.do" method="post">
                    <input name="forum_detail_id" type="hidden" value="${forum.forumid}"/>
                    <input name="forum_detail_button" type="submit" value="查看详情"/>
                </form>

            </td>
        </tr>
    </c:forEach>

</table>
</body>
</html>
