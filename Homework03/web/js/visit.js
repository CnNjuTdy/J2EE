/**
 * Created by Tonndiyee on 2016/12/21.
 */
function getVisitorResult() {
    $.ajax({
        url: 'user.visit',
        async: false,
        type: 'post',
        dataType:"json",
        success: function (data) {
            $("#online").html(data.online);
            $("#offline").html(data.offline);
            $("#id").html(data.visitorId);
            console.log(JSON.stringify(data))
        },
        error: function (data) {
            console.log(JSON.stringify(data));
            console.log("error");
        }
    });
}
getVisitorResult()