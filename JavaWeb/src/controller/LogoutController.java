package controller;

import java.util.Map;

public class LogoutController implements Controller{
	
	@Override
	public String execute(Map<String, Object> model) throws Exception {
		return "/member/LoginForm.jsp";
	}

}
