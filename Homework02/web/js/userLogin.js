/**
 * Created by Tonndiyee on 2016/12/18.
 */
var doLogin = (function () {
    $.ajax({
        url: 'user.login',
        async: false,
        type: 'post',
        success: function (data) {
            if(data=="normal"){
                window.location.href = "exam.result";
            }
        },
        error: function (data) {
            console.log(JSON.stringify(data));
            console.log("error");
        }
    });
});