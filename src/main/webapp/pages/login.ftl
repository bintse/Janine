<#import "/spring.ftl" as spring/>
<html>
<head>
    <title>login the system by your account</title>
    <#--
    <link rel="stylesheet" type="text/css" href="<@s.url '/css/default.css'/>"/>-->
    <script type="text/javascript" src="<@spring.url '/js/jquery-2.1.4.min.js'/>"></script>     
    <script type="text/javascript"> 
		$(function(){  //生成验证码       
		    $('#kaptchaImage').click(function () {  
		    $(this).hide().attr('src', 'code/captcha-image?' + Math.floor(Math.random()*100) ).fadeIn(); });      
		});   
		 
		window.onbeforeunload = function(){  
		    //关闭窗口时自动退出  
		    if(event.clientX>360&&event.clientY<0||event.altKey){     
		        alert(parent.document.location);  
		    }  
		};  
		function changeCode() {  //刷新
			alert($('#kaptchaImage'));
		    $('#kaptchaImage').hide().attr('src', 'code/captcha-image?' + Math.floor(Math.random()*100) ).fadeIn();  
		    event.cancelBubble=true;  
		}
		function changeVerifyCode(){
     		var verifyCodeValue = $("#kaptcha").val();
        	if(verifyCodeValue.replace(/\s/g,"") == "") {
            	alert("请输入验证码");
        	}else {
            	//异步检查验证码是否输入正确
            	var verifyUrl = "code/captcha-code?" + Math.floor(Math.random()*100);
	            $.ajax({
	                type:"POST",
	                url:verifyUrl,
	                data:{"verifyCode":verifyCodeValue},
	                //contentType: "application/json",  
                	dataType: "json",  
	                success:function(data){
	                	alert("===>" + data);
	                    if(data==true) {
	                   
	 
	                     //alert("输入正确 ！");
	                    }else {
	                        alert("请输入正确的验证码！");
	                    }
	                },
	                error:function(e){
	                    alert("---->" + e);
	                }
	            });
        	}
    	}
	</script> 
</head>
<body>
<#include "./header.ftl"/>
<form action="greeting" method="POST" name="form">
	<table>
		<tr>
			<td>Names:</td>
			<td><input type="text" name="username"/></td>
		</tr>
		<tr>
			<td>Password:</td>
			<td><input type="password" name="password"/></td>
		</tr>
		<tr>
			<td>验证码 :</td>
			<td><input name="j_code" type="text" id="kaptcha" maxlength="4" class="form-control" onblur="changeVerifyCode()" />
				<img src="code/captcha-image" id="kaptchaImage"  style="margin-bottom: -3px"/>
	   			<a href="#" onclick="changeCode()">看不清?换一张</a></td>
		</tr>
	</table>
    
    <br>
    
    <br>
	<div class="form-group">  
	   <label></label> 
	   
	   
	    <br/>  
	</div>
    <input type="submit" value="submit"/>
</form>

<!--use include to include another ftl file content in this file.-->
<#include "./footer.ftl"/>
</body>
</html>