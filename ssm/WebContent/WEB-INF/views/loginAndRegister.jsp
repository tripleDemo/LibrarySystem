<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8"/>
    <title>图书管理系统登录页面</title>
    <link href="${pageContext.request.contextPath}/static/css/loginAndRegister.css" rel="stylesheet" type="text/css"/>
</head>
<body>
    <div class="login-box">
        <div class="signA" id="loginSign">
            <a id="signIn" href="${pageContext.request.contextPath}/login">登录</a>
        </div>
        <div class="signA" id="registerSign">
            <a id="signUp" href="${pageContext.request.contextPath}/register">注册</a>
        </div><br/>       
        <c:if test="${errorMsg != null}">
        	<div class="errorMsg">${errorMsg}</div>
        </c:if>                 
        <form action="${pageContext.request.contextPath}" method="post">
            <div class="textbox">
                <i class="fa fa-user"></i>
                <input type="text" placeholder="请输入账号" name="userName" value="" required="required"/>
            </div>
            <div class="textbox">
                <i class="fa fa-lock"></i>
                <input type="password" placeholder="请输入密码" name="password" value="" required="required"/>
            </div>
            <div class="type">
            	<input type="radio" name="type" value="user" required="required"/>用户
            	<input type="radio" name="type" value="manager" required="required"/>管理员
            </div>
            <button id="btn" type="submit">登录</button>
        </form>
    </div>
</body>
	<script src="${pageContext.request.contextPath}/static/js/jquery-3.4.1.min.js" type="text/javascript"></script>
	<script src="${pageContext.request.contextPath}/static/js/loginAndRegister.js" type="text/javascript"></script>
</html>