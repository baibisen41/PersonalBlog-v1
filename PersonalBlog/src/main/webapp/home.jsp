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
    <title>Home</title>
    <meta name="keywords" content="">
    <meta name="description" content="">
    <link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/css/bootstrap.min.css">
    <link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/css/nprogress.css">
    <link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/css/style.css">
    <link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/css/font-awesome.min.css">
    <link rel="apple-touch-icon-precomposed" href="<%=request.getContextPath()%>/images/icon.png">
    <link rel="shortcut icon" href="<%=request.getContextPath()%>/images/favicon.ico">
    <script src="<%=request.getContextPath()%>/js/jquery-2.1.4.min.js"></script>
    <script src="<%=request.getContextPath()%>/js/nprogress.js"></script>
    <script src="<%=request.getContextPath()%>/js/jquery.lazyload.min.js"></script>
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
            <div id="focusslide" class="carousel slide" data-ride="carousel">
                <ol class="carousel-indicators">
                    <li data-target="#focusslide" data-slide-to="0" class="active"></li>
                    <li data-target="#focusslide" data-slide-to="1"></li>
                    <li data-target="#focusslide" data-slide-to="2"></li>
                </ol>
                <div class="carousel-inner" role="listbox">
                    <div class="item active">
                        <a href="#" target="_blank" title="木庄网络博客源码">
                            <img src="<%=request.getContextPath()%>/images/home_page1.jpg" alt="木庄网络博客源码"
                                 class="img-responsive"></a>
                    </div>
                    <div class="item">
                        <a href="#" target="_blank" title="专业网站建设">
                            <img src="<%=request.getContextPath()%>/images/home_page2.jpg" alt="专业网站建设"
                                 class="img-responsive"></a>
                    </div>
                    <div class="item">
                        <a href="#" target="_blank" title="专业网站建设">
                            <img src="<%=request.getContextPath()%>/images/home_page3.jpg" alt="专业网站建设"
                                 class="img-responsive"></a>
                    </div>
                </div>
                <a class="left carousel-control" href="#focusslide" role="button" data-slide="prev" rel="nofollow">
                    <span class="glyphicon glyphicon-chevron-left" aria-hidden="true"></span> <span
                        class="sr-only">上一个</span> </a> <a class="right carousel-control" href="#focusslide"
                                                           role="button" data-slide="next" rel="nofollow"> <span
                    class="glyphicon glyphicon-chevron-right" aria-hidden="true"></span> <span
                    class="sr-only">下一个</span> </a></div>
            <%--<article class="excerpt-minic excerpt-minic-index">
                <h2><span class="red">【推荐】</span><a target="_blank" href="#" title="用DTcms做一个独立博客网站（响应式模板）">用DTcms做一个独立博客网站（响应式模板）</a>
                </h2>
                <p class="note">用DTcms做一个独立博客网站（响应式模板），采用DTcms V4.0正式版（MSSQL）。开发环境：SQL2008R2+VS2010。DTcms
                    V4.0正式版功能修复和优化：1、favicon.ico图标后台上传。（解决要换图标时要连FTP或者开服务器的麻烦）</p>
            </article>--%>
            <div class="title">
                <h3>精选博文</h3>
                <div class="more">
                    <a href="#" title="MZ-NetBlog主题">MZ-NetBlog主题</a>
                    <a href="#" title="IT技术笔记">IT技术笔记</a>
                    <a href="#" title="源码分享">源码分享</a>
                    <a href="#" title="靠谱网赚">靠谱网赚</a>
                    <a href="#" title="资讯分享">资讯分享</a>
                </div>
            </div>
            <c:forEach var="blog" items="${blogList}">
                <article class="excerpt excerpt-1" style="">
                    <a class="focus" href="#" title="用DTcms做一个独立博客网站（响应式模板）" target="_blank"><img class="thumb"
                                                                                                  data-original="images/message_pic.jpg"
                                                                                                  src="images/message_pic.jpg"
                                                                                                  alt="用DTcms做一个独立博客网站（响应式模板）"
                                                                                                  style="display: inline;"></a>
                    <header><a class="cat" href="#" title="MZ-NetBlog主题">${blog.blogLabel}<i></i></a>
                        <h2><a href="<%=request.getContextPath()%>/showBlogDetail.do?id=${blog.blogId}"
                               title="用DTcms做一个独立博客网站（响应式模板）"
                               target="_blank">${blog.blogTitle}</a>
                        </h2>
                    </header>
                    <p class="meta">
                        <time class="time"><i class="glyphicon glyphicon-time"></i> ${blog.blogTime}</time>
                        <span class="views"><i class="glyphicon glyphicon-eye-open"></i> ${blog.blogPv}</span> <a
                            class="comment"
                            href="##comment"
                            title="评论"
                            target="_blank"><i
                            class="glyphicon glyphicon-comment"></i> 4</a>
                    </p>
                    <p class="note">${blog.blogSimpleContent}</p>
                </article>
            </c:forEach>
            <%--  分页  --%>
            <c:if test="${totalPages > 1}">
                <div class="pagination" style="background: transparent">
                    <ul>
                        <li>
                            <a href="${pageContext.request.contextPath}/home.do?pagenum=1">首页</a>
                        </li>
                        <li class="prev-page"><a
                                href="${pageContext.request.contextPath}/home.do?pagenum=${nextPages - 1}">上一页</a>
                        </li>
                        <c:forEach var="pageIndex" begin="${startPage}" end="${endPage}">
                            <c:choose>
                                <c:when test="${pageIndex == nextPages}">
                                    <li class="active"><span> ${pageIndex} </span></li>
                                </c:when>
                                <c:otherwise>
                                    <li>
                                        <a href="${pageContext.request.contextPath}/home.do?pagenum=${pageIndex}">${pageIndex}</a>
                                    </li>
                                </c:otherwise>
                            </c:choose>
                        </c:forEach>

                        <c:if test="${nextPages != totalPages}">
                            <li class="next-page"><a
                                    href="${pageContext.request.contextPath}/home.do?pagenum=${nextPages+1}">下一页</a>
                            </li>
                        </c:if>
                        <li>
                            <a href="${pageContext.request.contextPath}/home.do?pagenum=${endPage}">末页</a>
                        </li>
                        <li>
                            <a>共${totalPages}页</a>
                        </li>
                    </ul>
                </div>
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
<script src="<%=request.getContextPath()%>/js/bootstrap.min.js"></script>
<%--<script src="<%=request.getContextPath()%>/js/jquery.ias.js"></script>--%>
<script src="<%=request.getContextPath()%>/js/scripts.js"></script>
</body>
</html>

