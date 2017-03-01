/**
 * Created by Tonndiyee on 2016/12/20.
 */
function doLogin() {
    var username = $("input[id=username]").val();
    var password = $("input[id=password]").val();
    $.ajax({
        url: 'login.do',
        async: false,
        data: {type: "login", username: username, password: password},
        type: 'post',
        success: function (data) {
            if(data == "error"){
                window.location.href = "error.do";
            }else {
                window.location.href = "exam.do";
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
        url: 'login.do',
        async: false,
        data: {type: "logout"},
        type: 'post',
        success: function (data) {
            window.location.href = "login.do";
        },
        error: function (data) {
            console.log(JSON.stringify(data));
            console.log("error");
        }
    });
}
function doVisitIn() {
    $.ajax({
        url: 'login.do',
        async: false,
        data: {type: "visitIn"},
        type: 'post',
        success: function (data) {
            window.location.href = "visit.do";
        },
        error: function (data) {
            console.log(JSON.stringify(data));
            console.log("error");
        }
    });
}
function doVisitOut() {
    $.ajax({
        url: 'login.do',
        async: false,
        data: {type: "visitOut"},
        type: 'post',
        success: function (data) {
            window.location.href = "login.do";
        },
        error: function (data) {
            console.log(JSON.stringify(data));
            console.log("error");
        }
    });
}