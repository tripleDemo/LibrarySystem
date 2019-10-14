<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8"/>
    <title>用户操作页面</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@3.3.7/dist/css/bootstrap.min.css">
    <link href="${pageContext.request.contextPath}/static/css/userPage.css" rel="stylesheet"/>
</head>
<body>
    <nav class="navbar navbar-inverse">
        <span>欢迎</span><span>${userMsg.userName}</span>    
        <a href="${pageContext.request.contextPath}/destroySession">退出</a>
    </nav>

    <a href="${pageContext.request.contextPath}/getTopBooks">
        <div class="listbox">
            <span class="glyphicon glyphicon-book" aria-hidden="true"></span>
            <div class="title">借书</div>
        </div>
    </a>
    <a href="${pageContext.request.contextPath}/toReturn">
	    <div class="listbox">
	        <span class="glyphicon glyphicon-bookmark" aria-hidden="true"></span>
	        <div class="title">还书</div>
	    </div>
    </a>
    <a href="${pageContext.request.contextPath}/toQuery">
	    <div class="listbox">
	        <span class="glyphicon glyphicon-search" aria-hidden="true"></span>
	        <div class="title">查询</div>
	    </div> 
    </a>
     
    <footer>        
        <span>Just as food is necessary to life , so are books to our spirit .</span>
        <span>正如食物对于生命来说是必需的一样 , 书籍对于我们的精神也是必需的 。</span>
    </footer> 
</body>
</html>