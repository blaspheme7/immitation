package controls;

import java.util.Map;

import DataBind.DataBinding;
import annotation.Component;
import dao.MySqlBoardDao;
import vo.Writing;

@Component("/modify.go")
public class WritingModifyController implements Controller, DataBinding {
	
	MySqlBoardDao boardDao;
	
	public WritingModifyController setProjectDao(MySqlBoardDao boardDao) {
		this.boardDao=boardDao;
		return this;
	}
	
	@Override
	public String execute(Map<String, Object> model) throws Exception {
    
		Writing writing=(Writing)model.get("writing");
		if (writing.getTitle() == null) { 
			Integer no = (Integer)model.get("no");
			writing = boardDao.selectOne(no);
			model.put("writing", writing);
			return "/board/UpdateWriting.jsp";

		} else { 
			boardDao.update(writing);
			return "redirect:list.go";
		}
	}

	@Override
	public Object[] getDataBinders() {
		return new Object[]{"no",Integer.class,
							"writing", vo.Writing.class};
	}
}
