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
	<h4>�j���\�A�o�̬Osuccess.jsp����!!!</h4>
	<p>�o�O�qModeAndView���X�Ӫ��ɶ�:${time}</p>
	<br>
	<p>�o�O�qrequset sessionAttributes���ը��X�Ӫ��ϥΪ�:${requestScope.user}</p>
	<br>
	<p>�o�O�qsession sessionAttributes���ը��X�Ӫ��ϥΪ�:${sessionScope.user}</p>
	<br>
	<p>�o�O�qrequset sessionAttributes���ը��X�Ӫ��u�@:${requestScope.job}</p>
	<br>
	<p>�o�O�qsession sessionAttributes���ը��X�Ӫ��u�@:${sessionScope.job}</p>
	<br>
	<p>�o�O�qrequset testModelAttribute���խק��X�Ӫ��ϥΪ�:${requestScope.user}</p>
	<br>
	<fmt:message key="i18n.username"/>
	<fmt:message key="i18n.password"/>
	
</body>
</body>
</html>