/**
 * Created by 大森 on 2017/10/17.
 */
//侧边栏点击事件
function sideOnClick(msg) {
    $.ajax({
        url: "http://localhost:8080/SchoolServer/common/redirectUrlHandler.do",
        type: "POST",
        data: {"msg": msg},
        dataType: "json",
        success: function (data) {
            window.location.href = data.url;
        },
        error: function (data) {
            alert("error");
        }
    });
}