var cos = new COS({
    	SecretId: 'AKIDGLEqCKm26qLaYOycuELDqDPSXqFglITY',
    	SecretKey: 'DOcnoeQN7orlZzVbYZRn4HMJDiaIyOYT'
    	});
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
	var userNameval=""
	var imageurl=""
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
    			//$("#show_username").html(serverData["id"]);
    			userNameval=serverData["id"];
    	        console.log(serverData);
    	    }
    	});
function sendFile(files,editor,welEditable){
	data = new FormData();
	alert(files)
	var filename=getRandomCode(15)+'.jpg'
	data.append("file", files);
	cos.putObject({
		Bucket: 'test-1258897694',
		Region: 'ap-chengdu',
		Key: filename,             /* 必须 */
		StorageClass: 'STANDARD',
		Body: files, // 上传文件对象
		onProgress: function(progressData) {
		    console.log(JSON.stringify(progressData));
		}
	}, function(err, data) {
		    console.log(err || data);
			//insert('https://'+data['Location']);
			imageurl='https://'+data['Location']
			$('#summernote').summernote('insertImage', imageurl, filename);
			});
}

$(document).ready(function() {
    $('#summernote').summernote({
        lang: 'zh-CN', // default: 'en-US'  
		focus:true,
		height:270,
		callbacks: {
        onImageUpload: function(files,editor,welEditable) { 
			console.log("ass") 
		sendFile(files[0],editor,welEditable);
			}  
		}
	});
	document.getElementById('save_btn').addEventListener('click', function () {
		console.log($('#summernote').summernote('code'));
			var loc=''
			cos.putObject({
				Bucket: 'test-1258897694',
				Region: 'ap-chengdu',
				Key: getRandomCode(15)+'.js',                 /* 必须 */
				Body: "artjs='"+encodeURI($('#summernote').summernote('code'))+"'",
			}, function(err, data) {
				console.log(err || data);
				loc='https://'+data['Location'];
				var title=$("#title").val();
				alert(title)
				var datas={
			        "userid":userNameval,
					"archtml":loc,
					"title":title,
					"content":$($('#summernote').summernote('code')).text()+'......',
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