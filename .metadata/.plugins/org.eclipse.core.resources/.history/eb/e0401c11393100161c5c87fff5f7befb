package controls;

import java.util.Map;

import DataBind.DataBinding;
import annotation.Component;
import dao.MySqlBoardDao;

@Component("/list.do")
public class BoardListController implements Controller, DataBinding {

	MySqlBoardDao boardDao;
	
	public BoardListController setBoardDao(MySqlBoardDao boardDao) {
		this.boardDao=boardDao;
		return this;
	}
	
	@Override
	public String execute(Map<String,Object> model) throws Exception {
		Integer currentPage = (Integer)model.get("currentPage");
		int maxPage=((boardDao.dataCount()-1)/10)+1;
		model.put("maxPage",maxPage);
		System.out.println("maxPage="+maxPage);
		if(currentPage==null){
			model.put("currentPage", 1);
			model.put("writings", boardDao.selectList(0));
		} else {
			model.put("writings", boardDao.selectList((currentPage-1)*10));
		}
		return "/board/BoardList.jsp";
	}

	@Override
	public Object[] getDataBinders() {
		return new Object[]{"currentPage", Integer.class};
	}
}