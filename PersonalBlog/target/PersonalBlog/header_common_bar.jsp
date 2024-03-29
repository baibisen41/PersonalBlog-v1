<%--
  Created by IntelliJ IDEA.
  User: 大森
  Date: 2018/1/6
  Time: 17:42
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false" %>
<script src="<%=request.getContextPath()%>/js/jquery-2.1.4.min.js"></script>

<header class="header">
    <nav class="navbar navbar-default" id="navbar">
        <div class="container">
            <div class="header-topbar hidden-xs link-border">
                <%--                <ul class="site-nav topmenu">
                                    <li><a href="#">标签云</a></li>
                                    <li><a href="#" rel="nofollow">读者墙</a></li>
                                    <li><a href="#" title="">
                                        <i class="fa fa-rss">
                                        </i> RSS订阅
                                    </a></li>
                                </ul>--%>
                （一只不甘平庸的程序猿）
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
                <%-- 改bootstrap.min.css中（.navbar-default .navbar-nav > li > a）中的字体颜色 --%>
                <ul class="nav navbar-nav navbar-right">
                    <li><a data-cont="主页" title="主页"
                           href="<%=request.getContextPath()%>/home.do">主页</a></li>
                    <li><a data-cont="技术之路" title="技术之路"
                           href="<%=request.getContextPath()%>/showBlogList.do">技术之路</a>
                    </li>
                    <li><a data-cont="生活感悟" title="生活感悟"
                           href="<%=request.getContextPath()%>/showLifeList.do">生活感悟</a>
                    </li>
                    <li><a data-cont="资讯头条" title="资讯头条"
                           href="<%=request.getContextPath()%>/news.do">资讯头条</a>
                    </li>
                    <li><a data-cont="资源共享" title="资源共享"
                           href="<%=request.getContextPath()%>/show_source_page.jsp">资源共享</a>
                    </li>
                    <li><a data-cont="关于我页" title="关于我页"
                           href="<%=request.getContextPath()%>/show_about_page.jsp">关于我</a>
                    </li>
                    <li><a data-cont="留言板页" title="留言板页"
                           href="<%=request.getContextPath()%>/show_comment_page.jsp">留言板</a>
                    </li>
                </ul>
            </div>
        </div>
    </nav>
</header>
