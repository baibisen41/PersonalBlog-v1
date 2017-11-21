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
    <title>博客列表</title>
</head>
<body>
<a href="temp_edit_page.jsp">
    <input name="insertBtn" type="button" value="编辑博客" width="100" height="50" align="center"/>
</a>
<c:forEach var="blog" items="${blogList}">
    <table border="1" width="400">
        <tr>
            <td align="center" width="150">图片</td>
            <td align="center">${blog.blogPicUrl}</td>
        </tr>
        <tr>
            <td align="center" width="150">标题</td>
            <td align="center">
                <a href="<%=request.getContextPath()%>/showBlogDetail.do?id=${blog.blogId}">${blog.blogTitle}</a></td>
        </tr>
        <tr>
            <td align="center" width="150">内容</td>
            <td>${blog.blogSimpleContent}</td>
        </tr>
        <tr>
            <td align="center" width="150">${blog.blogTime}</td>
            <td align="center">${blog.blogAuthorName}</td>
        </tr>
    </table>
    <br>
</c:forEach>
</body>
</html>
