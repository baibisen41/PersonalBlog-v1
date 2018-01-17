<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: 大森
  Date: 2017/11/23
  Time: 21:14
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false" %>
<!doctype html>
<html lang="zh-CN">
<head>
    <meta charset="utf-8">
    <meta name="renderer" content="webkit">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>list</title>
    <meta name="keywords" content="">
    <meta name="description" content="">
    <link rel="stylesheet" type="text/css" href="css/bootstrap.min.css">
    <link rel="stylesheet" type="text/css" href="css/nprogress.css">
    <link rel="stylesheet" type="text/css" href="css/style.css">
    <link rel="stylesheet" type="text/css" href="css/font-awesome.min.css">
    <link rel="apple-touch-icon-precomposed" href="images/icon.png">
    <link rel="shortcut icon" href="images/favicon.ico">
    <script src="js/jquery-2.1.4.min.js"></script>
    <script src="js/nprogress.js"></script>
    <script src="js/jquery.lazyload.min.js"></script>
    <!--[if gte IE 9]>
    <script src="js/jquery-1.11.1.min.js" type="text/javascript"></script>
    <script src="js/html5shiv.min.js" type="text/javascript"></script>
    <script src="js/respond.min.js" type="text/javascript"></script>
    <script src="js/selectivizr-min.js" type="text/javascript"></script>
    <![endif]-->
    <!--[if lt IE 9]>
    <script>window.location.href = 'upgrade-browser.html';</script>
    <![endif]-->
</head>
<body class="user-select">
<%@include file="header_common_bar.jsp" %>
<section class="container">
    <div class="content-wrap">
        <div class="content">
            <div class="title">
                <h3 style="line-height: 1.3">
                    <a href="<%=request.getContextPath()%>/news.do">最新发布 </a>
                    |
                    <a href="<%=request.getContextPath()%>/news.do?type=1"> 热门资讯</a>
                </h3>
            </div>
            <c:forEach var="news" items="${newsList}">
                <article class="excerpt excerpt-1"><a class="focus" href="#" title="用DTcms做一个独立博客网站（响应式模板）"
                                                      target="_blank"><img
                        class="thumb" data-original="images/message_pic.jpg" src="images/message_pic.jpg"
                        alt="用DTcms做一个独立博客网站（响应式模板）" style="display: inline;"></a>
                    <header><a class="cat" href="#" title="MZ-NetBlog主题">来自 ${news.newsFrom}<i></i></a>
                        <c:if test="${newsUrl == 0}">
                            <h2><a href="<%=request.getContextPath()%>/showNewsDetail.do?id=${news.newsId}"
                                   title="用DTcms做一个独立博客网站（响应式模板）" target="_blank">${news.newsTitle}</a></h2>
                        </c:if>
                        <c:if test="${newsUrl == 1}">
                            <h2><a href="<%=request.getContextPath()%>/showNewsDetail.do?type=1&id=${news.newsId}"
                                   title="用DTcms做一个独立博客网站（响应式模板）" target="_blank">${news.newsTitle}</a></h2>
                        </c:if>
                    </header>
                    <p class="meta">
                        <time class="time"><i class="glyphicon glyphicon-time"></i>${news.newsTime}</time>
                        <span class="views"><i class="glyphicon glyphicon-eye-open"></i> 10</span> <a
                            class="comment"
                            href="##comment"
                            title="评论"
                            target="_blank"><i
                            class="glyphicon glyphicon-comment"></i> 4</a></p>
                    <p class="note">${news.newsSummary}</p>
                </article>
            </c:forEach>

            <%--  分页  --%>
            <c:if test="${newsUrl == 0}">
                <c:if test="${totalPages > 1}">
                    <div class="pagination" style="background: transparent">
                        <ul>
                            <li>
                                <a href="${pageContext.request.contextPath}/news.do?pagenum=1">首页</a>
                            </li>
                            <li class="prev-page"><a
                                    href="${pageContext.request.contextPath}/news.do?pagenum=${nextPages - 1}">上一页</a>
                            </li>
                            <c:forEach var="pageIndex" begin="${startPage}" end="${endPage}">
                                <c:choose>
                                    <c:when test="${pageIndex == nextPages}">
                                        <li class="active"><span> ${pageIndex} </span></li>
                                    </c:when>
                                    <c:otherwise>
                                        <li>
                                            <a href="${pageContext.request.contextPath}/news.do?pagenum=${pageIndex}">${pageIndex}</a>
                                        </li>
                                    </c:otherwise>
                                </c:choose>
                            </c:forEach>

                            <c:if test="${nextPages != totalPages}">
                                <li class="next-page"><a
                                        href="${pageContext.request.contextPath}/news.do?pagenum=${nextPages+1}">下一页</a>
                                </li>
                            </c:if>
                            <li>
                                <a href="${pageContext.request.contextPath}/news.do?pagenum=${totalPages}">末页</a>
                            </li>
                            <li>
                                <a>共${totalPages}页</a>
                            </li>
                        </ul>
                    </div>
                </c:if>
            </c:if>
            <c:if test="${newsUrl == 1}">
                <c:if test="${totalPages > 1}">
                    <div class="pagination" style="background: transparent">
                        <ul>
                            <li>
                                <a href="${pageContext.request.contextPath}/news.do?type=1&pagenum=1">首页</a>
                            </li>
                            <li class="prev-page"><a
                                    href="${pageContext.request.contextPath}/news.do?type=1&pagenum=${nextPages - 1}">上一页</a>
                            </li>
                            <c:forEach var="pageIndex" begin="${startPage}" end="${endPage}">
                                <c:choose>
                                    <c:when test="${pageIndex == nextPages}">
                                        <li class="active"><span> ${pageIndex} </span></li>
                                    </c:when>
                                    <c:otherwise>
                                        <li>
                                            <a href="${pageContext.request.contextPath}/news.do?type=1&pagenum=${pageIndex}">${pageIndex}</a>
                                        </li>
                                    </c:otherwise>
                                </c:choose>
                            </c:forEach>

                            <c:if test="${nextPages != totalPages}">
                                <li class="next-page"><a
                                        href="${pageContext.request.contextPath}/news.do?type=1&pagenum=${nextPages+1}">下一页</a>
                                </li>
                            </c:if>
                            <li>
                                <a href="${pageContext.request.contextPath}/news.do?type=1&pagenum=${endPage}">末页</a>
                            </li>
                            <li>
                                <a>共${totalPages}页</a>
                            </li>
                        </ul>
                    </div>
                </c:if>
            </c:if>
        </div>
    </div>
    <%@include file="side_common_bar.jsp" %>
</section>
<footer class="footer">
    <div class="container">
        <p>Copyright &copy; 2016.Company name All rights reserved.<a target="_blank" href="http://sc.chinaz.com/moban/">&#x7F51;&#x9875;&#x6A21;&#x677F;</a>
        </p>
    </div>
    <div id="gotop"><a class="gotop"></a></div>
</footer>
<script src="js/bootstrap.min.js"></script>
<%--<script src="js/jquery.ias.js"></script>--%>
<script src="js/scripts.js"></script>
</body>
</html>