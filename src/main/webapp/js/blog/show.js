$(document).ready(function(){
    var userNameval=""
    console.log("asas")
	    $.ajax({
	        type:"GET",
	        url:"blog_user",
	        dataType:"json",
	        beforeSend:function(){
	           // alert("弹出加载动画");
	            
	        },
	        error:function(xmlHTTPreqeust,statusCode,exception){
	            alert(xmlHTTPreqeust.status);
	           // $("#log_id_tips").html("网络异常");
	        },
	        success:function(serverData){   //服务端返回200状态码时的回调函数ss
				//$("#show_username").html(serverData["id"]);
                userNameval=serverData["id"];
                userinfo1={
                    "userid":userNameval
                }
                //alert("username:"+userinfo1["userid"])
                $.ajax({
                    type:"POST",
                    url:"ArticleFindByUserIdServlet",
                    data:"userRegInfo="+JSON.stringify(userinfo1),
                    dataType:"json",
                    beforeSend:function(){
                       // alert("弹出加载动画2");
                        
                    },
                    error:function(xmlHTTPreqeust,statusCode,exception){
                        alert(xmlHTTPreqeust.status);
                       // $("#log_id_tips").html("网络异常");
                    },
                    success:function(serverData){   //服务端返回200状态码时的回调函数ss
                        arts=eval(serverData);
                        console.log(arts);
                       // alert(art);
                       var out="";
                       for (var i in arts) {
                    //    console.log(arts[i])
                     ///   console.log("----------------------------------------")
                        out =  '<div class="grid-item">\n'+
                                '       <div class="grid-item__inner">\n'+
                                '           <div class="grid-item__content-wrapper">\n'+
                                '                <div class="post">\n'+
                                '                   <div class="post__media"><a href="blog-detail.html"><img src="'+arts[i].imageurl+'?w=1260&amp;h=750&amp;auto=compress&amp;cs=tinysrgb" alt=""/></a></div>\n'+
                                '                       <div class="post__body">\n'+
                                '                           <div class="post__meta"><span class="date">'+arts[i].arctime+'</span><span class="author"><a href="#">by '+arts[i].userid+'</a></span></div>\n'+
                                '                           <h2 class="post__title"><a href="blog-detail.html">'+arts[i].title+'</a></h2>\n'+
                                '                           <p class="post__text">'+arts[i].content+'</p>\n'+
                                '                           <a class="md-btn md-btn--outline-primary" href="'+encodeURI("blog-detail.html?"+'contenturl='+arts[i].archtml+'&date='+arts[i].arctime+'&title='+arts[i].title+'&user='+arts[i].userid)+'">read more\n'+
                                '                           </a>\n'+
                                '                       </div>\n'+
                                '                   </div>\n'+
                                '                </div>\n'+
                                '           </div>\n'+
                                '       </div>\n'+
                                '</div>\n'
                        $("#art_container").append(out);
                      //  console.log(out);
                     //   console.log("----------------------------------------")
                     }   
                        
                      work();
                       //s $("#art_container").trigger("create");
                        
                    }
                });

	            console.log(serverData);
	        }
		});
		
       // alert("弹出加载动画1");
                    
});

