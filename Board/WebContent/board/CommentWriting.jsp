<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title></title>
</head>
<body>
<form action='addComment.go' method='post'>
	<table border="1">
		<tr>
			<th width="80px">작성자</th><td><input id="writer" type='text' name='writer' size="95px"></td>
			<th width=80>Password</th><td width=120><input id="password" type='text' name='password' size="14"></td>
		</tr>
		<tr>
			<td colspan=4 valign="middle">내용 <textarea id="content" name='content' rows="4" cols="40"></textarea>
			<input type='button' value='등록' onclick='location.href="addComment.go?no=${writing.no}"'></td>
		</tr>
	</table>
</form>
</body>
</html>