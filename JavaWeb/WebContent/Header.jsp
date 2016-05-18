<%@ page import="vo.Member" %>
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>

    <%
    Member member = (Member)session.getAttribute("member");
    if(member==null){
    	request.getRequestDispatcher("/login");
    }
    %>

    <div style="background-color:#dddddd;color:#4444ff;height:20px;padding:5px;">SPMS (Simple Project Management System)
    
    <span style="float:right;">
    <%=member.getName()%>
    <a style="color:white;" href="<%=request.getContextPath() %>/member/logout">로그아웃</a>
    </span>
    
</div>