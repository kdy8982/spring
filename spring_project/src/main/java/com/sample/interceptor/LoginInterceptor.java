package com.sample.interceptor;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.ui.ModelMap;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class LoginInterceptor extends HandlerInterceptorAdapter {

	private static final String LOGIN = "login";
	private static final Logger logger = LoggerFactory.getLogger(LoginInterceptor.class);

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		HttpSession httpSession = request.getSession();
		ModelMap modelMap = modelAndView.getModelMap();
		Object member = modelMap.get("member");
		
		if (member != null) {
			logger.info("새로운 로그인이 성공하였습니다");
			httpSession.setAttribute(LOGIN, member);
			// response.sendRedirect("/sample");
			
			if(request.getParameter("userCookie") != null) {
				logger.info("쿠키를 생성하였습니다.");
				Cookie loginCookie = new Cookie("loginCookie", httpSession.getId());
				loginCookie.setPath("/");
				loginCookie.setMaxAge(60*60*24*7);
				response.addCookie(loginCookie);
			}
			Object destination = httpSession.getAttribute("destination");
			response.sendRedirect(destination != null ?(String) destination : "/sample");
		}
	}

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {

		HttpSession httpSession = request.getSession();

		if (httpSession.getAttribute(LOGIN) != null) {
			logger.info("clear login data before");
			httpSession.removeAttribute(LOGIN);
		}
		return true;
	}
}
