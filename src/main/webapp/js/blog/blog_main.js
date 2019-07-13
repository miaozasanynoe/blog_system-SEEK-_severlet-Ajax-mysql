$(document).ready(function(){
    console.log("start");
    $.ajax({
        type:"GET",
        url:"blog_user",
        dataType:"json",
        beforeSend:function(){
            //alert("弹出加载动画");
            
        },
        error:function(xmlHTTPreqeust,statusCode,exception){
            alert(xmlHTTPreqeust.status);
           // $("#log_id_tips").html("网络异常");
        },
        success:function(serverData){   //服务端返回200状态码时的回调函数ss
            $("#show_username").html(serverData["id"]);
            console.log(serverData); 
        }
    });
});