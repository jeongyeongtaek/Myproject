<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>안녕히 가세요</title>
</head>
<body>
	<h1>아름답게 꾸민 로그아웃 페이지</h1>
	
	<form name='mySubmit' action="logout" method="post">
		<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
	</form>
</body>
<script>
	document.mySubmit.submit();
</script>
</html>