package vo;

import java.util.Date;

public class Comment {

	protected int wno;
	protected int cno;
	protected String writer;
	protected String content;
	protected String password;
	protected Date cre_date;
	
	public int getWno() {
		return wno;
	}
	public Comment setWno(int wno) {
		this.wno = wno;
		return this;
	}
	public int getCno() {
		return cno;
	}
	public Comment setCno(int cno) {
		this.cno = cno;
		return this;
	}
	public String getWriter() {
		return writer;
	}
	public Comment setWriter(String writer) {
		this.writer = writer;
		return this;
	}
	public String getContent() {
		return content;
	}
	public Comment setContent(String content) {
		this.content = content;
		return this;
	}
	public String getPassword() {
		return password;
	}
	public Comment setPassword(String password) {
		this.password = password;
		return this;
	}
	public Date getCre_date() {
		return cre_date;
	}
	public Comment setCre_date(Date cre_date) {
		this.cre_date = cre_date;
		return this;
	}
	
}
