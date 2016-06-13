package controls;

import java.util.Map;

import annotation.Component;
import DataBind.DataBinding;
import controls.Controller;
import dao.MySqlBoardDao;
import dao.MySqlCommentDao;
import vo.Comment;
import vo.Writing;

@Component("/addComment.go")
public class CommentAddController implements Controller, DataBinding {
	MySqlCommentDao commentDao;
	
	public CommentAddController setCommentDao(MySqlCommentDao commentDao) {
		this.commentDao=commentDao;
		return this;
	}
	
	public Object[] getDataBinders() {
		return new Object[]{"comment", vo.Comment.class};
	}
	
	@Override
	public String execute(Map<String, Object> model) throws Exception {
		
		Comment comment=(Comment)model.get("comment");
		commentDao.insert(comment);
		comment.getWno();
		String refresh="redirect:view.go?=no";
		return "redirect:list.go";
	}
}