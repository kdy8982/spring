package com.sample.domain;

import java.util.Date;

import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class Post {
	
	@Id
	int postId;
	
	@NotNull
	@Size(min=1, message="게시글 제목을 입력해주세요")
	String postTitle;
	
	Date postDatetime;
	
	@NotNull
	@Size(min=1, message="게시글 내용을 입력해주세요")
	String postContent;
	
	
	public int getPostId() {
		return postId;
	}

	public void setPostId(int postId) {
		this.postId = postId;
	}

	public String getPostTitle() {
		return postTitle;
	}

	public void setPostTitle(String postTitle) {
		this.postTitle = postTitle;
	}

	public Date getPostDatetime() {
		return postDatetime;
	}

	public void setPostDatetime(Date postDatetime) {
		this.postDatetime = postDatetime;
	}

	public String getPostContent() {
		return postContent;
	}

	public void setPostContent(String postContent) {
		this.postContent = postContent;
	}

	
}
