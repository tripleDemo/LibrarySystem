<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>新增图书页面</title>
	<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@3.3.7/dist/css/bootstrap.min.css">
	<link href="${pageContext.request.contextPath}/static/css/addBook.css" rel="stylesheet"/>
</head>
<body>
	<nav class="navbar navbar-inverse">
        <span>欢迎</span><span>${userMsg.userName}</span>    
        <a href="${pageContext.request.contextPath}/toManagerPage">返回首页</a>
    </nav>
    
    <form action="${pageContext.request.contextPath}/toAddBook" method="post" enctype="multipart/form-data">
    	<label>图书名称
			<input type="type" value="" name="bookName" required="required" placeholder="请输入图书名称">
		</label><br/>
    	<label>图书封面
			<input type="file" value="" name="bookFile" required="required">
		</label><br/>							
    	<label>作者名字
			<input type="type" value="" name="authorName" required="required" placeholder="请输入作者名字">
		</label><br/>  	
    	<label>作者照片
			<input type="file" value="" name="authorFile" required="required" >
		</label><br/>		
    	<label>作者生日
			<input type="type" value="" name="authorBirth" required="required" placeholder="日期格式(yyyy-MM-dd)">
		</label><br/>   	
    	<label>出版社
			<input type="type" value="" name="publisher" required="required" placeholder="请输入出版社">
		</label><br/> 	
    	<label>出版时间
			<input type="type" value="" name="publishTime" required="required" placeholder="日期格式(yyyy-MM-dd)">
		</label><br/>	
		<div><button class="btn btn-success">提交</button></div>
    </form>
    
    <footer>        
        <span>&copy;Serve the Flowers of the Motherland .</span>
        <span>为祖国的花朵服务 。</span>
    </footer>
</body>
</html>