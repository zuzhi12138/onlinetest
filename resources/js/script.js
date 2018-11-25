
$(document).ready(function () {
    $(".nav a").click(function (e) {
        e.preventDefault(); //阻止默认事件，超链接的默认事件是点击超链接，打开链接到的页面或图片等
        $(".nav a").removeClass("active"); //删除所有a的active类
        $(this).addClass("active"); //为当前a的样式添加active类的样式
        $(".content div").fadeOut(100); //隐藏其他div
        $(".content " + $(this).attr("href")).fadeIn(300); //根据当前超链接的href属性获取要显示的div的id，并将其显示
    });
});
