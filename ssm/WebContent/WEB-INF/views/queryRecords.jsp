<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>查询借阅记录页面</title>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@3.3.7/dist/css/bootstrap.min.css">
<link href="${pageContext.request.contextPath}/static/css/queryRecords.css" rel="stylesheet"/>
</head>
<body>
<nav class="navbar navbar-inverse">
        <span>欢迎</span><span>${userMsg.userName}</span>    
        <a href="${pageContext.request.contextPath}/userPage">返回首页</a>
    </nav>
    
    <div>
        <table class="table table-hover">
            <tr class="warning">
                <th>编号</th>
                <th>图书封面</th>
                <th>图书名称</th>
                <th>出版社</th>
                <th>借出日期</th>
                <th>归还日期</th>
                <th>操作</th>
            </tr>
            <c:forEach var="borrowInfo" items="${borrowInfos}" varStatus="status">
            	<tr>
	                <th>${(currentPage-1)*7+status.index+1}</th>
	                <th><img src="${borrowInfo.bookMsg.bookCover}" alt="图片加载失败"></th>
	                <th>${borrowInfo.bookMsg.bookName}</th>
	                <th>${borrowInfo.bookMsg.publisher}</th>
	                <th>${borrowInfo.lendTime}</th>
	                <th>${borrowInfo.returnTime}</th>
	                <th><button class="btn btn-danger"><a href="${pageContext.request.contextPath}/deleteRecord?infoId=${borrowInfo.infoId}">删除记录</a></button></th>
	            </tr>
            </c:forEach>
        </table>
    </div>

    <nav aria-label="Page navigation">
    	<input type="hidden" value="${pages}" id="pages">
        <ul class="pagination">
          <li>
            <a href="${pageContext.request.contextPath}/changeRecordPage?currentPage=" aria-label="Previous" id="toLeft">
              <span aria-hidden="true">&laquo;</span>
            </a>
          </li>
          <c:forEach begin="1" end="${pages}" varStatus="status">
          	<li class="liNum${currentPage==status.index ? ' active' : ''}" id="liNum${status.index}"><a href="${pageContext.request.contextPath}/changeRecordPage?currentPage=${status.index}">${status.index}</a></li>
          </c:forEach>
          <li>
            <a href="${pageContext.request.contextPath}/changeRecordPage?currentPage=" aria-label="Next" id="toRight">
              <span aria-hidden="true">&raquo;</span>
            </a>
          </li>
        </ul>
      </nav>
    
    <footer>        
        <span>Just as food is necessary to life , so are books to our spirit .</span>
        <span>正如食物对于生命来说是必需的一样 , 书籍对于我们的精神也是必需的 。</span>
    </footer>
</body>
<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script src="${pageContext.request.contextPath}/static/js/queryRecords.js"></script>
</html>