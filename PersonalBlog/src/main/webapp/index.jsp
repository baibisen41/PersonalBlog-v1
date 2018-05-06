<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isELIgnored="false" %>
<!doctype html>
<html lang="zh-CN">
<head>
  <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
  <title>首页</title>
  <meta name="keywords" content="PersonalBlog">
  <meta name="description" content="baibisen personalBlog">
  <script src="static/js/jquery/jquery-2.1.4.min.js" type="text/javascript"></script>
  <script src="static/layui/layui.js" type="text/javascript"></script>
  <script src="static/js/index/index.js" type="text/javascript"></script>
  <script src="static/js/index/freezeheader.js" type="text/javascript"></script>
  <script src="static/layui/lay/modules/layer.js" type="text/javascript"></script>
  <script src="static/js/index/sliders.js" type="text/javascript"></script>
  <script src="static/js/index/html5.js" type="text/javascript"></script>
  <link rel="stylesheet" href="static/layui/css/layui.css" media="all"/>
  <link rel="stylesheet" href="static/layui/css/modules/layer/default/layer.css"/>
  <link rel="stylesheet" href="static/css/global.css"/>
  <script type="text/javascript">
      $(function () {
          var oLi = document.getElementById("tab").getElementsByTagName("li");
          var oUl = document.getElementById("ms-main").getElementsByTagName("div");
          for (var i = 0; i < oLi.length; i++) {
              oLi[i].index = i;
              oLi[i].onmouseover = function () {
                  for (var n = 0; n < oLi.length; n++) oLi[n].className = "";
                  this.className = "cur";
                  for (var n = 0; n < oUl.length; n++) oUl[n].style.display = "none";
                  oUl[this.index].style.display = "block"
              }
          }
      });
  </script>

</head>
<body>
<div class="layui-header header">
  <div class="main">
    <ul class="layui-nav layui-nav-left" lay-filter="filter">
      <a class="logo" href="index.html" title="Fly">Fly</a>
      <li class="layui-nav-item layui-this nav-left">
        <a href="index.jsp">首页</a>
      </li>
      <li class="layui-nav-item">
        <a href="pb_blog_page.jsp">技术随笔</a>
      </li>
      <li class="layui-nav-item">
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
          <dd><a href="pb_blog_edit_page.jsp">文章发布</a></dd>
          <dd><a href="pb_me_setting_page.jsp">修改信息</a></dd>
          <dd><a href="javascript:;">退了</a></dd>
        </dl>
      </li>
    </ul>
  </div>
</div>
<%--内容--%>
<div class="layui-container container">
  <div class="layui-row layui-col-space20">
    <div class="layui-col-md8">
      <div class="carousel">
        <div class="layui-carousel" id="images-carousel">
          <div carousel-item>
            <div>
              <a href="pb_blog_detail_page.jsp"><img lay-src="<%=request.getContextPath()%>/static/images/1.jpeg" width="100%" height="280px;" /></a>
            </div>
            <div>
              <img lay-src="<%=request.getContextPath()%>/static/images/2.jpeg" width="100%" height="280px;" />
            </div>
            <div>
              <img lay-src="<%=request.getContextPath()%>/static/images/3.jpg" width="100%" height="280px;" />
            </div>
            <div>
              <img lay-src="<%=request.getContextPath()%>/static/images/4.jpg" width="100%" height="280px;" />
            </div>
            <div>
              <img lay-src="<%=request.getContextPath()%>/static/images/5.jpg" width="100%" height="280px;" />
            </div>
          </div>
        </div>
      </div>
      <div class="article-main">
        <h2>最新文章</h2>
        <div class="article-list">
          <figure><img lay-src="<%=request.getContextPath()%>/static/images/05.jpg"></figure>
          <ul>
            <h3>
              <a href="pb_blog_detail_page.jsp">住在手机里的朋友</a>
            </h3>
            <p>通信时代，无论是初次相见还是老友重逢，交换联系方式，常常是
              彼此交换名片，然后郑重或是出于礼貌用手机记的过客，
              通信时代，无论是初次相见还是老友重逢，交换联系方式，常常是彼此交换名片，然后
              郑重或是出于礼貌用手机记的过客，这种快餐式的通信时代，无论是初次相见还是老友
              重逢，通信时代，无论是初次相见还是老友重种快餐式的这种快餐式的友谊 ...</p>
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
