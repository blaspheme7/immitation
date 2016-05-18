<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="euc-kr"%>
   <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>회원정보</title>

</head>
<body>
	<h1>회원정보</h1>
	<form action='update' method='post'>
		이름: <input type='text' name='name' value='${member.name}'><br>
		이메일: <input type='text' name='email' value='${member.email}' readonly><br>
		패스워드: <input type='text' name='password' value='${member.password}'><br>
		핸드폰: <input type='text' name='number' value='${member.number}'><br>
		<input type='submit' value='저장'>
		<input type='button' value='삭제' onclick='location.href="delete.do?email=${member.email}";'>
		<input type='button' value='취소' onclick='location.href="list.do"'>
	</form>
</body>
</html>