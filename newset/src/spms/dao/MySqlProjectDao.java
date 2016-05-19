package spms.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.sql.DataSource;

import spms.annotation.Component;
import spms.vo.Project;

@Component("projectDao")
public class MySqlProjectDao implements ProjectDao {

	DataSource ds;
	
	public void setDataSource(DataSource ds) {
	    this.ds = ds;
	}
	
	public List<Project> selectList() throws Exception {
	    Connection connection = null;
	    Statement stmt = null;
	    ResultSet rs = null;
	    
	    try {
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
	  }

	public int insert(Project project) throws Exception {
		
		Connection connection = null;
	    PreparedStatement stmt = null;

	    try {
	      connection = ds.getConnection();
	      Date sta_date=project.getStartDate();
	      Date end_date=project.getEndDate();
	      
	      
	      stmt = connection.prepareStatement(
	          "INSERT INTO PROJECTS (TITLE,CONTENT,STA_DATE,END_DATE,TAGS)"
	              + " VALUES (?,?,?,?,?)");
	      stmt.setString(1, project.getTitle());
	      stmt.setString(2, project.getContent());
	      stmt.setDate(3, (java.sql.Date)sta_date);
	      stmt.setDate(4, (java.sql.Date) end_date);
	      stmt.setString(5, project.getTags());
	      //to_date(?,'yyyy-mm-dd')

	      return stmt.executeUpdate();

	    } catch (Exception e) {
	      throw e;

	    } finally {
	      try {if (stmt != null) stmt.close();} catch(Exception e) {}
	      try {if (connection != null) connection.close();} catch(Exception e) {}
	    }
	}
	
}