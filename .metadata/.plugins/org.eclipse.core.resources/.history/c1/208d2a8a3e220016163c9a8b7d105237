package spms.controls;

import java.util.Map;

import spms.annotation.Component;
import spms.bind.DataBinding;
import spms.dao.MySqlMemberDao;
import spms.vo.Member;

@Component("/member/update.do")
public class MemberUpdateController implements Controller, DataBinding {
	
	MySqlMemberDao memberDao;
	
	public MemberUpdateController setMemberDao(MySqlMemberDao memberDao) {
		this.memberDao=memberDao;
		return this;
	}
	
	@Override
	public String execute(Map<String, Object> model) throws Exception {
    
		Member member=(Member)model.get("member");
		if (member.getEmail() == null) { 
			Integer no = (Integer)model.get("no");
			member = memberDao.selectOne(no);
			model.put("member", member);
			return "/member/MemberUpdateForm.jsp";

		} else { 
			member = (Member)model.get("member");
			memberDao.update(member);
			return "redirect:list.do";
		}
	}

	@Override
	public Object[] getDataBinders() {
		return new Object[]{"no",Integer.class,
							"member", spms.vo.Member.class};
	}
}
