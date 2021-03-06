package vo;

import java.util.Date;

public class Writing {
	
	protected int refnum;
	protected int no;
	protected String name;
	protected String title;
	protected String content;
	protected Date createdDate;
	public int commentCount=0;
	
	public int getCommentCount() {
		return commentCount;
	}
	public Writing setCommentCount(int commentCount) {
		this.commentCount = commentCount;
		return this;
	}
	public int getRefnum() {
		return refnum;
	}
	public Writing setRefnum(int refnum) {
		this.refnum = refnum;
		return this;
	}
	public int getNo() {
		return no;
	}
	public Writing setNo(int no) {
		this.no = no;
		return this;
	}
	public String getName() {
		return name;
	}
	public Writing setName(String name) {
		this.name = name;
		return this;
	}
	public String getTitle() {
		return title;
	}
	public Writing setTitle(String title) {
		this.title = title;
		return this;
	}
	public String getContent() {
		return content;
	}
	public Writing setContent(String content) {
		this.content = content;
		return this;
	}
	public Date getCreatedDate() {
		return createdDate;
	}
	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}
}
