package com.sample.member;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.ibatis.SqlMapClientTemplate;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.sample.domain.LoginDTO;
import com.sample.domain.Member;

@Repository
// @Component
public class MemberDaoIbatis implements MemberDao{
	
	@Autowired SqlMapClientTemplate sqlMapClientTemplate;
	
	@Override
	public List<Member> list() {
		return sqlMapClientTemplate.queryForList("Member.list");
	}

	@Override
	public void add(Member member) {
		member.setId((int)System.currentTimeMillis());
		sqlMapClientTemplate.insert("Member.add", member);
	}

	@Override
	public int getCount() {
		return (int) sqlMapClientTemplate.queryForObject("Member.getCount");
	}

	@Override
	public void deleteAll() {
		sqlMapClientTemplate.delete("Member.deleteAll");
	}

	@Override
	public Member login(LoginDTO loginDTO) {
		return (Member) sqlMapClientTemplate.queryForObject("Member.login", loginDTO);
	}

}
