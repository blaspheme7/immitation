package spms.controls;

import java.util.Map;

import spms.annotation.Component;
import spms.dao.MySqlMemberDao;

@Component("/member/list.do")
public class MemberListController implements Controller {
	MySqlMemberDao memberDao;
	
	public MemberListController setMemberDao(MySqlMemberDao memberDao) {
		this.memberDao=memberDao;
		return this;
	}
	
	@Override
	public String execute(Map<String, Object> model) throws Exception {
	  
	System.out.println("MemberListController_execute");
    model.put("members", memberDao.selectList());
    System.out.println("memberDao.selectList() = "+memberDao.selectList());
    
    return "MemberList.jsp";
  }
}
