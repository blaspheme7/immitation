<%@ page language="java"  contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" 
  "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>프로젝트 정보</title>
</head>
<body>

<table border="1">
	<tr>
		<th width="60px">글번호</th><td align="center" width="40px">${writing.no}</td><th width="60px">작성자</th><td align="center">${writing.name}</td><th>작성일</th><td align="center" width="90px">${writing.createdDate}</td>
	</tr>
	<tr>
		<th>제목</th><td colspan=3 width="200px">${writing.title}</td><th>조회수</th><td>${writing.refnum}</td>
	</tr>
	<tr>
		<td colspan=6 height="200px">${writing.content}</td>
	</tr>
	<tr>
		<jsp:include page="CommentView.jsp">
			<jsp:param name="wno" value="${writing.no}"/>
		</jsp:include>
	</tr>
	</table><br>
	<input type='button' value='수정' onclick='location.href="modify.go?no=${writing.no}"'>
	<input type='button' value='삭제' onclick='location.href="delete.go?no=${writing.no}"' >
	<input type='button' value='뒤로가기' onclick='location.href="list.go"'>
</form>
</body>
</html>