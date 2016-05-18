<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>회원 목록</title>
</head>
<body>
<jsp:include page="/Header.jsp"/> 
	<h1>회원목록</h1>
	<p><a href='add.do'>신규 회원</a></p><br>
	
	<c:forEach var="member" items="${members}" >
	<a href='update.do?email=${member.email}'>${member.name}</a>,
	${member.email}, ${member.number}, <a href='delete.do?email=${member.email}'>[삭제]</a><br>
	</c:forEach>

 
<jsp:include page="/Tail.jsp"/>

</body>
</html>