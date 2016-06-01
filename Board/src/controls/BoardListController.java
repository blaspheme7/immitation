package controls;

import java.util.Map;

import annotation.Component;
import DataBind.DataBinding;
import controls.Controller;
import controls.BoardListController;
import dao.BoardDao;

@Component("/list.do")
public class BoardListController implements Controller, DataBinding {

	BoardDao boardDao;
	
	public BoardListController setBoardDao(BoardDao boardDao) {
		this.boardDao=boardDao;
		return this;
	}
	
	@Override
	public String execute(Map<String,Object> model) throws Exception {
		model.put("projects", boardDao.selectList());
		return "/project/ProjectList.jsp";
	}

	@Override
	public Object[] getDataBinders() {
		return new Object[]{
				"orderCond", String.class
		};
	}
}