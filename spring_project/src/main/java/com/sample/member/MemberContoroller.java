package com.sample.member;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

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
	
	@RequestMapping("/form")
	public String form(Model model) {
		model.addAttribute("member", new Member());
		return "form";
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public String formSubmit(@Valid Member member, BindingResult result){
		System.out.println("3333333");
		if(result.hasErrors()) {
			System.out.println("1111111");
			return "member/form.dy";
		}
		System.out.println("2222222");
		memberService.add(member);
		return "redirect:/member/list.dy";
	}
}
