$(function(){ //等待DOM加载完毕
    let url = document.URL;//取得当前页的URL  
	let index = url.lastIndexOf("/");
	let mark = url.substring(index+1); 
	let formAction = $("form").attr("action");
	if(mark == "login" | mark == "toLogin"){
		$("#registerSign").css("border-bottom","");
		$("#loginSign").css("border-bottom","6px solid white");
		$("#btn").text("登录");
		$("form").attr("action", formAction+"/toLogin");
	}else if(mark == "register"| mark == "toRegister"){
		$("#loginSign").css("border-bottom","");
		$("#registerSign").css("border-bottom","6px solid white");
		$("#btn").text("注册");
		$("form").attr("action", formAction+"/toRegister");
	}	
});
