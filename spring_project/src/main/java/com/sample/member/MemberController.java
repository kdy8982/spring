package com.sample.member;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.sample.domain.Member;



@Controller
@RequestMapping("/member")
public class MemberController {

	@Autowired
	MemberService memberService;
	
	@RequestMapping("/list")
	public String list(Model model) {
		System.out.println("hello list");
		model.addAttribute("memberList", memberService.list());
		return "member/list";
	}
	
	@RequestMapping("/form")
	public String form(Model model) {
		model.addAttribute("member", new Member());
		return "member/form";
	}
	
	@RequestMapping("/post")
	public String postSubmit(@Valid Member member, BindingResult result){
		System.out.println(member.getName());
		
		if(result.hasErrors()) {
			System.out.println("1111111");
			return "member/form";
		}
		System.out.println("2222222");
		memberService.add(member);
		return "redirect:list.dy";
	}
}
