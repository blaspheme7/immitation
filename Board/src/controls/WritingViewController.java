package controls;

import java.util.ArrayList;
import java.util.Map;

import DataBind.DataBinding;
import annotation.Component;
import dao.MySqlBoardDao;
import dao.MySqlCommentDao;
import vo.Comment;
import vo.Writing;

@Component("/view.go")
public class WritingViewController implements Controller, DataBinding {
	
	MySqlBoardDao boardDao;
	MySqlCommentDao commentDao;
	
	public WritingViewController setWritingDao(MySqlBoardDao boardDao) {
		this.boardDao=boardDao;
		return this;
	}
	
	public WritingViewController setCommentDao(MySqlCommentDao commentDao) {
		this.commentDao=commentDao;
		return this;
	}
	
	@Override
	public String execute(Map<String, Object> model) throws Exception {
    
		Writing writing;
		Integer no=(Integer)model.get("no");
		writing=boardDao.selectOne(no);
		writing.setRefnum(writing.getRefnum()+1);
		boardDao.refnumUp(writing);
		model.put("writing", writing);
		model.put("comments",commentDao.selectList(no));
		return "/board/ViewWriting.jsp";
    
	}

	@Override
	public Object[] getDataBinders() {
		return new Object[]{"no", Integer.class,
							"writing", vo.Writing.class
		};
	}
}
