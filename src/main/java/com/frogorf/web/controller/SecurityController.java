/**
 * 
 */
package com.frogorf.web.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/** @author Tsurkin Alex
 * @version */

@RequestMapping("/security")
@Controller
public class SecurityController {

	private static final Logger logger = LoggerFactory.getLogger(SecurityController.class);

	@RequestMapping("/loginfail")
	public String loginFail(Model uiModel) {
		logger.info("Login failed detected");
		return "/security/signin";
	}

	@RequestMapping("/signin")
	public String login(Model uiModel) {
		return "/security/signin";
	}
}

/* Authentication auth = SecurityContextHolder.getContext().getAuthentication();
 * String name = auth.getName(); //get logged in username
 * System.out.println(name); Collection<SimpleGrantedAuthority> authorities =
 * (Collection<SimpleGrantedAuthority>) auth.getAuthorities();
 * 
 * for (SimpleGrantedAuthority simpleGrantedAuthority : authorities) {
 * System.out.println(simpleGrantedAuthority.getAuthority()); } */