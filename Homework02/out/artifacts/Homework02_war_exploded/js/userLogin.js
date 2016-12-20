/**
 * Created by Tonndiyee on 2016/12/18.
 */
var doLogin = (function () {
    var username = $("input[id=username]").val();
    var password = $("input[id=password]").val();
    $.ajax({
        url: 'user.login',
        async: false,
        data: {username: username,password:password},
        type: 'post',
        success: function (data) {
            if(data=="loginRight"){
                window.location.href = "exam.result";
            }
            else {
                window.location.href = "error.user";
            }
        },
        error: function (data) {
            console.log(JSON.stringify(data));
            console.log("error");
        }
    });
});