package kr.co.vo;

import java.util.Date;

public class StudyVO {
	private int sno;
	private String id;
	private String sname;
	private String title;
	private String content;
	private String mname;
	private String location;
	private Date totime;
	private Date fromtime;
	private Date sdate;
	public int getSno() {
		return sno;
	}
	public void setSno(int sno) {
		this.sno = sno;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getSname() {
		return sname;
	}
	public void setSname(String sname) {
		this.sname = sname;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getMname() {
		return mname;
	}
	public void setMname(String mname) {
		this.mname = mname;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public Date getTotime() {
		return totime;
	}
	public void setTotime(Date totime) {
		this.totime = totime;
	}
	public Date getFromtime() {
		return fromtime;
	}
	public void setFromtime(Date fromtime) {
		this.fromtime = fromtime;
	}
	public Date getSdate() {
		return sdate;
	}
	public void setSdate(Date sdate) {
		this.sdate = sdate;
	}
	@Override
	public String toString() {
		return "StudyVO [sno=" + sno + ", id=" + id + ", sname=" + sname + ", title=" + title + ", content=" + content
				+ ", mname=" + mname + ", location=" + location + ", totime=" + totime + ", fromtime=" + fromtime
				+ ", sdate=" + sdate + "]";
	}
	
	
	
	
}
