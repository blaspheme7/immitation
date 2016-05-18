<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>회원 등록</title>
</head>
<body>
<h1>회원 등록</h1>
<form action='add.do' method='post'>
		이름: <input type='text' name='name'><br>
		이메일: <input type='text' name='email'><br>
		비밀번호: <input type='password' name='password'><br>
		핸드폰: <input type='text' name='number'><br>
		<input type='submit' value='추가'>
		<input type='button' value='취소' onclick='location.href="list.do"'>
		</form>
</body>
</html>