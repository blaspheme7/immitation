<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>  
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>CommentView</title>
</head>
<body>
	<table border="1">
	<c:forEach var="comment" items="${comments}">
		<tr>
			<th width=80>작성자</th><td width="153px">${comment.writer}</td><th width=80>작성날짜</th><td width=120 align="center">${comment.cre_date}</td>
		</tr>
		<tr>
			<td colspan=4>${comment.content}</td>
		</tr>
	</c:forEach>
	</table>
	<br>
</body>
</html>