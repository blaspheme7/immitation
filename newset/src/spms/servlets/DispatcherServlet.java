package spms.servlets;

import java.io.IOException;
import java.util.HashMap;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import spms.bind.DataBinding;
import spms.bind.ServletRequestDataBinder;
import spms.context.ApplicationContext;
import spms.controls.Controller;
import spms.listeners.ContextLoaderListener;

// Controller 규칙에 따라 페이지 컨트롤러를 호출
@SuppressWarnings("serial")
@WebServlet("*.do")
public class DispatcherServlet extends HttpServlet {
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html; charset=UTF-8");
		String servletPath = request.getServletPath();
		try {
			//ServletContext sc = this.getServletContext();
			ApplicationContext ctx=ContextLoaderListener.getApplicationContext();
			System.out.println("ctx="+ctx);
			RequestDispatcher rd=request.getRequestDispatcher("/Header.jsp");
			rd.include(request, response);
	  
	  // 페이지 컨트롤러에게 전달할 Map 객체를 준비한다. 
			HashMap<String,Object> model = new HashMap<String,Object>();
	  //model.put("memberDao", sc.getAttribute("memberDao"));
			model.put("session", request.getSession());
	  
			System.out.println("servletPath="+servletPath);
			//Controller pageController = (Controller)sc.getAttribute(servletPath);
			Controller pageController=(Controller)ctx.getBean(servletPath);
			System.out.println("pageController="+pageController);
			if(pageController==null) throw new Exception("요청한 서비스를 찾을 수 없습니다.");
			
			System.out.println("dp.45 "+model);
			
			if(pageController instanceof DataBinding) {
		  
				prepareRequestData(request, model, (DataBinding)pageController);
			}
			System.out.println("prepareRequestData, model="+model);
			String viewUrl = pageController.execute(model);
			System.out.println("viewUrl="+viewUrl);
      
      // Map 객체에 저장된 값을 ServletRequest에 복사한다.
			for (String key : model.keySet()) {
				request.setAttribute(key, model.get(key));
			}
      
			if (viewUrl.startsWith("redirect:")) {
				response.sendRedirect(viewUrl.substring(9));
				return;
			} else {
				rd = request.getRequestDispatcher(viewUrl);
				rd.include(request, response);
				rd=request.getRequestDispatcher("/Tail.jsp");
				rd.include(request, response);
			}
      
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("error", e);
			RequestDispatcher rd = request.getRequestDispatcher("/Error.jsp");
			rd.forward(request, response);
		}
	}
  
	private void prepareRequestData(HttpServletRequest request, HashMap<String, Object> model, DataBinding dataBinding) throws Exception {
	  
		Object[] dataBinders=dataBinding.getDataBinders();
		String dataName=null;
		Class<?> dataType=null;
		Object dataObj=null;
	  
		for(int i=0 ; i<dataBinders.length ; i+=2) {
			dataName=(String)dataBinders[i];
			dataType=(Class<?>)dataBinders[i+1];
			dataObj=ServletRequestDataBinder.bind(request,dataType,dataName);
			model.put(dataName, dataObj);
		}
	}
}