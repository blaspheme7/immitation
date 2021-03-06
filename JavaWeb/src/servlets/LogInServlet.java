package servlets;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.MemberDao;
import vo.Member;


@WebServlet("/member/login")
public class LogInServlet extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		System.out.println("/login _doGet");
		RequestDispatcher rd=request.getRequestDispatcher("/LogInForm.jsp");
		rd.forward(request, response);
	}
		   
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		System.out.println("/login _doPost");
		
		try {
			
			Member member=new Member();
			ServletContext sc=this.getServletContext();
			MemberDao memberDao=(MemberDao)sc.getAttribute("memberDao");
			member=memberDao.checkUser(request.getParameter("email"),request.getParameter("password"));
			
			if(member!=null) {
				HttpSession session=request.getSession();
				session.setAttribute("member", member);
				
				response.sendRedirect("/JavaWeb/member/list.do");
				
			}  else {
				
				RequestDispatcher rd=request.getRequestDispatcher("/LogInFail.jsp");
				rd.forward(request, response);
				
			}
		} catch (Exception e) {
			
			throw new ServletException(e);
			
		}
		
	}
	
}