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
            window.location.href = "user.log";
        },
        error: function (data) {
            console.log(JSON.stringify(data));
            console.log("error");
        }
    });
}
function doVisitIn() {
    $.ajax({
        url: 'user.log',
        async: false,
        data: {type: "visitIn"},
        type: 'post',
        success: function (data) {
            window.location.href = "user.visit";
        },
        error: function (data) {
            console.log(JSON.stringify(data));
            console.log("error");
        }
    });
}
function doVisitOut() {
    $.ajax({
        url: 'user.log',
        async: false,
        data: {type: "visitOut"},
        type: 'post',
        success: function (data) {
            window.location.href = "user.log";
        },
        error: function (data) {
            console.log(JSON.stringify(data));
            console.log("error");
        }
    });
}
function logExit(){
    if(event.clientX>document.body.clientWidth && event.clientY < 0 || event.altKey){
        $.ajax({
            url: 'user.log',
            async: false,
            data: {type: "logout"},
            type: 'post',
            success: function (data) {
            },
            error: function (data) {
                console.log(JSON.stringify(data));
                console.log("error");
            }
        });
    }else{
    }
}
function visitExit(){
    if(event.clientX>document.body.clientWidth && event.clientY < 0 || event.altKey){
        $.ajax({
            url: 'user.log',
            async: false,
            data: {type: "visitOut"},
            type: 'post',
            success: function (data) {
            },
            error: function (data) {
                console.log(JSON.stringify(data));
                console.log("error");
            }
        });
    }else{
    }
}