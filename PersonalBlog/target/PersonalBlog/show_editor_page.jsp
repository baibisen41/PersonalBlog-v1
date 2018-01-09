<%--
  Created by IntelliJ IDEA.
  User: 大森
  Date: 2018/1/9
  Time: 20:56
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>edit</title>
    <link rel="stylesheet" href="<%=request.getContextPath()%>/editor/css/editormd.css"/>

    <script src="<%=request.getContextPath()%>/js/jquery-2.1.4.min.js"></script>
    <script src="<%=request.getContextPath()%>/editor/editormd.min.js"></script>
</head>
<body>
<div align="center">
    <input id="editormd-title" name="editormd-title" type="text"/>
</div>
<br>
<div align="center">
    <input id="editormd-from" name="editormd-from" type="text"/>
</div>
<br>
<div id="my-editormd">
    <textarea id="my-editormd-markdown-doc" name="my-editormd-markdown-doc" style="display:none;"></textarea>
    <!-- 注意：name属性的值-->
    <%--
        <textarea id="my-editormd-html-code" name="my-editormd-html-code" style="display:none;"></textarea>
    --%>
</div>
<div align="center">
    <input id="editormd-btn" name="editormd-btn" type="button" value="提交" onclick="submitBlogEdit()"/>
</div>

<script type="text/javascript">
    $(function () {
        editormd("my-editormd", {//注意1：这里的就是上面的DIV的id属性值
            width: "90%",
            height: 640,
            syncScrolling: "single",
            path: "<%=request.getContextPath()%>/editor/lib/",//注意2：你的路径
            saveHTMLToTextarea: true//注意3：这个配置，方便post提交表单
        });
    });

    function submitBlogEdit() {
        var title = $("#editormd-title").val();
        var content = $("#my-editormd-markdown-doc").val();
        var fromId = $("#editormd-from").val();
        alert(content);

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

</script>
</body>
</html>
