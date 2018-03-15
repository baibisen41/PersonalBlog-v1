<%--
  Created by IntelliJ IDEA.
  User: 大森
  Date: 2018/1/6
  Time: 17:42
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false" %>
<script src="<%=request.getContextPath()%>/js/jquery-2.1.4.min.js"></script>

<aside class="sidebar">
    <div class="fixed">
        <div class="widget widget-tabs">
            <ul class="nav nav-tabs" role="tablist">
                <li role="presentation" class="active"><a href="#notice" aria-controls="notice" role="tab"
                                                          data-toggle="tab">今日天气</a></li>
                <li role="presentation"><a href="#contact" aria-controls="contact" role="tab"
                                           data-toggle="tab">统计信息</a></li>
            </ul>
            <div class="tab-content">
                <div role="tabpanel" class="tab-pane contact active" id="notice">
                    <h2>
                        <iframe name="weather_inc" src="http://i.tianqi.com/index.php?c=code&id=2&num=2" width="330"
                                height="70" frameborder="0" marginwidth="0" marginheight="0"
                                scrolling="no"></iframe>
                    </h2>
                    <%--<h2>网站运行:
                        <span id="sitetime">88天 </span></h2>--%>
                </div>
                <div role="tabpanel" class="tab-pane contact" id="contact">
                    <h2>QQ:
                        <a href="" target="_blank" rel="nofollow" data-toggle="tooltip" data-placement="bottom"
                           title="" data-original-title="QQ:"></a>
                    </h2>
                    <h2>Email:
                        <a href="#" target="_blank" data-toggle="tooltip" rel="nofollow" data-placement="bottom"
                           title="" data-original-title="#"></a></h2>
                </div>
            </div>
        </div>
        <div class="widget widget_search">
            <form class="navbar-form" action="/Search" method="post">
                <div class="input-group">
                    <input type="text" name="keyword" class="form-control" size="35" placeholder="请输入关键字"
                           maxlength="15" autocomplete="off">
                    <span class="input-group-btn">
		<button class="btn btn-default btn-search" name="search" type="submit">搜索</button>
		</span></div>
            </form>
        </div>
    </div>
    <div class="widget widget_hot">
        <h3>大家都在看</h3>
        <ul class="recommend">

        </ul>
    </div>

    <div class="widget widget_sentence">
        <h3>标签云</h3>
        <div class="widget-sentence-content">
            <ul class="plinks ptags">
                <%--<li><a href="#list/67/" title="移动统计" draggable="false">移动统计 <span class="badge">1</span></a></li>--%>
            </ul>
        </div>
    </div>

    <div class="widget widget_sentence">
        <h3>友情链接</h3>
        <div class="widget-sentence-link">
            <a href="#" title="网站建设" target="_blank">网站建设</a>&nbsp;&nbsp;&nbsp;
            <a href="show_editor_page.jsp">编辑页</a>&nbsp;&nbsp;&nbsp;
        </div>
    </div>
</aside>

<script>

    $.ajax({
        url: "<%=request.getContextPath()%>/testNews.do",
        type: "get",
        dataType: "json",
        success: function (data) {
            var html = "";
            for (var i = 0; i < data.data.length; i++) {
                html += "<li><a title=\"\" href=\"" + "<%=request.getContextPath()%>/showNewsDetail.do?type=1&id=" + data.data[i].newsId + "\" target=\"_blank\"><span class=\"thumbnail\">" +
                    "<img class=\"thumb\" src=\"images/message_pic.jpg\" alt=\"\" style=\"display: block;\">" +
                    "</span><span class=\"text\">" + data.data[i].newsTitle + "</span><span class=\"muted\"><i class=\"glyphicon glyphicon-time\"></i>" + data.data[i].newsTime + "</span>" +
                    "<span class=\"muted\"><i class=\"glyphicon glyphicon-eye-open\"></i>88</span></a></li>";
            }
//                alert("result:" + html);
//                $("#recommend").html(html);
            $(".recommend").append(html);
        }
        ,
        error: function (data) {

        }
    });

    $.ajax({
        url: "<%=request.getContextPath()%>/showTagList.do",
        type: "get",
        dataType: "json",
        success: function (data) {
            var html = "";
            for (var i = 0; i < data.tagMap.length; i++) {
                html += "<li><a href=\"" + "<%=request.getContextPath()%>/showBlogList.do\" title=\"移动统计\" draggable=\"false\">" + data.tagMap[i].label + "<span class=\"badge\">" + data.tagMap[i].count + "</span></a></li>";
            }
            $(".plinks").append(html);
        }
        ,
        error: function (data) {

        }
    });


</script>
