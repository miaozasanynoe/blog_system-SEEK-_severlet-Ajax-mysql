function getRandomCode(length) {
    if (length > 0) {
       var data = ["0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z", "a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z"];
       var nums = "";
       for (var i = 0; i < length; i++) {
          var r = parseInt(Math.random() * 61);
          nums += data[r];
       }
       return nums;
    } else {
       return false;
    }
 }
$(document).ready(function(){
	var userNameval=""
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
			userNameval=serverData["id"];
            console.log(serverData);
        }
	});
	//-----------------------------------------------------------------
	var imageurl=""
    var E = window.wangEditor
    var editor = new E('#editor')
    var cos = new COS({
    	SecretId: 'AKIDGLEqCKm26qLaYOycuELDqDPSXqFglITY',
    	SecretKey: 'DOcnoeQN7orlZzVbYZRn4HMJDiaIyOYT'
    	});
    editor.customConfig.customUploadImg = function (files, insert) {
            // files 是 input 中选中的文件列表
            // insert 是获取图片 url 后，插入到编辑器的方法
	cos.putObject({
		Bucket: 'test-1258897694',
		Region: 'ap-chengdu',
		Key: getRandomCode(15)+'.jpg',             /* 必须 */
		StorageClass: 'STANDARD',
		Body: files[0], // 上传文件对象
		onProgress: function(progressData) {
		    console.log(JSON.stringify(progressData));
		}
	}, function(err, data) {
		    console.log(err || data);
			insert('https://'+data['Location']);
			imageurl='https://'+data['Location']
			});
        }
        editor.create()


	    //-----------------------------
        document.getElementById('btn1').addEventListener('click', function () {
			var json = editor.txt.getJSON()  // 获取 JSON 格式的内容
			var jsonStr = JSON.stringify(json)
			var loc=''
			cos.putObject({
				Bucket: 'test-1258897694',
				Region: 'ap-chengdu',
				Key: getRandomCode(15)+'.js',                 /* 必须 */
				Body: "ffff='"+encodeURI(editor.txt.html())+"'",
			}, function(err, data) {
				console.log(err || data);
				loc='https://'+data['Location'];
				var title=$("#title").val();
				alert(title)
				var datas={
			            "userid":userNameval,
						"archtml":loc,
						"title":title,
						"content":editor.txt.text().substring(1,100)+'......',
						"imageurl":imageurl,
						"arcatatus":"0"
			        }
			        var dataObj = {};//声明一个js对象
			        $.ajax({
			                type:"POST",
			                url:"articleServlet",
			                data:"articleInfo="+JSON.stringify(datas),
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
			                    
							}
			        	});
				
			});
			
			//alert(editor.txt.html())
    	})
});






		