package com.sample.member;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.sample.domain.Member;


@Controller
@RequestMapping("/member")
public class MemberContoroller {

	@Autowired
	MemberService memberService;
	
	@RequestMapping("/list")
	public String list(Model model) {
		model.addAttribute("memberList", memberService.list());
		return "list";
	}
	
	
	/*@RequestMapping("/list")
	public ModelAndView list() {
		
		ModelAndView mav = new ModelAndView();
		
		ArrayList list = new ArrayList();
		Member member = new Member();
		member.setId("1");
		member.setName("김대연");
		member.setJoined(new Date(2019,01,27));
		list.add(member);
		
		Member member2 = new Member();
		member2.setId("2");
		member2.setName("김보민");
		member2.setJoined(new Date(2019,01,27));
		list.add(member2);
		
		Member member3 = new Member();
		member3.setId("3");
		member3.setName("송병욱");
		member3.setJoined(new Date(2019,01,27));
		list.add(member3);
		
		Member member4 = new Member();
		member4.setId("4");
		member4.setName("이진화");
		member4.setJoined(new Date(2019,01,27));
		list.add(member3);
		
		
		System.out.println("리스트 사이즈 : " +  list.size());
		System.out.println("멤버1 name : " +  member.getName());
		System.out.println("멤버2 name : " +  member2.getName());
		System.out.println("멤버3 name : " +  member3.getName());
		System.out.println("멤버4 name : " +  member4.getName());

		mav.addObject("memberList", list);
		mav.setViewName("list");
		return mav;
		
	}*/
	
}
