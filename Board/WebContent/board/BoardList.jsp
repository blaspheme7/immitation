<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>  
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<title>게시판 목록</title>
</head>
<body>
	<h1>게시물 목록</h1>
	<table border="1">
	<tr>
		<th>번호</th>
		<th>제목</th>
		<th>작성자</th>
		<th>작성일</th>
		<th>조회수</th></tr>
		
	<c:forEach var="writing" items="${writings}">
	<tr>
		<td>${writing.no}</td>
		<td><a href='see.go?no=${writing.no}'>${writing.title}</a></td>
		<td>${writing.name}</td>
		<td>${writing.createdDate}</td>
		<td>${writing.refnum}</td>
	</tr>
	</c:forEach>
	</table><br>
	<p><a href='write.go'>글 쓰기</a></p><br>
</body>
</html>