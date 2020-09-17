$(function () {
    $.get("/header","",function (data) {
        $("#header").html(data);
    });
    // $.get("footer.html",function (data) {
    //     $("#footer").html(data);
    // })
});