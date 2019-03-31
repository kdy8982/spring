package com.sample.member;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;


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
	
	
	
}
