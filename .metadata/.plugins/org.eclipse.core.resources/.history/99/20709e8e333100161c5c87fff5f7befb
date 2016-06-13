package controls;

import java.util.Map;

import DataBind.DataBinding;
import dao.MySqlBoardDao;
import dao.MySqlCommentDao;

public class CommentPrintController implements Controller, DataBinding {

	MySqlCommentDao commentDao;
	
	public CommentPrintController setCommentDao(MySqlCommentDao commentDao) {
		this.commentDao=commentDao;
		return this;
	}
	
	@Override
	public String execute(Map<String,Object> model) throws Exception {
		Integer wno = (Integer)model.get("wno");
		model.put("comments",commentDao.selectList(wno));
		return null;
	}

	@Override
	public Object[] getDataBinders() {
		return new Object[]{"wno", Integer.class};
	}
}