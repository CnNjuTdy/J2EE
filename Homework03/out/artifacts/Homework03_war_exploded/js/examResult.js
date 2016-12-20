/**
 * Created by Tonndiyee on 2016/12/19.
 */
/**
 * Created by Tonndiyee on 2016/12/18.
 */
var getResult = (function () {
    $.ajax({
        url: 'exam.result',
        async: false,
        type: 'post',
        dataType:"json",
        success: function (data) {
            $("#username").html(data.username);
            if(data.examState=="abnormal"){
                $("#danger").html("您有课程未参加测验或测验结果不及格！");
                $("#resultTable").removeClass("panel-success");
                $("#resultTable").addClass("panel-danger");
            }
            var result = $("#result");
            var list = data.examResult;
            for(var i=0;i<list.length;i++) {
                var item = "<tr id='exam"+(i+1)+"'>" +
                                "<td class='examName'></td>" +
                                "<td class='examMark'></td>" +
                                "<td class='q1Mark'></td>" +
                                "<td class='q2Mark'></td>" +
                                "<td class='q3Mark'></td>" +
                            "</tr>";
                result.append(item);
                $("#exam"+(i+1)).find(".examName").html(list[i].examName);
                if(list[i].examMark==-3){
                    $("#exam"+(i+1)).addClass("text-danger");
                    $("#exam"+(i+1)).find(".examMark").html("未参加");
                    $("#exam"+(i+1)).find(".q1Mark").html("无分数");
                    $("#exam"+(i+1)).find(".q2Mark").html("无分数");
                    $("#exam"+(i+1)).find(".q3Mark").html("无分数");
                    continue ;
                }
                else if(list[i].examMark<60){
                    $("#exam"+(i+1)).addClass("text-warning");
                }
                $("#exam"+(i+1)).find(".examMark").html(list[i].examMark);
                $("#exam"+(i+1)).find(".q1Mark").html(list[i].q1Mark);
                $("#exam"+(i+1)).find(".q2Mark").html(list[i].q2Mark);
                $("#exam"+(i+1)).find(".q3Mark").html(list[i].q3Mark);
            }
        },
        error: function (data) {
            console.log(JSON.stringify(data));
            console.log("error");
        }
    });
});
getResult();