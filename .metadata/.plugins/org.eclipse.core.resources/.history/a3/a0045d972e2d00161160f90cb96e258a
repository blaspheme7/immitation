package controls;

import java.util.Map;

import annotation.Component;
import DataBind.DataBinding;
import dao.MySqlBoardDao;

@Component("/view.go")
public class WritingViewController implements Controller, DataBinding {
	
	MySqlBoardDao boardDao;
	
	public WritingViewController setWritingDao(MySqlBoardDao boardDao) {
		this.boardDao=boardDao;
		return this;
	}
	
	@Override
	public String execute(Map<String, Object> model) throws Exception {
    
		Integer no = (Integer)model.get("no");
		boardDao.selectOne(no);
    
		return "redirect:list.do";
	}

	@Override
	public Object[] getDataBinders() {
		return new Object[]{"no", Integer.class};
	}
}
