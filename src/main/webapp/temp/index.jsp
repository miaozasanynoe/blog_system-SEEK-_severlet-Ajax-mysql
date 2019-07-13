<%@page language="java" pageEncoding="UTF-8"  %>
<html>
	<head>
		<script type="text/javascript" src="js/jquery-3.4.1.min.js"></script>
		
		<script type="text/javascript">
			//编写jquery代码
			 //$(document)将js中的documnet对象转换成jquery对象
			 //.ready()表示页面加载完毕后需要执行的代码
			$(document).ready(function(){
				//	alert("Jquery init");
				//使用jquery获得用户名，密码文本框中的值
				//var userNameval =   $("#userName").val();//document.getElementById("userName").value
				//alert(userNameval);
				
				//修改文本的值
				//$("#userName").val("manager"); //document.getElementById("userName").value="manager"
				
				//给提交按钮绑定点击事件，做表单验证:
				$("#MyButton").click(function(){
					//alert("点击了按钮");
					//获得用户名，要求用户名至少是6个字符串 
					var userNameval =   $("#userName").val();
					if (userNameval.length<6){//判断字符长度
						//alert("户名至少是6个字符串");
						//document.getElementById("userNameTip").innerHTML="户名至少是6个字符串";
						$("#userNameTip").html("户名至少是6个字符串");
					}else{
						$("#userNameTip").html("用户名合法");
					}
					//获得密码
					var password = $("#password").val();
					if (password==""){//判断密码不能为空
						//alert("密码不能为空");
						//document.getElementById("passwordTip").innerHTML="密码不能为空";
						$("#passwordTip").html("密码不能为空");
					}else{
						$("#passwordTip").html("");
					}
					
				});
				
				
				$("#jqueryajaxButton").click(function(){
					//用jquery发起ajax请求
					//1.用get发请求
					var url = "userServlet";
					var dataObj = {};//声明一个js对象
					//function(serverData){} 是服务端正常返回200状态时的回调函数，服务端返回的数据在function中的形参中传递给我们
					/*
					$.post(url,dataObj,function(serverData){
						alert("服务端返回的数据为:"+serverData);
					},'text');
					
					*/
					
					//发ajax请求，用get方式访问userServlet
					
					//底层的ajax方法
					//$.ajax({}) 形参传递js对象，js对象的属性参$.ajax函数的settings属性描述
					$.ajax({
							type:"POST",
							url:"userServlet",
							data:{},
							beforeSend:function(){
								alert("弹出加载动画");
								
							},
							error:function(xmlHTTPreqeust,statusCode,exception){
								alert(xmlHTTPreqeust.status);
							},
							success:function(serverData){   //服务端返回200状态码时的回调函数
										alert("用ajax函数得到的服端返回数据:"+serverData);
								    }
							});
							
					
				});
				
				
				
			
			});
			
			
			
			//声明一个全局变量XMLHttpReqeust
			var httpReqeust =null;
			//定义一函数用于获得XMLHttpReqeuest对象
			
			function getXMLHttpRequest() {
				if (window.XMLHttpRequest) {   //当浏览器是非IE时,返回true
					httpReqeust = new XMLHttpRequest();//For Mozilla/Safari
				} else if (window.ActiveXObject) {//判断IE浏览器
					//For IE
					httpReqeust = new ActiveXObject("Microsoft.XMLHTTP");
				}
			}

			
			/*点击测试ajax请求调用该函数*/
			function sendAjaxData(){
				getXMLHttpRequest();//调用生成XMLHttpRequest对象的方法，给httpReqeust赋值
				
				var url = "userServlet"
				httpReqeust.open("GET",url);
				
				//通讯状态在发生改变时，会回调用function中的代码
				httpReqeust.onreadystatechange = function(){
					///alert(httpReqeust.readyState);
					if(httpReqeust.readyState==4){
						//状态服务端的状态 码:  404,200,500
						if (httpReqeust.status==200){//表示服务端正常返回的数据
							//接收服务端返回的数据
							var serverData = httpReqeust.responseText;
							alert("服务端返回的数据为:"+serverData);
						}else if (httpReqeust.status==404){
							alert("请求的资源不存在404");
						}else if (httpReqeust.status==500){
							alert("服务器内部错误 500");
						}
						
					}
				}
				
				//客户端与服务端交互过程有通信状态,分别为:
			//0(uninitialized，未初始化):对象已经创建，但还没有调用open()方法
			///1(loading，载入中)：open()方法已经调用，但请求还没有发送
			//2(loaded，已载入)：请求已经发送
			//3(interactive，交互中):已经接收到部分响应
			//4(complete，完成):所有数据已经收到，连接已经关闭

				
				
				httpReqeust.send(null);
				
				//如何接收服务端(Servlet)返回的字符串,服务端通过out往客户端输出内容
				
				//编写servlet 在maven项目的src/main/java目录下编写
				
			}
		
		</script>
	
	</head>

	<body>
	
	
		<form action="xxxServlet">
			用户名:<input type="text" value="admin" id="userName" name="userName" ><span id="userNameTip"></span>
			<br/>
			密码:<input id="password" type="password" name="pwd"><span id="passwordTip" ></span>
			<br/>
			<input type="button" id="MyButton" value="登录 ">  
			
			<input type="button" id="ajaxButton" value="测试JS  ajax请求" onclick="sendAjaxData()"> 
			
			
			<input type="button" id="jqueryajaxButton" value="测试Jquery ajax请求" > 
		</form>
	</body>
</html>
