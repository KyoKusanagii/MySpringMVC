<%@ page language="java" contentType="text/html; charset=BIG5"
    pageEncoding="BIG5"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="BIG5">
<title>Insert title here</title>
</head>
<body>
	<h4>大成功，這裡是success.jsp頁面!!!</h4>
	<p>這是從ModeAndView取出來的時間:${time}</p>
	<br>
	<p>這是從requset sessionAttributes測試取出來的使用者:${requestScope.user}</p>
	<br>
	<p>這是從session sessionAttributes測試取出來的使用者:${sessionScope.user}</p>
	<br>
	<p>這是從requset sessionAttributes測試取出來的工作:${requestScope.job}</p>
	<br>
	<p>這是從session sessionAttributes測試取出來的工作:${sessionScope.job}</p>
	<br>
	<p>這是從requset testModelAttribute測試修改後出來的使用者:${requestScope.user}</p>
	<br>
	<fmt:message key="i18n.username"/>
	<fmt:message key="i18n.password"/>
	
</body>
</body>
</html>