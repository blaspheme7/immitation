package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import vo.Member;


public class MemberDao {
	
	DataSource ds;
	
	public void setDataSource(DataSource ds) {
		
		this.ds=ds;
	}
	
	public Member checkUser(String email, String password) {
		Connection connection=null;
		PreparedStatement stmt=null;
		ResultSet rs=null;
		Member member=new Member();
		try {
			connection=ds.getConnection();
			stmt = connection.prepareStatement("select email,name from member where email=? and password=?");
			stmt.setString(1, email);
			stmt.setString(2, password);
			rs=stmt.executeQuery();

			if(rs.next()) {
				member.setName(rs.getString("name"));
				return member;	
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try { if(rs!=null) rs.close();} catch(Exception e) {}
			try { if(stmt!=null) stmt.close();} catch(Exception e) {}
			try { if(connection!=null) connection.close();} catch(Exception e) {}
		}
		return null;
	}
	
	public int add(Member member) throws Exception {
		
		Connection connection=null;
		PreparedStatement pstmt = null;

		try {
			connection=ds.getConnection();
			pstmt = connection.prepareStatement("insert into member(name,email,number,password) values (?,?,?,?)");
			pstmt.setString(1, member.getName());
			pstmt.setString(2, member.getEmail());
			pstmt.setString(3, member.getNumber());
			pstmt.setString(4, member.getPassword());
			pstmt.executeUpdate();

			return 1;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try { if(pstmt!=null) pstmt.close();} catch(Exception e) {}
			try { if(connection!=null) connection.close();} catch(Exception e) {}
		}

		return (Integer) null;
		
	}
	
	public Member search(String email) throws Exception {			//search
		
		Connection connection=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		Member member=new Member();
		
		try {
			connection=ds.getConnection();
			pstmt=connection.prepareStatement("select * from member where email=?");
			pstmt.setString(1, email);
			rs=pstmt.executeQuery();
			
			if(rs.next()) {
				member.setName(rs.getString("name"))
						.setNumber(rs.getString("number"))
						.setPassword(rs.getString("password"))
						.setEmail(rs.getString("email"));
				return member;
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try { if(rs!=null) rs.close();} catch(Exception e) {}
			try { if(pstmt!=null) pstmt.close();} catch(Exception e) {}
			try { if(connection!=null) connection.close();} catch(Exception e) {}
		}
		return null;
	}

	public int update(Member member) throws Exception {			//update

		Connection connection=null;
		PreparedStatement pstmt = null;

		try {
			connection=ds.getConnection();
			pstmt = connection.prepareStatement("update member set name=?,number=?,password=? where email=?");
			pstmt.setString(1, member.getName());
			pstmt.setString(2, member.getNumber());
			pstmt.setString(3, member.getPassword());
			pstmt.setString(4, member.getEmail());
			pstmt.executeUpdate();

			return 1;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try { if(pstmt!=null) pstmt.close();} catch(Exception e) {}
			try { if(connection!=null) connection.close();} catch(Exception e) {}
		}

		return (Integer) null;
	}
	
	public int delete(Member member) throws Exception {			//delete
		
		System.out.println("dao.delete");
		Connection connection=null;
		PreparedStatement pstmt=null;
		
		try {
			connection=ds.getConnection();
			pstmt=connection.prepareStatement("delete from member where email=?");
			pstmt.setString(1, member.getEmail());
			pstmt.executeUpdate();
			return 1;
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try { if(pstmt!=null) pstmt.close();} catch(Exception e) {}
			try { if(connection!=null) connection.close();} catch(Exception e) {}
		}
		
		return (Integer) null;
	}

	public List<Member> selectList() throws Exception {			//list
		
		Connection connection=null;		
		Statement stmt=null;
		ResultSet rs=null;
		
		try {
			connection=ds.getConnection();
			stmt=connection.createStatement();
			rs=stmt.executeQuery("select name,email,number,password from member");
			ArrayList<Member> members = new ArrayList<Member>();
			
			while(rs.next()) {
				members.add(new Member().setName(rs.getString("name"))
							.setEmail(rs.getString("email"))
							.setNumber(rs.getString("number"))
							.setPassword(rs.getString("password")));
			}
			
			return members;
			
		} catch (Exception e) {
			throw e;

		} finally {
			
			try { if(rs!=null) rs.close();} catch(Exception e) {}
			try { if(stmt!=null) stmt.close();} catch(Exception e) {}
			try { if(connection!=null) connection.close(); } catch(Exception e) {} 
		}	
	}
}
