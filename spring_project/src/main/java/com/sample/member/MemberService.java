package com.sample.member;

import java.util.List;

import com.sample.domain.LoginDTO;
import com.sample.domain.Member;

public interface MemberService {
	List<Member> list();
	void add(Member member);
	Member login(LoginDTO loginDTO) throws Exception;
}
