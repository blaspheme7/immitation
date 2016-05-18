package servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.MemberDao;
import vo.Member;


@WebServlet("/member/update")
public class MemberUpdateServlet extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		System.out.println("/member/update _doGet");
		request.setCharacterEncoding("utf-8");
		
		try{
			response.setContentType("text/html; charset=utf-8");
			ServletContext sc=this.getServletContext();	
			Member member=new Member();
			String email=request.getParameter("email");
			MemberDao memberDao=(MemberDao)sc.getAttribute("memberDao");
			System.out.println(email);
			member=memberDao.search(email);
			
			request.setAttribute("member", member);
			request.setAttribute("viewUrl", "/MemberUpdateForm.jsp");
			
		} catch (Exception e) {
			throw new ServletException(e);
			
		} finally {
			
		}
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		System.out.println("/member/update _doPost");
		
		try {
			
			ServletContext sc=this.getServletContext();
			MemberDao memberDao=(MemberDao)sc.getAttribute("memberDao");
			
			Member member=new Member()
										.setEmail(request.getParameter("email"))
										.setName(request.getParameter("name"))
										.setNumber(request.getParameter("number"))
										.setPassword(request.getParameter("password"));
			
			int result = memberDao.update(member);
			
			if(result==1)
				response.sendRedirect("list.do");
			
		} catch (Exception e) {
			throw new ServletException (e);
			
		} finally {
			
		}
	
	}

}
