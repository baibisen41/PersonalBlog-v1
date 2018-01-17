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
<%--<header class="header">
    <nav class="navbar navbar-default" id="navbar">
        <div class="container">
            <div class="header-topbar hidden-xs link-border">
                <ul class="site-nav topmenu">
                    <li><a href="#">标签云</a></li>
                    <li><a href="#" rel="nofollow">读者墙</a></li>
                    <li><a href="#" title="RSS订阅">
                        <i class="fa fa-rss">
                        </i> RSS订阅
                    </a></li>
                </ul>
                勤记录 懂分享
            </div>
            <div class="navbar-header">
                <button type="button" class="navbar-toggle collapsed" data-toggle="collapse"
                        data-target="#header-navbar" aria-expanded="false"><span class="sr-only"></span> <span
                        class="icon-bar"></span> <span class="icon-bar"></span> <span class="icon-bar"></span></button>
                <h1 class="logo hvr-bounce-in"><a href="#" title="木庄网络博客"><img src="images/logo.png"
                                                                               alt="木庄网络博客"></a></h1>
            </div>
            <div class="collapse navbar-collapse" id="header-navbar">
                <form class="navbar-form visible-xs" action="/Search" method="post">
                    <div class="input-group">
                        <input type="text" name="keyword" class="form-control" placeholder="请输入关键字" maxlength="20"
                               autocomplete="off">
                        <span class="input-group-btn">
		<button class="btn btn-default btn-search" name="search" type="submit">搜索</button>
		</span></div>
                </form>
                <ul class="nav navbar-nav navbar-right">
                    <li><a data-cont="主页" title="主页" href="<%=request.getContextPath()%>/home.do">主页</a></li>
                    <li><a data-cont="技术分享页" title="技术分享页" href="<%=request.getContextPath()%>/showBlogList.do">技术分享</a>
                    </li>
                    <li><a data-cont="资讯头条页" title="资讯头条页" href="<%=request.getContextPath()%>/news.do">资讯头条</a></li>
                    &lt;%&ndash;<li><a data-cont="技术论坛页" title="技术论坛页" href="show.html">技术论坛</a></li>&ndash;%&gt;
                    <li><a data-cont="生活点滴页" title="生活点滴页" href="<%=request.getContextPath()%>/showLifeList.do">生活点滴</a></li>
                    <li><a data-cont="资源共享页" title="资源共享页" href="show.html">资源共享</a></li>
                    <li><a data-cont="留言板页" title="留言板页" href="show.html">留言板</a></li>
                    <li><a data-cont="关于我页" title="关于我页" href="show.html">关于我</a></li>
                </ul>
            </div>
        </div>
    </nav>
</header>--%>
<section class="container">
    <div class="content-wrap">
        <div class="content">
            <div class="title">
                <h3 style="line-height: 1.3">最新发布</h3>
            </div>
            <c:forEach var="blog" items="${blogList}">
                <article class="excerpt excerpt-1"><a class="focus" href="#" title="用DTcms做一个独立博客网站（响应式模板）"
                                                      target="_blank"><img
                        class="thumb" data-original="images/message_pic.jpg" src="images/message_pic.jpg"
                        alt="用DTcms做一个独立博客网站（响应式模板）" style="display: inline;"></a>
                    <header><a class="cat" href="#" title="MZ-NetBlog主题">${blog.blogLabel}<i></i></a>
                        <h2><a href="<%=request.getContextPath()%>/showBlogDetail.do?id=${blog.blogId}"
                               title="用DTcms做一个独立博客网站（响应式模板）" target="_blank">${blog.blogTitle}</a></h2>
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

            <%--  分页  --%>
            <c:if test="${totalPages > 1}">
                <div class="pagination" style="background: transparent">
                    <ul>
                        <li>
                            <a href="${pageContext.request.contextPath}/showLifeList.do?pagenum=1">首页</a>
                        </li>
                        <li class="prev-page"><a
                                href="${pageContext.request.contextPath}/showLifeList.do?pagenum=${nextPages - 1}">上一页</a>
                        </li>
                        <c:forEach var="pageIndex" begin="${startPage}" end="${endPage}">
                            <c:choose>
                                <c:when test="${pageIndex == nextPages}">
                                    <li class="active"><span> ${pageIndex} </span></li>
                                </c:when>
                                <c:otherwise>
                                    <li>
                                        <a href="${pageContext.request.contextPath}/showLifeList.do?pagenum=${pageIndex}">${pageIndex}</a>
                                    </li>
                                </c:otherwise>
                            </c:choose>
                        </c:forEach>

                        <c:if test="${nextPages != totalPages}">
                            <li class="next-page"><a
                                    href="${pageContext.request.contextPath}/showLifeList.do?pagenum=${nextPages+1}">下一页</a>
                            </li>
                        </c:if>
                        <li>
                            <a href="${pageContext.request.contextPath}/showLifeList.do?pagenum=${totalPages}">末页</a>
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
    <%--<aside class="sidebar">
        <div class="fixed">
            <div class="widget widget_search">
                <form class="navbar-form" action="/Search" method="post">
                    <div class="input-group">
                        <input type="text" name="keyword" class="form-control" size="35" placeholder="请输入关键字"
                               maxlength="15" autocomplete="off">
                        <span class="input-group-btn">
		<button class="btn btn-default btn-search" name="search" type="submit">搜索</button>
		</span></div>
                </form>
            </div>
            <div class="widget widget_sentence">
                <h3>标签云</h3>
                <div class="widget-sentence-content">
                    <ul class="plinks ptags">
                        <c:forEach var="label" items="${labelList}">
                            <li><a href="#" title="移动统计" draggable="false">${label} <span class="badge">1</span></a>
                            </li>
                        </c:forEach>

                        &lt;%&ndash;                    <li><a href="#list/67/" title="移动统计" draggable="false">移动统计 <span class="badge">1</span></a>
                                                </li>
                                                <li><a href="#list/256/" title="404" draggable="false">404 <span class="badge">1</span></a></li>
                                                <li><a href="#list/252/" title="VS2010" draggable="false">VS2010 <span
                                                        class="badge">1</span></a></li>
                                                <li><a href="#list/162/" title="杀毒软件" draggable="false">杀毒软件 <span class="badge">1</span></a>
                                                </li>
                                                <li><a href="#list/133/" title="html标签" draggable="false">html标签 <span
                                                        class="badge">1</span></a></li>
                                                <li><a href="#list/49/" title="循环" draggable="false">循环 <span class="badge">2</span></a></li>
                                                <li><a href="#list/22/" title="百度统计" draggable="false">百度统计 <span class="badge">2</span></a>
                                                </li>
                                                <li><a href="#list/132/" title="sql" draggable="false">sql <span class="badge">6</span></a></li>&ndash;%&gt;
                    </ul>
                </div>
            </div>
        </div>
        <div class="widget widget_hot">
            <h3>精选文章</h3>
            <ul>

                <li><a title="用DTcms做一个独立博客网站（响应式模板）" href="#"><span class="thumbnail">
<img class="thumb" data-original="images/201610181739277776.jpg" src="images/201610181739277776.jpg"
     alt="用DTcms做一个独立博客网站（响应式模板）" style="display: block;">
</span><span class="text">用DTcms做一个独立博客网站（响应式模板）</span><span class="muted"><i class="glyphicon glyphicon-time"></i>
2016-11-01
</span><span class="muted"><i class="glyphicon glyphicon-eye-open"></i>88</span></a></li>
                <li><a title="用DTcms做一个独立博客网站（响应式模板）" href="#"><span class="thumbnail">
<img class="thumb" data-original="images/201610181739277776.jpg" src="images/201610181739277776.jpg"
     alt="用DTcms做一个独立博客网站（响应式模板）" style="display: block;">
</span><span class="text">用DTcms做一个独立博客网站（响应式模板）</span><span class="muted"><i class="glyphicon glyphicon-time"></i>
2016-11-01
</span><span class="muted"><i class="glyphicon glyphicon-eye-open"></i>88</span></a></li>
                <li><a title="用DTcms做一个独立博客网站（响应式模板）" href="#"><span class="thumbnail">
<img class="thumb" data-original="images/201610181739277776.jpg" src="images/201610181739277776.jpg"
     alt="用DTcms做一个独立博客网站（响应式模板）" style="display: block;">
</span><span class="text">用DTcms做一个独立博客网站（响应式模板）</span><span class="muted"><i class="glyphicon glyphicon-time"></i>
2016-11-01
</span><span class="muted"><i class="glyphicon glyphicon-eye-open"></i>88</span></a></li>
                <li><a title="用DTcms做一个独立博客网站（响应式模板）" href="#"><span class="thumbnail">
<img class="thumb" data-original="images/201610181739277776.jpg" src="images/201610181739277776.jpg"
     alt="用DTcms做一个独立博客网站（响应式模板）" style="display: block;">
</span><span class="text">用DTcms做一个独立博客网站（响应式模板）</span><span class="muted"><i class="glyphicon glyphicon-time"></i>
2016-11-01
</span><span class="muted"><i class="glyphicon glyphicon-eye-open"></i>88</span></a></li>
                <li><a title="用DTcms做一个独立博客网站（响应式模板）" href="#"><span class="thumbnail">
<img class="thumb" data-original="images/201610181739277776.jpg" src="images/201610181739277776.jpg"
     alt="用DTcms做一个独立博客网站（响应式模板）" style="display: block;">
</span><span class="text">用DTcms做一个独立博客网站（响应式模板）</span><span class="muted"><i class="glyphicon glyphicon-time"></i>
2016-11-01
</span><span class="muted"><i class="glyphicon glyphicon-eye-open"></i>88</span></a></li>
                <li><a title="用DTcms做一个独立博客网站（响应式模板）" href="#"><span class="thumbnail">
<img class="thumb" data-original="images/201610181739277776.jpg" src="images/201610181739277776.jpg"
     alt="用DTcms做一个独立博客网站（响应式模板）" style="display: block;">
</span><span class="text">用DTcms做一个独立博客网站（响应式模板）</span><span class="muted"><i class="glyphicon glyphicon-time"></i>
2016-11-01
</span><span class="muted"><i class="glyphicon glyphicon-eye-open"></i>88</span></a></li>
                <li><a title="用DTcms做一个独立博客网站（响应式模板）" href="#"><span class="thumbnail">
<img class="thumb" data-original="images/201610181739277776.jpg" src="images/201610181739277776.jpg"
     alt="用DTcms做一个独立博客网站（响应式模板）" style="display: block;">
</span><span class="text">用DTcms做一个独立博客网站（响应式模板）</span><span class="muted"><i class="glyphicon glyphicon-time"></i>
2016-11-01
</span><span class="muted"><i class="glyphicon glyphicon-eye-open"></i>88</span></a></li>
                <li><a title="用DTcms做一个独立博客网站（响应式模板）" href="#"><span class="thumbnail">
<img class="thumb" data-original="images/201610181739277776.jpg" src="images/201610181739277776.jpg"
     alt="用DTcms做一个独立博客网站（响应式模板）" style="display: block;">
</span><span class="text">用DTcms做一个独立博客网站（响应式模板）</span><span class="muted"><i class="glyphicon glyphicon-time"></i>
2016-11-01
</span><span class="muted"><i class="glyphicon glyphicon-eye-open"></i>88</span></a></li>

            </ul>
        </div>
        <div class="widget widget_sentence">

            <a href="#" target="_blank" rel="nofollow" title="MZ-NetBlog主题">
                <img style="width: 100%" src="images/ad.jpg" alt="MZ-NetBlog主题"></a>

        </div>
        <div class="widget widget_sentence">

            <a href="#" target="_blank" rel="nofollow" title="专业网站建设">
                <img style="width: 100%" src="images/201610241224221511.jpg" alt="专业网站建设"></a>

        </div>
    </aside>--%>
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

