package spms.dao;

import java.util.HashMap;
import java.util.Hashtable;
import java.util.List;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import spms.annotation.Component;
import spms.vo.Project;

@Component("projectDao")
public class MySqlProjectDao implements ProjectDao {
	
	SqlSessionFactory sqlSessionFactory;
	
	public void setSqlSessionFactory(SqlSessionFactory sqlSessionFactory) {
		this.sqlSessionFactory=sqlSessionFactory;
	}

	DataSource ds;
	
	public void setDataSource(DataSource ds) {
	    this.ds = ds;
	}
	
	public List<Project> selectList(HashMap<String,Object> paramMap) throws Exception {
	    //Connection connection = null;
	    //Statement stmt = null;
	    //ResultSet rs = null;
		
		SqlSession sqlSession=sqlSessionFactory.openSession();
			    
	    try {
	    	/*
	      connection = ds.getConnection();
	      stmt = connection.createStatement();
	      rs = stmt.executeQuery("SELECT PNO,PNAME,STA_DATE,END_DATE,STATE FROM PROJECTS ORDER BY PNO ASC");

	      ArrayList<Project> projects = new ArrayList<Project>();

	      while(rs.next()) {
	        projects.add(new Project()
	        .setNo(rs.getInt("PNO"))
	        .setTitle(rs.getString("PNAME"))
	        .setStartDate(rs.getDate("STA_DATE"))
	        .setEndDate(rs.getDate("END_DATE"))
	        .setState(rs.getInt("STATE")));
	      }

	      return projects;

	    } catch (Exception e) {
	      throw e;

	    } finally {
	      try {if (rs != null) rs.close();} catch(Exception e) {}
	      try {if (stmt != null) stmt.close();} catch(Exception e) {}
	      try {if (connection != null) connection.close();} catch(Exception e) {}
	    }
	    */
	    	return sqlSession.selectList("spms.dao.ProjectDao.selectList",paramMap);
	    } finally {
	    	sqlSession.close();
	    }
	  }

	public int insert(Project project) throws Exception {
		//java.util.date -> java.sql.date
		//Connection connection = null;
	    //PreparedStatement pstmt = null;
	    SqlSession sqlSession=sqlSessionFactory.openSession();
	    try {
	    	/*
	      connection = ds.getConnection();
	      
	      
	      pstmt = connection.prepareStatement(
	          "INSERT INTO PROJECTS (PNAME,CONTENT,STA_DATE,END_DATE,STATE,CRE_DATE,TAGS)"
	              + " VALUES (?,?,?,?,0,NOW(),?)");
	      pstmt.setString(1, project.getTitle());
	      pstmt.setString(2, project.getContent());
	      pstmt.setDate(3, project.getStartDate());
	      pstmt.setDate(4, project.getEndDate());
	      pstmt.setString(5, project.getTags());

	      return pstmt.executeUpdate();

	    } catch (Exception e) {
	      throw e;

	    } finally {
	      try {if (pstmt != null) pstmt.close();} catch(Exception e) {}
	      try {if (connection != null) connection.close();} catch(Exception e) {}
	    }
	    */
	    	int count=sqlSession.insert("spms.dao.ProjectDao.insert", project);
	    	sqlSession.commit();
	    	return count;
	    } finally {
	    	sqlSession.close();
	    }
	}

	@Override
	public int update(Project project) throws Exception { 
	    //Connection connection = null;
	    //PreparedStatement stmt = null;
		SqlSession sqlSession=sqlSessionFactory.openSession();
		
	    try {
	    	
	    	Project original=sqlSession.selectOne("spms.dao.ProjectDao.selectOne",project.getNo());
	    	
	    	Hashtable<String,Object> paramMap=new Hashtable<String,Object>();
	    	if(!project.getTitle().equals(original.getTitle()))
	    		paramMap.put("title", project.getTitle());
	    	if(!project.getContent().equals(original.getContent()))
	    		paramMap.put("content", project.getContent());
	    	if(project.getStartDate().compareTo(original.getStartDate())!=0)
	    		paramMap.put("startDate", project.getStartDate());
	    	if(project.getEndDate().compareTo(original.getEndDate())!=0)
	    		paramMap.put("startDate", project.getEndDate());
	    	if(project.getState()!=original.getState())
	    		paramMap.put("state", project.getState());
	    	if(!project.getTags().equals(original.getTags()))
	    		paramMap.put("tags", project.getTags());
	    	
	    	if(paramMap.size()>0) {
	    		
	    		paramMap.put("no", project.getNo());
	    		int count=sqlSession.update("spms.dao.ProjectDao.update", paramMap);
	    		sqlSession.commit();
	    		return count;
	    		
	    	} else { return 0; }
	    	
	    	
	    	
	    	//int count=Integer.valueOf(sqlSession.update("spms.dao.ProjectDao.update", project));
	    	//int count=sqlSession.update("spms.dao.ProjectDao.update", project);
	    	
	    	
	    	
	    	/*
		      connection = ds.getConnection();
		      stmt = connection.prepareStatement(
		          "UPDATE PROJECTS SET PNAME=?,CONTENT=?,STA_DATE=?,END_DATE=?,STATE=?,TAGS=?"
		              + " WHERE PNO=?");
		      stmt.setString(1, project.getTitle());
		      stmt.setString(2, project.getContent());
		      stmt.setDate(3, new java.sql.Date(project.getStartDate().getTime()));
		      stmt.setDate(4, new java.sql.Date(project.getEndDate().getTime()));
		      stmt.setInt(5, project.getState());
		      stmt.setString(6, project.getTags());
		      stmt.setInt(7, project.getNo());
		      return stmt.executeUpdate();

		    } catch (Exception e) {
		      throw e;

		    } finally {
		      try {if (stmt != null) stmt.close();} catch(Exception e) {}
		      try {if (connection != null) connection.close();} catch(Exception e) {}
		    }
		    */
	    } finally {
	    	sqlSession.close();
	    }
	  }
	
	
	@SuppressWarnings("null")
	@Override
	public Project selectOne(int no) throws Exception {
		//Connection connection=null;
		//Statement stmt=null;
		//ResultSet rs=null;
		//Project project=null;
		SqlSession sqlSession=sqlSessionFactory.openSession();
		
		try {
			/*
			connection=ds.getConnection();
			
			stmt = connection.createStatement();
		    rs = stmt.executeQuery("SELECT PNO,PNAME,CONTENT,STA_DATE,END_DATE,STATE,CRE_DATE,TAGS FROM PROJECTS WHERE PNO="+no);
		    
		    if(rs.next()) {
		    	project=new Project().setNo(rs.getInt("PNO"))
		    						.setTitle(rs.getString("PNAME"))
		    						.setContent(rs.getString("CONTENT"))
		    						.setStartDate(rs.getDate("STA_DATE"))
		    						.setEndDate(rs.getDate("END_DATE"))
		    						.setCreatedDate(rs.getDate("CRE_DATE"))
		    						.setTags(rs.getString("TAGS"));
		    	System.out.println(rs.getString("CONTENT"));
		    	
		    } else { throw new Exception("해당 번호의 프로젝트를 찾을 수 없습니다."); }
			
					
		} catch (Exception e) {
			throw e;
		} finally {
			try {if (stmt != null) stmt.close();} catch(Exception e) {}
		    try {if (connection != null) connection.close();} catch(Exception e) {}
		}
		
		return project;
		*/
			return sqlSession.selectOne("spms.dao.ProjectDao.selectOne", no); 
		} finally {
			sqlSession.close();
		}
	}
	
	public int delete(int no) throws Exception {
		SqlSession sqlSession=sqlSessionFactory.openSession();
		try {
			int count=sqlSession.delete("spms.dao.ProjectDao.delete", no);
			sqlSession.commit();
			return count;
		} finally {
			sqlSession.close();
		}
	}
}
