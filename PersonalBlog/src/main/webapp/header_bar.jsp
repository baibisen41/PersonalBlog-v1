<%--
  Created by IntelliJ IDEA.
  User: 大森
  Date: 2018/5/1
  Time: 14:43
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<header class="header">
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
                <h1 class="logo hvr-bounce-in"><a href="#" title="bbs"><img src="images/201610171329086541.png"
                                                                            alt="bbs"></a></h1>
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
                    <li><a data-cont="首页" title="首页" href="index.jsp">首页</a></li>
                    <li><a data-cont="技术随笔" title="技术随笔" href="pb_blog_page.jsp">技术随笔</a></li>
                    <li><a data-cont="生活随笔" title="生活随笔" href="pb_blog_detail_page.jsp">生活随笔</a></li>
                    <li><a data-cont="资讯头条" title="资讯头条" href="pb_blog_detail_page.jsp">资讯头条</a></li>
                    <li><a data-cont="资源分享" title="资源分享" href="#">资源分享</a></li>
                    <li><a data-cont="留言板" title="留言板" href="#">留言板</a></li>
                    <li><a data-cont="关于" title="关于" href="#">关于</a></li>
                    <li><a data-cont="404" title="404" href="404.jsp">404测试页面</a></li>
                </ul>
            </div>
        </div>
    </nav>
</header>
