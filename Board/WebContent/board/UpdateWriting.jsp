<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>글 작성하기</title>

<style>
ul {padding:0;}
li {list-style:none;}
label {
	float:left;
	text-align:right;
	width:80px;
}</style>
</head>
<body>

<form action='modify.go' method='post'>
<ul>
	<li><label for="no">글번호</label>
		<input id="no" type='text' name='no' size="2" value='${writing.no}' readonly></li>
	<li><label for="title">제목</label>
		<input id="title" type='text' name='title' size="50" value='${writing.title}'></li>
	<li><label for="name">작성자명</label>
		<input id="name" type='text' name='name' size="20" value='${writing.name}' readonly></li>
	<li><label for="content">내용</label>
		<textarea id="content" name='content' rows="20" cols="40">${writing.content}</textarea></li>
</ul>
	<input type='submit' value='변경'>
	<input type='button' value='취소' onclick='location.href="list.go"'>
</form>

</body>
</html>