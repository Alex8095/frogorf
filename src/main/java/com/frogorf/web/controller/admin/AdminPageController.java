package com.frogorf.web.controller.admin;

import java.util.List;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import com.frogorf.web.core.domain.Page;
import com.frogorf.web.core.domain.PageLocale;
import com.frogorf.web.core.service.PageService;

/** Handles requests for the application home page. */
@Controller
@SessionAttributes(types = { Page.class })
@RequestMapping("/admin")
public class AdminPageController {

	private static final Logger logger = LoggerFactory.getLogger(AdminPageController.class);

	@Autowired
	private PageService pageService;

	@InitBinder
	public void setAllowedFields(WebDataBinder dataBinder) {
		dataBinder.setDisallowedFields("id");
	}

	@RequestMapping(value = "/pages", method = RequestMethod.GET)
	public String processFindForm(Model model) {
		List<Page> pages = this.pageService.findPages();
		model.addAttribute("pages", pages);
		return "admin/page/list";
	}

	@RequestMapping(value = "/page/new", method = RequestMethod.GET)
	public String initCreationForm(Model model) {
		Page page = new Page();
		page.getPageLocale().put("ru", new PageLocale());
		model.addAttribute(page);
		return "admin/page/form";
	}

	@RequestMapping(value = "/page/new", method = RequestMethod.POST)
	public String processCreationForm(@Valid Page page, BindingResult result, SessionStatus status) {
		if (result.hasErrors()) {
			return "admin/page/form";
		} else {
			this.pageService.savePage(page);
			status.setComplete();
			return "redirect:/admin/page/" + page.getId();
		}
	}

	@RequestMapping(value = "/page/{pageId}/edit", method = RequestMethod.GET)
	public String initUpdatePageForm(@PathVariable("pageId") int pageId, Model model) {
		model.addAttribute("page", this.pageService.findPageById(pageId));
		return "admin/page/form";
	}

	@RequestMapping(value = "/page/{pageId}/edit", method = RequestMethod.POST)
	public String processUpdatePageForm(Page page, BindingResult result, SessionStatus status) {
		if (result.hasErrors()) {
			return "admin/page/form";
		} else {
			this.pageService.savePage(page);
			status.setComplete();
			return "redirect:/admin/page/{pageId}";
		}
	}

	@RequestMapping("/page/{pageId}")
	public String showPage(@PathVariable("pageId") int pageId, Model model) {
		Page page = this.pageService.findPageById(pageId);
		model.addAttribute("page", page);
		return "admin/page/details";
	}

	@RequestMapping(value = "/page/{pageId}/delete")
	public String deletePage(@PathVariable("pageId") int pageId, Model model) {
		this.pageService.deletePage(pageId);
		return "redirect:/admin/pages";
	}
}
