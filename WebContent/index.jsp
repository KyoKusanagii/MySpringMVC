<%@ page language="java" contentType="text/html; charset=BIG5"
    pageEncoding="BIG5"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="BIG5">
<title>Insert title here</title>
</head>
<body>

	<a href="<%=request.getContextPath()%>/SpringMVC/testRedirect">����testRedirect</a><br>
 	<a href="<%=request.getContextPath()%>/SpringMVC/testView">����testView</a><br>
	<a href="<%=request.getContextPath()%>/SpringMVC/testViewAndViewResolver">����testViewAndViewResolver</a><br>
		 
		<!-- 	�����ק�ާ@�A��l�ƾڬ�:
			1.1004636
			2.Max
			3.max@yahoo.com.tw
			4.123456	
			5.25	
			
			   �K�X����Q�ק�A���������b����g�������ݩʭ�	
		 -->
	<form action="<%=request.getContextPath()%>/SpringMVC/testModelAttribute" method="post">
		<p>����testModelAttribute�����</p>
		<input type="hidden" name="id" value="1004636">
		username:<input type="text" name="username" value="Max"><br>
		email:<input type="text" name="email" value="max@yahoo.com.tw"><br>
		age:<input type="text" name="age" value="25"><br>
		<input type="submit">
	</form>

	<a href="<%=request.getContextPath()%>/SpringMVC/helloWorld.do">�I�ګe���@�ɧA�n�Asuccess����</a>
	<form action="<%=request.getContextPath()%>/SpringMVC/helloWorld.do">
		<p>�I�ګe���@�ɤ��n�AASS����</p>
		<input type="submit">
	</form>
	<form action="<%=request.getContextPath()%>/SpringMVC/helloWorld.do" method="post">
		<input type="submit">
	</form>
	<a href="<%=request.getContextPath()%>/SpringMVC/testModelAndView">����ModeAndView</a>
	<a href="<%=request.getContextPath()%>/SpringMVC/testsessionAttributes">����sessionAttribute</a>

</body>
</html>