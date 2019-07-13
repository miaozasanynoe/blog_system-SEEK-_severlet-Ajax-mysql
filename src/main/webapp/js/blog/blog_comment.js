var datas={
    "arcid":GetQueryString("arcid"),
}
console.log(datas);
var dataObj = {};//声明一个js对象
$.ajax({
        type:"POST",
        url:"article_comment_Servlet",
        data:"articlecommentInfo="+JSON.stringify(datas),
        dataType:"json",
        beforeSend:function(){
            //alert("弹出加载动画");
            
        },
        error:function(xmlHTTPreqeust,statusCode,exception){
            alert(xmlHTTPreqeust.status);
           // $("#log_id_tips").html("网络异常");
        },
        success:function(serverData){   //服务端返回200状态码时的回调函数
            //alert(serverData);
            console.log(serverData);
            
        }
    });