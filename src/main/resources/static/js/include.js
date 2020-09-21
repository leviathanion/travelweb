$(function () {
    $.get("/header","",function (data) {
        $("#header").html(data);
    });
    $.get("/footer",function (data) {
        $("#footer").html(data);
    })
});