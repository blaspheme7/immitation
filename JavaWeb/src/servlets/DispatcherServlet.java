package servlets;

import java.io.IOException;
import java.util.HashMap;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.Controller;
import controller.LoginController;
import controller.LogoutController;
import controller.MemberAddController;
import controller.MemberDeleteController;
import controller.MemberListController;
import controller.MemberUpdateController;
import vo.Member;

@WebServlet("*.do")
public class DispatcherServlet extends HttpServlet {
	
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		System.out.println("DispatcherServlet");
		response.setContentType("text/html; charset=utf-8");
		String servletPath=request.getServletPath();
		
		try {
			ServletContext sc=this.getServletContext();
			System.out.println(request.getParameter("email")+request.getParameter("password"));
			HashMap<String, Object> model=new HashMap<String, Object>();
			model.put("memberDao", sc.getAttribute("memberDao"));
			
			Controller pageController=null;
			
			if("/member/list.do".equals(servletPath)) {
				
				pageController=new MemberListController();
				
			} else if ("/member/add.do".equals(servletPath)) {
				
				pageController=new MemberAddController();
				
				if(request.getParameter("email")!=null) {
					
					model.put("member", new Member().setNumber(request.getParameter("number"))
													.setEmail(request.getParameter("email"))
													.setPassword(request.getParameter("password"))
													.setName(request.getParameter("name")));
				} 
				
			} else if ("/member/update.do".equals(servletPath)) {
				
				pageController=new MemberUpdateController();
				
				if(request.getParameter("name")!=null) {
					
					model.put("member", new Member().setNumber(request.getParameter("number"))
													.setEmail(request.getParameter("email"))
													.setPassword(request.getParameter("password"))
													.setName(request.getParameter("name")));
					model.put("name", request.getParameter("name"));
				}
			} else if("/member/delete.do".equals(servletPath)) {
				model.put("member", new Member().setNumber(request.getParameter("number"))
												.setEmail(request.getParameter("email"))
												.setPassword(request.getParameter("password"))
												.setName(request.getParameter("name")));
				pageController=new MemberDeleteController();
				
			} else if("/member/login.do".equals(servletPath)) {
				pageController=new LoginController();
			} else if("/member/logout.do".equals(servletPath)) {
				pageController=new LogoutController();
			}
			
			//RequestDispatcher rd=request.getRequestDispatcher(pageControllerPath);
			//rd.include(request, response);
			
			String viewUrl=pageController.execute(model);
			
			for(String key : model.keySet()) request.setAttribute(key, model.get(key));
						
			if(viewUrl.startsWith("redirect:")) {
				
				response.sendRedirect(viewUrl.substring(9));
				return;
				
			} else {
				
				RequestDispatcher rd=request.getRequestDispatcher(viewUrl);
				rd.include(request, response);
				
			}
			
		} catch (Exception e) {
			
			e.printStackTrace();
			request.setAttribute("error", e);
			RequestDispatcher rd=request.getRequestDispatcher("/Error.jsp");
			rd.forward(request, response);
			
		}
	}
}