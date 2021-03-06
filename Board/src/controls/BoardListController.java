package controls;

import java.util.Map;

import DataBind.DataBinding;
import annotation.Component;
import dao.MySqlBoardDao;
import dao.MySqlCommentDao;

@Component("/list.go")
public class BoardListController implements Controller, DataBinding {

	MySqlBoardDao boardDao;
	MySqlCommentDao commentDao;
	
	public BoardListController setBoardDao(MySqlBoardDao boardDao) {
		this.boardDao=boardDao;
		return this;
	}
	
	public BoardListController setCommentDao (MySqlCommentDao commentDao) {
		this.commentDao=commentDao;
		return this;
	}
	
	@Override
	public String execute(Map<String,Object> model) throws Exception {
		Integer currentPage = (Integer)model.get("currentPage");
		if(currentPage==null) currentPage=1;
		int maxPage=((boardDao.dataCount()-1)/10)+1;
		//int firstWrite=boardDao.dataCount()-(currentPage-1)*10;
		model.put("maxPage",maxPage);
		System.out.println("maxPage="+maxPage);
		/*
		for(int i=0;i<10;i++) {
			int wno=firstWrite-i;
			model.put("commentCount",commentDao.countComment(wno));			
		}
		*/
		model.put("writings", boardDao.selectList((currentPage-1)*10));
		
		return "/board/BoardList.jsp";
	}

	@Override
	public Object[] getDataBinders() {
		return new Object[]{"currentPage", Integer.class};
	}
}