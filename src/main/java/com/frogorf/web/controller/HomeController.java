/**
 * 
 */
package com.frogorf.web.controller;

import java.util.Locale;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


/**
 * 
 * @author Tsurkin Alex
 * @version
 */
@Controller
public class HomeController {

	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);

	/** Simply selects the home view to render by returning its name. */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Model model, Locale locale, HttpServletRequest request ) {
		logger.info("Welcome home!" + locale);
		System.out.println("Welcome home!" + locale + "request" + request.getParameter("lang_code"));
		return "home";
	}
	
	@RequestMapping(value = "/next", method = RequestMethod.GET)
	public String next(Model model, Locale locale, HttpServletRequest request ) {
		return "home";
	}
}
