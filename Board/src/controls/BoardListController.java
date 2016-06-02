package controls;

import java.util.List;
import java.util.Map;

import annotation.Component;
import dao.MySqlBoardDao;
import vo.Writing;

@Component("/list.do")
public class BoardListController implements Controller {

	MySqlBoardDao boardDao;
	
	public BoardListController setBoardDao(MySqlBoardDao boardDao) {
		this.boardDao=boardDao;
		return this;
	}
	
	@Override
	public String execute(Map<String,Object> model) throws Exception {
		model.put("writings", boardDao.selectList());
		List<Writing> list=boardDao.selectList();
		System.out.println(list.size());
		return "/board/BoardList.jsp";
	}

}
