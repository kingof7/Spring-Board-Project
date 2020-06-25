package kr.co.vo;

import java.util.Date;

public class StudyMemberVO {
	private int sno;
	private String name;
	private String id;
	private Date gdate;
	public int getSno() {
		return sno;
	}
	public void setSno(int sno) {
		this.sno = sno;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public Date getGdate() {
		return gdate;
	}
	public void setGdate(Date gdate) {
		this.gdate = gdate;
	}
	@Override
	public String toString() {
		return "StudyMemberVO [sno=" + sno + ", name=" + name + ", id=" + id + ", gdate=" + gdate + "]";
	}
	
	
	
	

}
