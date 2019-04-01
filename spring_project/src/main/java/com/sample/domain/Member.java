package com.sample.domain;

import java.util.Date;

public class Member {
	
	String id;
	String name;
	Date joined;
	
	public Member() {
	}
	
	public Member(String id, String name) {
		this.id = id;
		this.name = name;
	}
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Date getJoined() {
		return joined;
	}
	public void setJoined(Date joined) {
		this.joined = joined;
	}
	
	

}
