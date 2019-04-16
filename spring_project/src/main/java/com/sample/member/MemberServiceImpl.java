package com.sample.member;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.sample.domain.LoginDTO;
import com.sample.domain.Member;

@Service("memberService")
public class MemberServiceImpl implements MemberService {

	@Autowired
	MemberDao memberDao;
	
	@Override
	public List<Member> list() {
		return memberDao.list();
	}

	@Override
	public void add(Member member) {
		member.setJoined(new Date());
		memberDao.add(member);		
	}

	@Override
	public Member login(LoginDTO loginDTO) throws Exception {
		return memberDao.login(loginDTO);
	}

}
