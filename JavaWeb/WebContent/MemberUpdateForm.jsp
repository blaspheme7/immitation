<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="euc-kr"%>
   <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>ȸ������</title>

</head>
<body>
	<h1>ȸ������</h1>
	<form action='update' method='post'>
		�̸�: <input type='text' name='name' value='${member.name}'><br>
		�̸���: <input type='text' name='email' value='${member.email}' readonly><br>
		�н�����: <input type='text' name='password' value='${member.password}'><br>
		�ڵ���: <input type='text' name='number' value='${member.number}'><br>
		<input type='submit' value='����'>
		<input type='button' value='����' onclick='location.href="delete.do?email=${member.email}";'>
		<input type='button' value='���' onclick='location.href="list.do"'>
	</form>
</body>
</html>