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
    <title>编辑界面</title>
    <script type="text/javascript" src="../Js/jquery-1.7.2.min.js"></script>
</head>
<body>
<input name="blog_title_text" id="blog_title_button" type="text"/><br><br>

<input name="blog_label_button" id="blog_label_button" type="button" onclick="sendCmd()" value="博客列表"/><br><br>
<input name="blog_label_hidden" id="blog_label_hidden" type="hidden" value="Java"/>

<textarea name="blog_content_text" id="blog_content_text" cols="30" rows="10"/><br><br>

<input name="blog_send_button" id="blog_send_button" type="button" onclick="sendCmd()" value="发送"/>
<input name="blog_temp_button" id="blog_temp_button" type="button" onclick="sendCmd()" value="草稿"/>
<input name="blog_cancel_button" id="blog_cancel_button" type="button" onclick="sendCmd()" value="取消"/>
</body>

<script type="text/javascript">
    function sendCmd() {
        $.ajax({
                url: "",
                type: "",
                data: "",
                dataType: "",
                success: function () {

                },
                error: function () {

                }
            }
        )
        ;
    }
</script>

</html>
