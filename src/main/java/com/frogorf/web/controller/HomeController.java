/**
 * 
 */
package com.frogorf.web.controller;

import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.frogorf.dictionary.domain.Dictionary;
import com.frogorf.web.core.domain.Page;

/** @author Tsurkin Alex
 * @version */
@Controller
public class HomeController {

	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);

	/** Simply selects the home view to render by returning its name. */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Model model, Locale locale) {
		Page page = new Page();
		page.setAction("action");
		page.getAction();

		System.out.println(page.getAction());

		logger.info("Welcome home!" + locale);
		System.out.println("Welcome home!" + locale);
		return "home";
	}
}
