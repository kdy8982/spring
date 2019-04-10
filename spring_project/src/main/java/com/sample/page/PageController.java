package com.sample.page;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class PageController {

	
	@RequestMapping("/secu/loginPage")
	public String login() {
		return "/secu/loginPage";
	}
	
	@RequestMapping("/secu/logout")
	public String logout() {
		return "/secu/logout";
	}
	
	@RequestMapping("/secu/accessDenied")
	public String accessDenied() throws Exception {
		return "/secu/accessDenied";
	}

}
