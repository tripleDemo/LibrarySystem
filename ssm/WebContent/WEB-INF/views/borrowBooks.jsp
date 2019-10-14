<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8"/>
    <title>用户借书操作页面</title>
    <link href="${pageContext.request.contextPath}/static/css/swiper.min.css" rel="stylesheet"/>
    <link href="${pageContext.request.contextPath}/static/css/borrowBooks.css" rel="stylesheet"/>
</head>
<body>
    <!-- search -->
    <nav>
        <div id="searchBox">
            <input type="text" placeholder="请输入关键字" value="" id="searchContext"/>
            <div id="search">
                <a id="go"><i class="fas fa-search"></i></a>
            </div>  
            <div class="searchType" id="bookSearch">图书查询</div> 
            <div class="searchType" id="authorSearch">作者查询</div> 
            <div id="choose"></div>         
        </div>        
        <a id="black" href="${pageContext.request.contextPath}/userPage">返回首页</a>
    </nav>


	<!-- context -->
	<c:choose>
		<c:when test="${TopBookMsgs != null}">
			<!-- Swiper 列出借阅排名前10的图书 -->
			<div class="swiper-container">
				<div id="list">
					<h2 class="fas fa-crown">借阅排名前10图书 :</h2>
				</div>
				<div class="swiper-wrapper">
					<c:forEach var="bookMsg" items="${TopBookMsgs}">
						<div class="swiper-slide">
							<div class="imgBox">
								<img src="${bookMsg.bookCover}" alt="图片加载失败">
							</div>
						</div>
					</c:forEach>
				</div>
				<div class="swiper-pagination"></div>
			</div>
		</c:when>
		<c:when test="${bookMsgs != null}">
			<!-- 列出筛选后的图书 -->
			<div class="books-container">
				<c:forEach var="bookMsg" items="${bookMsgs}">
					<div class="bookBox">
						<div class="bookImg" onclick="showWindow(${bookMsg.bookId})">
							<img src="${bookMsg.bookCover}" alt="图片加载失败">
						</div>
						<form action="${pageContext.request.contextPath}/toBorrow" method="post">
							<input type="hidden" name="borrowId" value="${bookMsg.bookId}"> 
							<button class="borrowBtn">借书</button>
						</form>
					</div>
				</c:forEach>
			</div>
		</c:when>
	</c:choose>


	<!-- 遮罩层 -->
    <div id="cover"></div>
    <!-- 3D翻页的书 -->
    <div class="jump-container">
        <div class="page" id="leftPage">
            <div class="bookCover">
                <img alt="图片加载失败" id="book_img">
            </div>
        </div>
        <div class="page" id="rightPage">
            <div class="authorPhoto">
                <img alt="图片加载失败" id="author_img">
            </div>
            <div class="introduceBox">
                <p>BookName:<span id="bookNameSpan"></span></p>
                <p>PublishTime:<span id="publishTimeSpan"></span></p>
                <p>AuthorName:<span id="authorNameSpan"></span></p>
                <p>Birth:<span id="birthSpan"></span></p>
                <p>Publisher:<span id="publisherSpan"></span></p>
                <p>BorrowNumber:<span id="borrowNumSpan"></span></p>
            </div>
        </div>
        <button id="fanye">翻页</button>
    </div>
</body>  
	<!-- swiper script-->
	<script src="${pageContext.request.contextPath}/static/js/swiper.min.js"></script>
	<script>
		var swiper = new Swiper('.swiper-container', {
			effect : 'coverflow',
			grabCursor : true,
			centeredSlides : true,
			slidesPerView : 'auto',
			coverflowEffect : {
				rotate : 50,
				stretch : 0,
				depth : 100,
				modifier : 1,
				slideShadows : true,
			},
			pagination : {
				el : '.swiper-pagination',
			}
		});
	</script>
	<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
    <script src="${pageContext.request.contextPath}/static/js/borrowBooks.js"></script>
</html>