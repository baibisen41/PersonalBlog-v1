<%--
  Created by IntelliJ IDEA.
  User: 大森
  Date: 2018/1/17
  Time: 20:17
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <meta name="referrer" content="no-referrer"/>
    <script type="text/javascript" src="swfobject.js"></script>
    <script type="text/javascript">
        swfobject.registerObject("myId", "9.0.0", "expressInstall.swf");
    </script>
</head>
<body>
<object id="myId" classid="clsid:D27CDB6E-AE6D-11cf-96B8-444553540000" width="300" height="120">
    <param name="movie" value="test.swf" />
    <!--[if !IE]>-->
    <object type="application/x-shockwave-flash" data="test.swf" width="300" height="120">
        <!--<![endif]-->
        <div>
            <h1>Alternative content</h1>
            <p><a href="http://www.adobe.com/go/getflashplayer"><img src="http://www.5imoban.net/uploads/allimg/140107/10030641b-0.gif" alt="Get Adobe Flash player" /></a></p>
        </div>
        <!--[if !IE]>-->
    </object>
    <!--<![endif]-->
</object>
</body>
</html>
