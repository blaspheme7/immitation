package dao;

import java.util.List;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import annotation.Component;
import vo.Comment;

@Component("CommentDao")
public class MySqlCommentDao implements CommentDao {

SqlSessionFactory sqlSessionFactory;
	
	public void setSqlSessionFactory(SqlSessionFactory sqlSessionFactory) {
		this.sqlSessionFactory=sqlSessionFactory;
	}

	DataSource ds;
	
	public void setDataSource(DataSource ds) {
	    this.ds = ds;
	}

	@Override
	public List<Comment> selectList(int wno) throws Exception {
		SqlSession sqlSession=sqlSessionFactory.openSession();
			    
	    try {
	    	return sqlSession.selectList("dao.CommentDao.selectList",wno);
	    } finally {
	    	sqlSession.close();
	    }
	}

	@Override
	public int insert(Comment comment) throws Exception {
	    SqlSession sqlSession=sqlSessionFactory.openSession();
	    try {
	    	int count=sqlSession.insert("dao.CommentDao.insert", comment);
	    	sqlSession.commit();
	    	return count;
	    } finally {
	    	sqlSession.close();
	    }
	}

	@Override
	public int update(Comment comment) throws Exception {
		SqlSession sqlSession=sqlSessionFactory.openSession();
		
	    try {
	    	int count=sqlSession.update("dao.CommentDao.update", comment);
	    	sqlSession.commit();
	    	return count;
	    } finally {
	    	sqlSession.close();
	    }
	}

	@Override
	public int delete(Comment comment) throws Exception {
		SqlSession sqlSession=sqlSessionFactory.openSession();
		
	    try {
	    	int count=sqlSession.delete("dao.CommentDao.delete", comment);
	    	sqlSession.commit();
	    	return count;
	    } finally {
	    	sqlSession.close();
	    }
	}
}
