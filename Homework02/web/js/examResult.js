/**
 * Created by Tonndiyee on 2016/12/19.
 */
var getResult = (function () {
    var item =
        "<tr>"+
            "<td></td>"+
            "<td></td>"+
        "</tr>";
    $.ajax({
        url: 'exam.result',
        async: false,
        type: 'post',
        success: function (data) {
            console.log(JSON.stringify(data))
        },
        error: function (data) {
            console.log(JSON.stringify(data));
            console.log("error");
        }
    });

});
getResult();