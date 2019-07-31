package com.wwj.model;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;


public class Student {

	private int sid;
	private String sname;
	private Date bir;

	public int getSid() {
		return sid;
	}

	public void setSid(int sid) {
		this.sid = sid;
	}

	public String getSname() {
		return sname;
	}

	public void setSname(String sname) {
		this.sname = sname;
	}

	@DateTimeFormat(pattern="yyyy-MM-dd")
	public Date getBir() {
		return bir;
	}

	public void setBir(Date bir) {
		this.bir = bir;
	}

}
