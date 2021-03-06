package servlets;

import java.io.IOException;
import java.util.HashMap;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DataBind.DataBinding;
import DataBind.ServletRequestDataBinder;
import context.ApplicationContext;
import controls.Controller;
import listener.ContextLoaderListener;


@SuppressWarnings("serial")
@WebServlet("*.go")
public class DispatcherServlet extends HttpServlet {
	
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html; charset=UTF-8");
		String servletPath = request.getServletPath();
		try {
			
			ApplicationContext ctx=ContextLoaderListener.getApplicationContext();
			RequestDispatcher rd=request.getRequestDispatcher("/Header.jsp");
			//rd.include(request, response);
	  
			HashMap<String,Object> model = new HashMap<String,Object>();
			model.put("session", request.getSession());
			
			Controller pageController=(Controller)ctx.getBean(servletPath);
			System.out.println("pageController="+pageController);
			if(pageController==null) throw new Exception("요청한 서비스를 찾을 수 없습니다.");
			
			if(pageController instanceof DataBinding) {
				prepareRequestData(request, model, (DataBinding)pageController);
			}
			
			System.out.println(model);
			String viewUrl = pageController.execute(model);
      
			for (String key : model.keySet()) {
				request.setAttribute(key, model.get(key));
			}
      
			if (viewUrl.startsWith("redirect:")) {
				response.sendRedirect(viewUrl.substring(9));
				return;
			} else {
				rd = request.getRequestDispatcher(viewUrl);
				System.out.println("model.get(maxPage)="+model.get("maxPage"));
				
				rd.include(request, response);
				rd=request.getRequestDispatcher("/Tail.jsp");
				//rd.include(request, response);
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