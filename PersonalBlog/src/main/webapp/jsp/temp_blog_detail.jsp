<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: 大森
  Date: 2017/11/18
  Time: 11:17
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false" %>
<html>
<head>
    <title>博客详情</title>
</head>
<body>

<table border="1" width="1000" align="center">
    <tr>
        <td align="center" width="150">标题区</td>
        <td align="center">${blogDetail.blogTitle}
        </td>
    </tr>

    <tr>
        <td align="center" width="150">来自区</td>
        <td align="center">${blogDetail.blogTime}来自${blogDetail.blogAuthorName} ;
            标签:${blogDetail.blogLabel}</td>
    </tr>

    <tr>
        <td align="center" width="150">图片区</td>
        <td align="center">${blogDetail.blogPicUrl}</td>
    </tr>

    <tr>
        <td align="center" width="150">内容区</td>
        <td>${blogDetail.blogDetailContent}</td>
    </tr>
</table>

<c:forEach var="replyDetail" items="${replyDetail}">
    <table border="1" width="1000" align="center">
        <tr>
            <td align="center" width="150">回复区</td>
            <td align="center">${replyDetail.replyTime}来自${replyDetail.replyAuthorName}</td>
        </tr>
        <tr>
            <td align="center" width="150">回复内容区</td>
            <td align="center">${replyDetail.replyContent}</td>
        </tr>
    </table>
</c:forEach>
<form name="reply_form" action="<%=request.getContextPath()%>/editReplyDetail.do" method="post">
    <textarea name="reply_text" rows="5" cols="20"></textarea>
    <input name="reply_btn" type="submit" value="ok"/>
    <input name="reply_hidden" type="hidden" value="${blogDetail.blogId}"/>
</form>
</body>
</html>
