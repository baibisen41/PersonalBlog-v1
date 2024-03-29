<%--
  Created by IntelliJ IDEA.
  User: 大森
  Date: 2017/11/6
  Time: 22:34
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false" %>
<html>
<head>
    <meta charset="utf-8">
    <title>编辑界面</title>
    <script src="js/jquery-2.1.4.min.js"></script>
    <script src="js/nprogress.js"></script>
    <script src="js/jquery.lazyload.min.js"></script>

    <script src="js/jquery-1.11.1.min.js" type="text/javascript"></script>
    <script src="js/html5shiv.min.js" type="text/javascript"></script>
    <script src="js/respond.min.js" type="text/javascript"></script>
    <script src="js/selectivizr-min.js" type="text/javascript"></script>
</head>
<body>
<input name="blog_title_text" id="blog_title_text" type="text"/><br><br>

<input name="blog_label_button" id="blog_label_button" type="button" value="java"/><br><br>
<input name="blog_label_hidden" id="blog_label_hidden" type="hidden" value="Java"/>

<textarea name="blog_content_text" id="blog_content_text" rows="10" cols="20"></textarea><br><br>

<input name="blog_from_id" id="blog_from_id" type="text"/><br><br>

<input name="blog_send_button" id="blog_send_button" type="button" onclick="submitBlogEdit()" value="提交"/>
<input name="blog_temp_button" id="blog_temp_button" type="button" onclick="submitTempEdit()" value="草稿"/>
<input name="blog_cancel_button" id="blog_cancel_button" type="button" onclick="exitEdit()" value="取消"/>

<script type="text/javascript">

    function submitBlogEdit() {
        var title = $("#blog_title_text").val();
        var content = $("#blog_content_text").val();
        var fromId = $("#blog_from_id").val();

        $.ajax({
            url: "editBlogDetails.do?status=1",
            type: "post",
            dataType: "json",
            data: {
                "blog_title_text": title,
                "blog_label_hidden": "java",
                "blog_content_text": content,
                "blog_from_id": fromId
            },
            async: true,
            success: function (data) {
                alert("ok" + data.respStatus);
                window.location.href = data.resultView;
            },
            error: function (data) {
                alert("error");
            }
        });
    }

    function submitTempEdit() {
        var title = $("#blog_title_text").val();
        var content = $("#blog_content_text").val();
        var fromId = $("#blog_from_id").val();

        $.ajax({
            url: "editBlogDetails.do?status=2",
            type: "post",
            dataType: "json",
            data: {
                "blog_title_text": title,
                "blog_label_hidden": "java",
                "blog_content_text": content,
                "blog_from_id": fromId
            },
            async: true,
            success: function (data) {
                alert("ok" + data.respStatus);
                window.location.href = data.resultView;
            },
            error: function () {
                alert("error");
            }
        });
    }

    function exitEdit() {
        window.location.href = "<%=request.getContextPath()%>/showBlogList.do";
    }
</script>

</body>
</html>
