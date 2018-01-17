<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: 大森
  Date: 2018/1/13
  Time: 20:45
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false" %>
<html>
<head>
    <meta charset="utf-8">
    <meta name="renderer" content="webkit">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>show</title>
    <meta name="keywords" content="">
    <meta name="description" content="">

    <link href="css/moban/style.css" rel="stylesheet" type="text/css" media="all"/>

    <link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/css/bootstrap.min.css">
    <link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/css/nprogress.css">
    <link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/css/style.css">
    <link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/css/font-awesome.min.css">
    <link rel="apple-touch-icon-precomposed" href="<%=request.getContextPath()%>/images/icon.png">
    <link rel="shortcut icon" href="<%=request.getContextPath()%>/images/favicon.ico">
    <script src="<%=request.getContextPath()%>/js/jquery-2.1.4.min.js"></script>
    <script src="<%=request.getContextPath()%>/js/nprogress.js"></script>
    <script src="<%=request.getContextPath()%>/js/jquery.lazyload.min.js"></script>
    <%-- editor.md  start --%>
    <script src="<%=request.getContextPath()%>/editor/lib/marked.min.js"></script>
    <script src="<%=request.getContextPath()%>/editor/lib/prettify.min.js"></script>
    <script src="<%=request.getContextPath()%>/editor/lib/raphael.min.js"></script>
    <script src="<%=request.getContextPath()%>/editor/lib/underscore.min.js"></script>
    <script src="<%=request.getContextPath()%>/editor/lib/sequence-diagram.min.js"></script>
    <script src="<%=request.getContextPath()%>/editor/lib/flowchart.min.js"></script>
    <script src="<%=request.getContextPath()%>/editor/lib/jquery.flowchart.min.js"></script>
    <script src="<%=request.getContextPath()%>/editor/editormd.min.js"></script>
    <script type="text/javascript">
        $(function () {
            editormd.markdownToHTML("doc-content", {
                htmlDecode: "style,script,iframe",  // you can filter tags decode
                emoji: true,
                taskList: true,
                tex: true  // 默认不解析
            });
        });
    </script>
    <%-- end --%>
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
<body>
<%@include file="header_common_bar.jsp" %>
<!-- main -->
<section class="container">
    <div class="article-content">
        <div class="main-info w3l">
            <div class="main-row"><!-- main-row-one -->
                <div class="profile-grid logo wthree">
                    <img src="images/temp_header.jpg" alt="">
                    <h2>白碧森的博客 </h2>
                </div>
                <br>
                <h3 class="title">关于我</h3>
                <div class="profile-grid">
                    <p>我叫白碧森，一个铁杆的小牛队球迷，</p>
                    <p>这是我的第一个站点，记录一下学习，生活，以及</p>
                    <P>感悟，</P>
                    <p>后续会对该站进行更新维护，大家有什么好的建议</p>
                    <p>或想法请联系我，</p>
                    <p>如果有好的原创文章想投稿也积极联系我哈。</p>
                </div>
                <br>
                <h3 class="title">关于本站</h3>

                <h3 class="title">联系方式</h3>
                <%--<div class="col-md-6 skills-right bar_group">

                    <div class='bar_group__bar thin' label='Lorem ipsum &nbsp;&nbsp; 80%' value='200'></div>
                    <div class='bar_group__bar thin' label='Quis nostrud &nbsp;&nbsp; 100%' value='250'></div>
                    <div class='bar_group__bar thin' label='Sed do eiusmod &nbsp;&nbsp; 72%' value='180'></div>
                    <div class='bar_group__bar thin' label='Ut enim adnim &nbsp;&nbsp; 88%' value='220'></div>
                </div>
                <!--bar-js-->
                <script src="js/moban/bars.js"></script>
                <div class="social-icons agileits">
                    <ul>
                        <li><a href="#"></a></li>
                        <li><a href="#" class="fb"></a></li>
                        <li><a href="#" class="be"></a></li>
                        <li><a href="#" class="gg"></a></li>
                    </ul>
                </div>--%>
                <div class="clear"></div>
            </div>
        </div>
    </div>
</section>
</body>
</html>
