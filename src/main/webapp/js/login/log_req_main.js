$(document).ready(function(){
    $("#login_btn").click(function(){
        var userNameval = $("#log_username").val();
        var password = $("#log_password").val();
        console.log(userNameval);
        //alert(userNameval);
        var datas={
            "id":userNameval,
            "passw":password
        }
        var dataObj = {};//声明一个js对象
        $.ajax({
                type:"POST",
                url:"login_jg",
                data:"userinfo="+JSON.stringify(datas),
                dataType:"json",
                beforeSend:function(){
                    //alert("弹出加载动画");
                    
                },
                error:function(xmlHTTPreqeust,statusCode,exception){
                    //alert(xmlHTTPreqeust.status);
                    $("#log_id_tips").html("网络异常");
                },
                success:function(serverData){   //服务端返回200状态码时的回调函数
                    //alert(serverData);
                    console.log(serverData);
                    if(serverData["id"]=="-1"){
                        $("#log_id_tips").html("用户名或者密码错误");
                    }
                    else{
                        $("#log_id_tips").html("用户"+serverData["id"]+"登陆成功");
                      //  loginDialog.dialog('close');
                        window.location.href ='index.html';
                    }
                    }
                });
            });
            $("#register_btn").click(function(){
                var userNameval = $("#reg_username").val();
                var password = $("#reg_password").val();
                var email=$("#reg_email").val();
                console.log(userNameval+password+email);
                //alert(userNameval);
                var datas={
                    "id":userNameval,
                    "passw":password,
                    "email":email
                }
                var dataObj = {};//声明一个js对象
                $.ajax({
                        type:"POST",
                        url:"register",
                        data:"userRegInfo="+JSON.stringify(datas),
                        dataType:"json",
                        beforeSend:function(){
                            //alert("弹出加载动画");
                            
                        },
                        error:function(xmlHTTPreqeust,statusCode,exception){
                            //alert(xmlHTTPreqeust.status);
                            $("#reg_id_tips").html("网络异常");
                        },
                        success:function(serverData){   //服务端返回200状态码时的回调函数
                            //alert(serverData);
                            console.log(serverData);
                            if(serverData["id"]=="-1"){
                                $("#reg_id_tips").html("注册失败");
                            }
                            else{
                                $("#reg_id_tips").html("用户"+serverData["id"]+"注册成功");
                            }
                        }
                    });
                });
    });