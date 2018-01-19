<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: 大森
  Date: 2017/12/16
  Time: 23:15
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false" %>
<html>
<head>
    <title>test</title>
</head>
<body>

<div>
    <c:forEach var="blog" items="${blogList}">
        <article class="excerpt excerpt-1"><a class="focus" href="#" title="personalblog"
                                              target="_blank"><img
                class="thumb" data-original="images/message_pic.jpg" src="images/message_pic.jpg"
                alt="personalblog" style="display: inline;"></a>
            <header><a class="cat" href="#" title="blogTheme">${blog.blogLabel}<i></i></a>
                <h2><a href="<%=request.getContextPath()%>/showBlogDetail.do?id=${blog.blogId}"
                       title="personalblog" target="_blank">${blog.blogTitle}</a></h2>
            </header>
            <p class="meta">
                <time class="time"><i class="glyphicon glyphicon-time"></i>${blog.blogTime}</time>
                <span class="views"><i class="glyphicon glyphicon-eye-open"></i> ${blog.blogPv}</span> <a
                    class="comment"
                    href="##comment"
                    title="评论"
                    target="_blank"><i
                    class="glyphicon glyphicon-comment"></i> 4</a></p>
            <p class="note">${blog.blogSimpleContent}</p>
        </article>
    </c:forEach>

    <c:if test="${totalPages > 1}">
        <div class="pagination" style="background: transparent">
            <ul>
                <li>
                    <a href="${pageContext.request.contextPath}/showBlogList.do?pagenum=1">首页</a>
                </li>
                <li class="prev-page"><a
                        href="${pageContext.request.contextPath}/showBlogList.do?pagenum=${nextPages - 1}">上一页</a>
                </li>
                <c:forEach var="pageIndex" begin="${startPage}" end="${endPage}">
                    <c:choose>
                        <c:when test="${pageIndex == nextPages}">
                            <li class="active"><span> ${pageIndex} </span></li>
                        </c:when>
                        <c:otherwise>
                            <li>
                                <a href="${pageContext.request.contextPath}/showBlogList.do?pagenum=${pageIndex}">${pageIndex}</a>
                            </li>
                        </c:otherwise>
                    </c:choose>
                </c:forEach>

                <c:if test="${nextPages != totalPages}">
                    <li class="next-page"><a
                            href="${pageContext.request.contextPath}/showBlogList.do?pagenum=${nextPages+1}">下一页</a>
                    </li>
                </c:if>
                <li>
                    <a href="${pageContext.request.contextPath}/showBlogList.do?pagenum=${endPage}">末页</a>
                </li>
                <li>
                    <a>共${totalPages}页</a>
                </li>
            </ul>
        </div>
    </c:if>
</div>

</body>
</html>
