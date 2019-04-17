package com.sample.member;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.request;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.util.WebUtils;

import com.sample.domain.LoginDTO;
import com.sample.domain.Member;



@Controller
public class MemberController {

	@Autowired
	MemberService memberService;
	
	@RequestMapping("/admin/list")
	public String list(Model model) {
		model.addAttribute("memberList", memberService.list());
		return "member/list";
	}
	
	@RequestMapping("/member/form") 
	public String form(Model model) {
		model.addAttribute("member", new Member());
		return "member/form";
	}
	
	@RequestMapping("/member/post") 
	public String postSubmit(@Valid Member member, BindingResult result) {
		
		if(result.hasErrors()) {
			return "member/form";
		}
		
		String hashedPw = BCrypt.hashpw(member.getPassword(), BCrypt.gensalt());
		member.setPassword(hashedPw);
		memberService.add(member);
		return "redirect:list.do";
	}
	
	
	/**
	 * 로그인페이지 호출
	 * @return
	 */
	@RequestMapping("/member/login") 
	public String login() {
		return "member/login";
	}
	
	
	/**
	 * 로그인 버튼 클릭
	 * @throws Exception 
	 */
	@RequestMapping(value = "/member/loginPost", method=RequestMethod.POST) 
	public void loginPost(LoginDTO loginDTO, HttpSession httpSession, Model model) throws Exception {
		Member member = memberService.login(loginDTO);
		
		if(member == null || !BCrypt.checkpw(loginDTO.getMemberPw(), member.getPassword())) { // 비밀번호 체크(서버에서는 id만 검증한다)
			return;
		}
		model.addAttribute("member", member);
	}
	
	
	/**
	 * 로그아웃 버튼 클릭
	 * @param request
	 * @param response
	 * @param httpSession
	 * @return
	 */
	@RequestMapping(value="/member/logout",method=RequestMethod.GET)
	public String logout(HttpServletRequest request, HttpServletResponse response, HttpSession httpSession) {
		Object object = httpSession.getAttribute("login");
		if(object != null) {
			Member member = (Member) object;
			httpSession.removeAttribute("login");
			httpSession.invalidate();
			
			Cookie loginCookie = WebUtils.getCookie(request, "loginCookie");
			if(loginCookie != null) {
				loginCookie.setPath("/");
				loginCookie.setMaxAge(0);
				response.addCookie(loginCookie);
			}
		}
		
		return "member/logout";
	}
	
}
