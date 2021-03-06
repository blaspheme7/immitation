package spms.controls;

import java.util.Map;

import spms.annotation.Component;
import spms.dao.MySqlMemberDao;

@Component("/member/list2.do")
public class MemberListDescController implements Controller {
	MySqlMemberDao memberDao;
	
	public MemberListDescController setMemberDao(MySqlMemberDao memberDao) {
		this.memberDao=memberDao;
		return this;
	}
	
	@Override
	public String execute(Map<String, Object> model) throws Exception {
	  
	System.out.println("MemberListDescController_execute");
    
    // 회원 목록 데이터를 Map 객체에 저장한다.
    model.put("members", memberDao.selectListDesc());
    
    // 화면을 출력할 페이지의 URL을 반환한다.
    return "MemberList.jsp";
  }
}
