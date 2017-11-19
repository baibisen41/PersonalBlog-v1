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
        <td align="center" valign="center" width="150">标题区</td>
        <td align="center" valign="center">${blogDetail.blogTitle}
        </td>
    </tr>

    <tr>
        <td align="center" valign="center" width="150">来自区</td>
        <td align="center" valign="center">${blogDetail.blogTime}来自${blogDetail.blogAuthorName} ;
            标签:${blogDetail.blogLabel}</td>
    </tr>

    <tr>
        <td align="center" valign="center" width="150">图片区</td>
        <td align="center" valign="center">${blogDetail.blogPicUrl}</td>
    </tr>

    <tr>
        <td align="center" valign="center" width="150">内容区</td>
        <td align="center" valign="center">${blogDetail.blogDetailContent}</td>
    </tr>

    <tr>
        <td align="center" valign="center" width="150">回复区</td>
        <td align="center" valign="center">${replyDetail.replyTime}来自${replyDetail.replyAuthorName}</td>
    </tr>

    <tr>
        <td align="center" valign="center" width="150">回复内容区</td>
        <td align="center" valign="center">${replyDetail.replyContent}</td>
    </tr>
</table>

</body>
</html>
