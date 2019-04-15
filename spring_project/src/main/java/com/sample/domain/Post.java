package com.sample.domain;

import java.text.DateFormat;
import java.util.Date;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
public class Post {
	
	@Id @GeneratedValue(strategy=GenerationType.AUTO)
	int id;
	
	@NotNull
	@Size(min=1, message="게시글 제목을 입력해주세요")
	String title;
	
	
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	Date datetime;
	
	@NotNull
	@Size(min=1, message="게시글 내용을 입력해주세요")
	String content;
	
	@NotNull
	int memberId;
	
	@NotNull
	String memberName;
	

	public int getMemberId() {
		return memberId;
	}

	public void setMemberId(int memberId) {
		this.memberId = memberId;
	}

	public String getMemberName() {
		return memberName;
	}

	public void setMemberName(String memberName) {
		this.memberName = memberName;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Date getDatetime() {
		return datetime;
	}

	public void setDatetime(Date datetime) {
		this.datetime = datetime;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	
}
