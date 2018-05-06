<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isELIgnored="false" %>
<div class="layui-col-md4">
    <form class="layui-form" method="post" action="pb_me_message_page.jsp">
        <div class="layui-form-item">
            <div class="layui-input-inline" style="width:76%;">
                <input type="text" name="title" lay-verify="required" placeholder="请输入关键字" class="layui-input">
            </div>
            <button class="layui-btn" lay-filter="*" lay-submit>搜索</button>
        </div>
    </form>
    <div class="ad"> <img lay-src="<%=request.getContextPath()%>/static/images/ad.jpg"> </div>
    <div class="ms-top">
        <ul class="hd" id="tab">
            <li class="cur"><a>点击排行</a></li>
            <li><a>最新文章</a></li>
            <li><a>站长推荐</a></li>
            <li><a>最新评论</a></li>
        </ul>
    </div>
    <div class="ms-main" id="ms-main">
        <div style="display: block;" class="bd bd-news" >
            <ul>
                <li><a href="#" target="_blank">住在手机里的朋友</a></li>
                <li><a href="#" target="_blank">教你怎样用欠费手机拨打电话</a></li>
                <li><a href="#" target="_blank">原来以为，一个人的勇敢是，删掉他的手机号码...</a></li>
                <li><a href="#" target="_blank">手机的16个惊人小秘密，据说99.999%的人都不知</a></li>
                <li><a href="#" target="_blank">豪雅手机正式发布! 在法国全手工打造的奢侈品</a></li>
                <li><a href="#" target="_blank">你面对的是生活而不是手机</a></li>
            </ul>
        </div>
        <div  class="bd bd-news">
            <ul>
                <li><a href="#" target="_blank">原来以为，一个人的勇敢是，删掉他的手机号码...</a></li>
                <li><a href="#" target="_blank">手机的16个惊人小秘密，据说99.999%的人都不知</a></li>
                <li><a href="#" target="_blank">住在手机里的朋友</a></li>
                <li><a href="#" target="_blank">教你怎样用欠费手机拨打电话</a></li>
                <li><a href="#" target="_blank">你面对的是生活而不是手机</a></li>
                <li><a href="#" target="_blank">豪雅手机正式发布! 在法国全手工打造的奢侈品</a></li>
            </ul>
        </div>
        <div class="bd bd-news">
            <ul>

                <li><a href="#" target="_blank">手机的16个惊人小秘密，据说99.999%的人都不知</a></li>
                <li><a href="#" target="_blank">你面对的是生活而不是手机</a></li>
                <li><a href="#" target="_blank">住在手机里的朋友</a></li>
                <li><a href="#" target="_blank">豪雅手机正式发布! 在法国全手工打造的奢侈品</a></li>
                <li><a href="#" target="_blank">教你怎样用欠费手机拨打电话</a></li>
                <li><a href="#" target="_blank">原来以为，一个人的勇敢是，删掉他的手机号码...</a></li>
            </ul>
        </div>
        <div  class="bd bd-news">
            <ul>
                <li><a href="#" target="_blank">原来以为，一个人的勇敢是，删掉他的手机号码...</a></li>
                <li><a href="#" target="_blank">手机的16个惊人小秘密，据说99.999%的人都不知</a></li>
                <li><a href="#" target="_blank">住在手机里的朋友</a></li>
                <li><a href="#" target="_blank">教你怎样用欠费手机拨打电话</a></li>
                <li><a href="#" target="_blank">你面对的是生活而不是手机</a></li>
                <li><a href="#" target="_blank">豪雅手机正式发布! 在法国全手工打造的奢侈品</a></li>
            </ul>
        </div>
    </div>
    <div class="cloud">
        <h3>标签云</h3>
        <ul>
            <li><a href="#">个人博客</a></li>
            <li><a href="#">web开发</a></li>
            <li><a href="#">前端设计</a></li>
            <li><a href="#">Html</a></li>
            <li><a href="#">CSS3</a></li>
            <li><a href="#">Html5+css3</a></li>
            <li><a href="#">百度</a></li>
            <li><a href="#">Javasript</a></li>
            <li><a href="#">web开发</a></li>
            <li><a href="#">前端设计</a></li>
            <li><a href="#">Html</a></li>
            <li><a href="#">CSS3</a></li>
            <li><a href="#">Html5+css3</a></li>
            <li><a href="#">百度</a></li>
        </ul>
    </div>
    <div class="tuwen">
        <h3>图文推荐</h3>
        <ul>
            <li><a href="#"><img src="<%=request.getContextPath()%>/static/images/01.jpg"><b>住在手机里的朋友</b></a>
                <p><span class="tulanmu"><a href="#">手机配件</a></span><span class="tutime">2015-02-15</span></p>
            </li>
            <li><a href="#"><img src="<%=request.getContextPath()%>/static/images/02.jpg"><b>教你怎样用欠费手机拨打电话</b></a>
                <p><span class="tulanmu"><a href="#">手机配件</a></span><span class="tutime">2015-02-15</span></p>
            </li>
            <li><a href="#"><img src="<%=request.getContextPath()%>/static/images/03.jpg"><b>手机的16个惊人小秘密，据说...</b></a>
                <p><span class="tulanmu"><a href="#">手机配件</a></span><span class="tutime">2015-02-15</span></p>
            </li>
            <li><a href="#"><img src="<%=request.getContextPath()%>/static/images/06.jpg"><b>住在手机里的朋友</b></a>
                <p><span class="tulanmu"><a href="#">手机配件</a></span><span class="tutime">2015-02-15</span></p>
            </li>
            <li><a href="#"><img src="<%=request.getContextPath()%>/static/images/04.jpg"><b>教你怎样用欠费手机拨打电话</b></a>
                <p><span class="tulanmu"><a href="#">手机配件</a></span><span class="tutime">2015-02-15</span></p>
            </li>
        </ul>
    </div>
    <div class="article-fenlei">
        <h3>文章分类</h3>
        <button class="layui-btn layui-btn-warm">个人博客</button>
        <button class="layui-btn layui-btn-primary">HTML</button>
        <button class="layui-btn layui-btn-danger">JAVA</button>
        <br/>
        <br/>
        <button class="layui-btn layui-btn-primary">javascript</button>
        <button class="layui-btn layui-btn-normal">SQL</button>
        <button class="layui-btn layui-btn-primary">其他</button>
    </div>
    <div class="links">
        <h3><span>[<a href="#">申请友情链接</a>]</span>友情链接</h3>
        <ul>
            <li><a href="#">web开发</a></li>
            <li><a href="#">前端设计</a></li>
            <li><a href="#">Html</a></li>
            <li><a href="#">CSS3</a></li>
            <li><a href="#">Html5+css3</a></li>
            <li><a href="#">百度</a></li>
        </ul>
    </div>
</div>