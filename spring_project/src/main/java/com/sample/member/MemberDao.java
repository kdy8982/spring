package com.sample.member;

import java.util.List;

import com.sample.domain.LoginDTO;
import com.sample.domain.Member;

public interface MemberDao {	

	void add (Member member);
	List<Member> list();
	int getCount();
	void deleteAll();
	Member login(LoginDTO loginDTO);
	
	
}
