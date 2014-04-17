/**
 * 
 */
package com.frogorf.web.controller.admin;

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
@RequestMapping("/admin")
public class AdminHomeController {

	private static final Logger logger = LoggerFactory.getLogger(AdminHomeController.class);

	/** Simply selects the home view to render by returning its name. */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Model model) {
		logger.info("Welcome home!");
		return "admin/home";
	}
}
