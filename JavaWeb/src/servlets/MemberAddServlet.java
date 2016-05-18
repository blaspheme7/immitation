package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.MemberDao;
import vo.Member;


@WebServlet("/member/add")
public class MemberAddServlet extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		System.out.println("/member/add _doGet");
		request.setAttribute("viewUrl", "/MemberAddForm.jsp");
		System.out.println("complete");
		
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		System.out.println("/member/add _doPost");
		request.setCharacterEncoding("utf-8");
		
		
		try {
			
			ServletContext sc=this.getServletContext();
			MemberDao memberDao=(MemberDao) sc.getAttribute("memberDao");
			Member member=(Member)request.getAttribute("member");
			memberDao.add(member);
			request.setAttribute("viewUrl", "redirect:list.do");
			
		} catch (Exception e) {
			throw new ServletException (e);
			
		} finally {
			
		}
	}
}
