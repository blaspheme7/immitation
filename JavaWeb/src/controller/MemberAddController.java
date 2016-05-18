package controller;

import java.util.Map;

import dao.MemberDao;
import vo.Member;

public class MemberAddController implements Controller {
	
	@Override
	public String execute(Map<String, Object> model) throws Exception {
		
		if(model.get("member")==null) return "/member/MemberAddForm.jsp";
		else {
			MemberDao memberDao=(MemberDao)model.get("memberDao");
			Member member=(Member)model.get("member");
			memberDao.add(member);
			
			return "redirect:list.do";
		}
	}

}
