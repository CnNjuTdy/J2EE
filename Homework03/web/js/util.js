/**
 * Created by Tonndiyee on 2016/12/20.
 */
function doLogin() {
    var username = $("input[id=username]").val();
    var password = $("input[id=password]").val();
    $.ajax({
        url: 'user.log',
        async: false,
        data: {type: "login", username: username, password: password},
        type: 'post',
        success: function (data) {
            if (data == "loginRight") {
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
}
function doLogout() {
    $.ajax({
        url: 'user.log',
        async: false,
        data: {type: "logout"},
        type: 'post',
        success: function (data) {
            window.location.href = "user.login";
        },
        error: function (data) {
            console.log(JSON.stringify(data));
            console.log("error");
        }
    });
}