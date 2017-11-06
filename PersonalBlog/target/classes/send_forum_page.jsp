<%--
  Created by IntelliJ IDEA.
  User: 大森
  Date: 2017/9/14
  Time: 22:21
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>发帖界面</title>
</head>
<body>
<form name="sendForumForm" action="/SchoolServer/forum/sendForumMessage.do" method="post">
    <textarea name="forumContent" cols=40 rows=10 name=text style="background-color:#1eb86b"></textarea>
    <input name="sendForumButton" type="submit" value="发送"/>
</form>
</body>
</html>
