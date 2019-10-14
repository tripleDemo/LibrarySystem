<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>管理员操作页面</title>
	<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@3.3.7/dist/css/bootstrap.min.css">
	<link href="${pageContext.request.contextPath}/static/css/managerPage.css" rel="stylesheet"/>
</head>
<body>
	<nav class="navbar navbar-inverse">
        <span>欢迎</span><span>${userMsg.userName}</span>    
        <a href="${pageContext.request.contextPath}/destroySession">退出</a>
    </nav>
    
    <div class="container">
    	<button class="btn btn-success"><a href="${pageContext.request.contextPath}/addBook"><span class="glyphicon glyphicon-plus"></span>新增图书</a></button>
	    <table class="table table-hover">
	            <tr class="warning">
	                <th>图书封面</th>
	                <th>图书名称</th>
	                <th>借阅数量</th>
	                <th>出版社</th>
	                <th>出版日期</th>
	                <th>操作</th>
	            </tr>
	            <c:forEach var="bookMsg" items="${bookMsgs}" varStatus="status">
	            	<tr>
		                <th><img src="${bookMsg.bookCover}" alt="图片加载失败"></th>
		                <th class="dataBox">${bookMsg.bookName}</th>
		                <th class="dataBox">${bookMsg.borrowNum}</th>
		                <th class="dataBox">${bookMsg.publisher}</th>
		                <th class="dataBox">${bookMsg.publishTime}</th>
		                <th class="inputBox"><input type="type" value="${bookMsg.bookName}" name="bookName" id="bookName" required="required"></th>
		                <th class="inputBox"><input type="type" value="${bookMsg.borrowNum}" name="borrowNum" id="borrowNum" required="required"></th>
						<th class="inputBox"><input type="type" value="${bookMsg.publisher}" name="publisher" id="publisher" required="required"></th>
						<th class="inputBox"><input type="type" value="${bookMsg.publishTime}" name="publishTime" id="publishTime" required="required"></th>
		                <th>
		                	<input type="hidden" value="${bookMsg.bookId}" name="bookId" id="bookId">
		                	<button class="saveBtn btn btn-success"><span class="glyphicon glyphicon-pencil"></span>保存</button>
		                	<button class="modifyBtn btn btn-success"><span class="glyphicon glyphicon-pencil"></span>修改</a></button>
		                	<button class="btn btn-danger"><a href="${pageContext.request.contextPath}/deleteBook?bookId=${bookMsg.bookId}"><span class="glyphicon glyphicon-remove"></span>删除</a></button>
		                </th>
		            </tr>
	            </c:forEach>
	        </table>
	    </div>
	
	    <nav aria-label="Page navigation">
	    	<input type="hidden" value="${pages}" id="pages">
	        <ul class="pagination">
	          <li>
	            <a href="${pageContext.request.contextPath}/switchPage?currentPage=" aria-label="Previous" id="toLeft">
	              <span aria-hidden="true">&laquo;</span>
	            </a>
	          </li>
	          <c:forEach begin="1" end="${pages}" varStatus="status">
	          	<li class="liNum${currentPage==status.index ? ' active' : ''}" id="liNum${status.index}"><a href="${pageContext.request.contextPath}/switchPage?currentPage=${status.index}">${status.index}</a></li>
	          </c:forEach>
	          <li>
	            <a href="${pageContext.request.contextPath}/switchPage?currentPage=" aria-label="Next" id="toRight">
	              <span aria-hidden="true">&raquo;</span>
	            </a>
	          </li>
	        </ul>
	    </nav>
    </div>
    
    <footer>        
        <span>&copy;Serve the Flowers of the Motherland .</span>
        <span>为祖国的花朵服务 。</span>
    </footer>	 
</body>
<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script src="${pageContext.request.contextPath}/static/js/managerPage.js"></script>
</html>