package dao;

import java.util.List;

import vo.Writing;

public interface BoardDao {
	
	List<Writing> selectList(int co) throws Exception;
	int insert(Writing writing) throws Exception;
	int update(Writing writing) throws Exception;
	Writing selectOne(int no) throws Exception;
	int refnumUp(Writing writing) throws Exception;
	int dataCount() throws Exception;
	int delete(int no) throws Exception;

}

