package servlets;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.MemberDao;
import vo.Member;


@WebServlet("/member/delete")
public class MemberDeleteServlet extends HttpServlet {
	
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		System.out.println("/member/delete _doGet");
		try {
			ServletContext sc=this.getServletContext();	
			MemberDao memberDao=(MemberDao)sc.getAttribute("memberDao");
			Member member=new Member().setEmail(request.getParameter("email"));
			
			int result = memberDao.delete(member);
			
			if(result==1)
				System.out.println("delete ok");
				request.setAttribute("viewUrl", "redirect:list.do");

		} catch (Exception e) {
			throw new ServletException (e);
			
		} finally {	}
	}
}