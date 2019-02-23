<%@ page language="java" contentType="text/html; charset=BIG5"
    pageEncoding="BIG5"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="BIG5">
<title>Insert title here</title>
</head>
<body>

	<a href="<%=request.getContextPath()%>/SpringMVC/testRedirect">測試testRedirect</a><br>
 	<a href="<%=request.getContextPath()%>/SpringMVC/testView">測試testView</a><br>
	<a href="<%=request.getContextPath()%>/SpringMVC/testViewAndViewResolver">測試testViewAndViewResolver</a><br>
		 
		<!-- 	模擬修改操作，原始數據為:
			1.1004636
			2.Max
			3.max@yahoo.com.tw
			4.123456	
			5.25	
			
			   密碼不能被修改，模擬直接在表單填寫對應的屬性值	
		 -->
	<form action="<%=request.getContextPath()%>/SpringMVC/testModelAttribute" method="post">
		<p>測試testModelAttribute的表單</p>
		<input type="hidden" name="id" value="1004636">
		username:<input type="text" name="username" value="Max"><br>
		email:<input type="text" name="email" value="max@yahoo.com.tw"><br>
		age:<input type="text" name="age" value="25"><br>
		<input type="submit">
	</form>

	<a href="<%=request.getContextPath()%>/SpringMVC/helloWorld.do">點我前往世界你好，success頁面</a>
	<form action="<%=request.getContextPath()%>/SpringMVC/helloWorld.do">
		<p>點我前往世界不好，ASS頁面</p>
		<input type="submit">
	</form>
	<form action="<%=request.getContextPath()%>/SpringMVC/helloWorld.do" method="post">
		<input type="submit">
	</form>
	<a href="<%=request.getContextPath()%>/SpringMVC/testModelAndView">測試ModeAndView</a>
	<a href="<%=request.getContextPath()%>/SpringMVC/testsessionAttributes">測試sessionAttribute</a>

</body>
</html>