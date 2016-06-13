package controls;

import java.util.Map;

import annotation.Component;
import DataBind.DataBinding;
import dao.MySqlBoardDao;
import vo.Writing;

@Component("/view.go")
public class WritingViewController implements Controller, DataBinding {
	
	MySqlBoardDao boardDao;
	
	public WritingViewController setWritingDao(MySqlBoardDao boardDao) {
		this.boardDao=boardDao;
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
		return "/board/ViewWriting.jsp";
    
	}

	@Override
	public Object[] getDataBinders() {
		return new Object[]{"no", Integer.class,
							"writing", vo.Writing.class
		};
	}
}
