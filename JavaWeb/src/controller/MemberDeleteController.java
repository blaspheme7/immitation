package controller;

import java.util.Map;

import dao.MemberDao;
import vo.Member;

public class MemberDeleteController implements Controller{
	
	@Override
	public String execute(Map<String, Object> model) throws Exception {
		
		MemberDao memberDao=(MemberDao)model.get("memberDao");
		Member member=(Member)model.get("member");
		memberDao.delete(member);
		
		return "redirect:list.do";
	}

}
