package controls;

import java.util.Map;

import annotation.Component;
import DataBind.DataBinding;
import controls.Controller;
import dao.MySqlBoardDao;
import vo.Writing;

@Component("/write.go")
public class NewWritingController implements Controller, DataBinding {
	MySqlBoardDao boardDao;
	
	public NewWritingController setBoardDao(MySqlBoardDao boardDao) {
		this.boardDao=boardDao;
		return this;
	}
	
	public Object[] getDataBinders() {
		return new Object[]{"writing", vo.Writing.class};
	}
	
	@Override
	public String execute(Map<String, Object> model) throws Exception {
		
		Writing writing=(Writing)model.get("writing");
		System.out.println("writing.getName()= "+writing.getName());
		
		if(writing.getTitle()==null || writing.getTitle().length()<3)
			return "/board/NewWriting.jsp";
		else {
			boardDao.insert(writing);
			return "redirect:list.go";
		}
	}
}