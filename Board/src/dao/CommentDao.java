package dao;

import java.util.List;

import vo.Comment;

public interface CommentDao {
	
	List<Comment> selectList(int wno) throws Exception;
	int insert(Comment comment) throws Exception;
	int update(Comment comment) throws Exception;
	int delete(Comment comment) throws Exception;
	int countComment(int wno) throws Exception;
}
