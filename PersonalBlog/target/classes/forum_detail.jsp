<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: 大森
  Date: 2017/9/10
  Time: 21:58
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false" %>
<html>
<head>
    <meta charset="utf-8">
    <title>控制台</title>
    <link rel="stylesheet" type="text/css" href="../Css/identify.css"/>
    <link rel="stylesheet" type="text/css" href="../Css/layout.css"/>
    <link rel="stylesheet" type="text/css" href="Css/account.css"/>
    <link rel="stylesheet" type="text/css" href="../Css/style.css"/>
    <link rel="stylesheet" type="text/css" href="../Css/control_index.css"/>
    <script type="text/javascript" src="../Js/jquery-1.7.2.min.js"></script>
    <script type="text/javascript" src="Js/layer/layer.js"></script>
    <script type="text/javascript" src="../Js/haidao.offcial.general.js"></script>
    <script type="text/javascript" src="../Js/select.js"></script>
    <script type="text/javascript" src="../Js/haidao.validate.js"></script>
    <script type="text/javascript" src="../Js/now.js"></script>
</head>

<body>
<div class="view-topbar">
    <div class="topbar-console">
        <div class="tobar-head fl">
            <a href="#" class="topbar-logo fl">
                <span><img src="../Images/logo.png" width="20" height="20"/></span>
            </a>
            <a href="index.html" class="topbar-home-link topbar-btn text-center fl"><span>管理控制台</span></a>
        </div>
    </div>
    <div class="topbar-info">
        <ul class="fr">
            <li class="fl dropdown topbar-notice topbar-btn">
                <a href="#" class="dropdown-toggle">
                    <span class="icon-notice"></span>
                    <span class="topbar-num have">0</span>
                    <!--have表示有消息，没有消息去掉have-->
                </a>
            </li>
            <!-- 					<li class="fl topbar-info-item strong">
            <div class="dropdown">
                <a href="#" class="dropdown-toggle topbar-btn">
                <span class="fl">工单服务</span>
                <span class="icon-arrow-down"></span>
                </a>
                <ul class="dropdown-menu">
                    <li><a href="#">我的工单</a></li>
                    <li><a href="#">提交工单</a></li>
                </ul>
            </div>
            </li>
             -->
            <li class="fl topbar-info-item">
                <div class="dropdown">
                    <a href="#" class="topbar-btn">
                        <span class="fl text-normal">操作与反馈</span>
                        <span class="icon-arrow-down"></span>
                    </a>
                    <ul class="dropdown-menu">
                        <li><a href="#">签到</a></li>
                        <li><a href="#">提问题</a></li>
                    </ul>
                </div>
            </li>
            <li class="fl topbar-info-item">
                <div class="dropdown">
                    <a href="#" class="topbar-btn">
                        <span class="fl text-normal">小朱</span>
                        <span class="icon-arrow-down"></span>
                    </a>
                    <ul class="dropdown-menu">
                        <li><a href="login.html">退出</a></li>
                    </ul>
                </div>
            </li>
        </ul>
    </div>
</div>
<div class="view-body">
    <div class="view-sidebar">
        <div class="sidebar-content">
            <div class="sidebar-nav">
                <div class="sidebar-title">
                    <a href="#">
                        <span class="icon"><b class="fl icon-arrow-down"></b></span>
                        <span class="text-normal">技术交流</span>
                    </a>
                </div>
                <ul class="sidebar-trans">
                    <li>
                        <a href="javascript:void(0)" onclick="sideOnClick(1)">
                            <b class="sidebar-icon"><img src="../Images/icon_author.png" width="16" height="16"/></b>
                            <span class="text-normal">用户信息</span>
                        </a>
                    </li>
                    <li>
                        <a href="javascript:void(0)" onclick="sideOnClick(2)">
                            <b class="sidebar-icon"><img src="../Images/icon_message.png" width="16" height="16"/></b>
                            <span class="text-normal">技术论坛</span>
                        </a>
                    </li>
                    <!-- <li>
                        <a href="#">
                            <b class="sidebar-icon"><img src="Images/icon_market.png" width="16" height="16" /></b>
                            <span class="text-normal">云市场</span>
                        </a>
                    </li> -->
                </ul>
            </div>
            <div class="sidebar-nav">
                <div class="sidebar-title">
                    <a href="#">
                        <span class="icon"><b class="fl icon-arrow-down"></b></span>
                        <span class="text-normal">管理中心</span>
                    </a>
                </div>
                <ul class="sidebar-trans">
                    <li>
                        <a href="javascript:void(0)" onclick="sideOnClick(3)">
                            <b class="sidebar-icon"><img src="../Images/icon_cost.png" width="16" height="16"/></b>
                            <span class="text-normal">任务管理</span>
                        </a>
                    </li>
                    <li>
                        <a href="javascript:void(0)" onclick="sideOnClick(4)">
                            <b class="sidebar-icon"><img src="../Images/icon_authentication.png" width="16"
                                                         height="16"/></b>
                            <span class="text-normal">图书管理</span>
                        </a>
                    </li>
                    <li>
                        <a href="javascript:void(0)" onclick="sideOnClick(5)">
                            <b class="sidebar-icon"><img src="../Images/icon_news.png" width="16" height="16"/></b>
                            <span class="text-normal">云平台</span>
                        </a>
                    </li>
                    <li>
                        <a href="javascript:void(0)" onclick="sideOnClick(6)">
                            <b class="sidebar-icon"><img src="../Images/icon_gold.png" width="16" height="16"/></b>
                            <span class="text-normal">失物招领</span>
                        </a>
                    </li>
                    <li>
                        <a href="javascript:void(0)" onclick="sideOnClick(7)">
                            <b class="sidebar-icon"><img src="../Images/icon_order.png" width="16" height="16"/></b>
                            <span class="text-normal">问题反馈</span>
                        </a>
                    </li>
                </ul>
            </div>
        </div>
    </div>
    <div class="view-product">
        <div class="info-center">
            <div class="manage-head">
                <h6 class=" padding-left manage-head-con ">技术论坛</h6>
            </div>
            <div class="info-center-con">
                <div class=" info-center-title h5 margin-big-top clearfix">
                    <span class="fl padding-large-right manage-title">问题详情</span>
                    <%--                    <span class="fl padding-large-right"><a href="#">已读消息(0)</a></span>
                                        <span class="fl"><a href="#">未读消息(0)</a></span>--%>
                </div>
                <p style="width: 56px; left: 20px;" class="solid-slider">
                </p>
            </div>
            <div class="offcial-table input-table table-margin clearfix">
                <div class="tr-th clearfix">
                    <div class="th layout text-left">
                        ${userName}于${forumTime}提问
                    </div>
                </div>
                <div class="tr clearfix border-bottom-none">
                    <div class="td layout text-left">
                        ${forumContent}
                    </div>
                </div>
                <div class="tr clearfix border-bottom-none">
                    <div class="td layout text-left">
                        哈哈哈哈</br>
                        哈哈哈哈</br>
                        哈哈哈哈</br>
                        哈哈哈哈</br>
                    </div>
                </div>
            </div>

            <c:forEach var="forum" items="${forumDetailList}">
                <div class="offcial-table input-table table-margin clearfix">
                    <div class="tr clearfix">
                        <div class="td layout text-left">
                                ${forum.replyusername}于${forum.replytime}回答
                        </div>
                    </div>
                    <div class="tr clearfix border-bottom-none">
                        <div class="td layout text-left">
                                ${forum.replycontent}
                        </div>
                    </div>
                </div>
            </c:forEach>

            <div class="table-margin">
                <textarea name="submit_reply" id="submit_reply" class="layout" rows="10"></textarea>
            </div>
            <div class="table-margin" style="float:right">
                <input name="submit_reply_button" type="button" value="我的回答"
                       class="submit text-big " onclick="submitReply('${forumId}')"/>
            </div>
        </div>

        <div class="show-page padding-top-0 layout hidden">
            <ul class="tr-float">
            </ul>
        </div>
    </div>
</div>

<script type="text/javascript">
    $(".sidebar-title").live('click', function () {
        if ($(this).parent(".sidebar-nav").hasClass("sidebar-nav-fold")) {
            $(this).next().slideDown(200);
            $(this).parent(".sidebar-nav").removeClass("sidebar-nav-fold");
        } else {
            $(this).next().slideUp(200);
            $(this).parent(".sidebar-nav").addClass("sidebar-nav-fold");
        }
    });

    /*我的回帖*/
    function submitReply(id) {
        var message = $("#submit_reply").val();

        $.ajax({
            url: "sendReplyMessage.do",
            type: "POST",
            data: {"replyContent": message, "replyforumid": id},
            dataType: "json",
            success: function (data) {
                window.location.href = data.forum_view + "?forum_detail_id=" + data.forum_id;
                alert("回复成功")
            },
            error: function (data) {
                alert("error:" + data.forum_id);
            }
        });
    }

</script>
</body>

</html>
