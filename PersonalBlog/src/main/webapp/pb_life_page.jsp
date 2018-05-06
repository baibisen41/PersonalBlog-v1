<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isELIgnored="false" %>
<!doctype html>
<html lang="zh-CN">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <title>生活记录</title>
    <meta name="keywords" content="PersonalBlog">
    <meta name="description" content="baibisen personalBlog">
    <script src="static/js/jquery/jquery-2.1.4.min.js" type="text/javascript"></script>
    <script src="static/layui/layui.js" type="text/javascript"></script>
    <script src="static/js/index/index.js" type="text/javascript"></script>
    <script src="static/js/index/freezeheader.js" type="text/javascript"></script>
    <script src="static/layui/lay/modules/layer.js" type="text/javascript"></script>
    <script src="static/js/index/sliders.js" type="text/javascript"></script>
    <script src="static/js/index/html5.js" type="text/javascript"></script>
    <script src="static/js/index/article.js" type="text/javascript"></script>
    <link rel="stylesheet" href="static/layui/css/layui.css" media="all"/>
    <link rel="stylesheet" href="static/layui/css/modules/layer/default/layer.css"/>
    <link rel="stylesheet" href="static/css/global.css"/>
    <script type="text/javascript">

    </script>
</head>
<body>
<div class="layui-header header">
    <div class="main">
        <ul class="layui-nav layui-nav-left" lay-filter="filter">
            <a class="logo" href="index.html" title="Fly">Fly</a>
            <li class="layui-nav-item nav-left">
                <a href="index.jsp">首页</a>
            </li>
            <li class="layui-nav-item">
                <a href="pb_blog_page.jsp">技术随笔</a>
            </li>
            <li class="layui-nav-item layui-this">
                <a href="pb_life_page.jsp">生活记录</a>
            </li>
            <li class="layui-nav-item">
                <a href="pb_news_page.jsp">资讯头条</a>
            </li>
            <li class="layui-nav-item">
                <a href="pb_mall_page.jsp">资源商城</a>
            </li>
            <li class="layui-nav-item">
                <a href="pb_comment_page.jsp">留言板</a>
            </li>
            <li class="layui-nav-item">
                <a href="pb_about_page.jsp">关于</a>
            </li>
        </ul>
        <ul class="layui-nav layui-layout-right layui-nav-right" lay-filter="filter">

            <li class="layui-nav-item">
                <a href="pb_me_page.jsp">我的主页<span class="layui-badge-dot"></span></a>
            </li>
            <li class="layui-nav-item">
                <a href="javascript:;"><img src="<%=request.getContextPath()%>/static/images/head.jpg" class="layui-nav-img">我</a>
                <dl class="layui-nav-child">
                    <dd><a href="javascript:;">修改信息</a></dd>
                    <dd><a href="javascript:;">安全管理</a></dd>
                    <dd><a href="javascript:;">退了</a></dd>
                </dl>
            </li>
        </ul>
    </div>
</div>
<div class="layui-container container">

    <div class="layui-row layui-col-space20">
        <div class="layui-col-md8">
            <div>
              <span class="layui-breadcrumb">
          <a href="index.jsp">首页</a>
          <a><cite>生活记录</cite></a>
        </span>
                <hr class="layui-bg-red">
                <div class="article-list" style="padding-top:10px;">
                    <figure><img lay-src="<%=request.getContextPath()%>/static/images/01.jpg"></figure>
                    <ul>
                        <h3>
                            <a href="pb_blog_detail_page.jsp">住在手机里的朋友</a>
                        </h3>

                        <p>现在跨界联姻，时尚、汽车以及运动品牌联合手机制造商联合发布手机产品在行业里已经不再新鲜，上周我们给大家报道过著名手表制造商瑞士泰格·豪雅（Tag Heuer）
                            联合法国的手机制造商Modelabs发布的一款奢华手机的部分谍照，而近日该手机终于被正式发布了...</p>

                        <p class="autor">
                            <span class="lm f_l"><a href="#">个人博客</a></span>
                            <span class="dtime f_l">2014-02-19</span>
                            <span class="viewnum f_r">浏览（<a href="#">459</a>）</span>
                            <span class="pingl f_r">评论（<a href="#">30</a>）</span></p>
                    </ul>
                </div>

            </div>
            <!--分页-->
            <div id="page"></div>
        </div>
        <c:import url="pb_sider_bar.jsp"/>
    </div>
</div>
<c:import url="pb_footer_bar.jsp"/>
</body>
</html>