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

import com.frogorf.web.core.domain.Domain;
import com.frogorf.web.core.service.DomainService;

/** Handles requests for the application home page. */
@Controller
@SessionAttributes(types = { Domain.class })
@RequestMapping("/admin")
public class AdminDomainController {

	private static final Logger logger = LoggerFactory.getLogger(AdminDomainController.class);

	@Autowired
	private DomainService domainService;

	@InitBinder
	public void setAllowedFields(WebDataBinder dataBinder) {
		dataBinder.setDisallowedFields("id");
	}

	@RequestMapping(value = "/domains", method = RequestMethod.GET)
	public String processFindForm(Model model) {
		List<Domain> domains = this.domainService.findDomains();
		model.addAttribute("domains", domains);
		return "admin/domain/list";
	}

	@RequestMapping(value = "/domain/new", method = RequestMethod.GET)
	public String initCreationForm(Model model) {
		Domain domain = new Domain();
		model.addAttribute(domain);
		return "admin/domain/form";
	}

	@RequestMapping(value = "/domain/new", method = RequestMethod.POST)
	public String processCreationForm(@Valid Domain domain, BindingResult result, SessionStatus status) {
		if (result.hasErrors()) {
			return "admin/domain/form";
		} else {
			this.domainService.saveDomain(domain);
			status.setComplete();
			return "redirect:/admin/domain/" + domain.getId();
		}
	}

	@RequestMapping(value = "/domain/{domainId}/edit", method = RequestMethod.GET)
	public String initUpdateDomainForm(@PathVariable("domainId") int domainId, Model model) {
		model.addAttribute("domain", this.domainService.findDomainById(domainId));
		return "admin/domain/form";
	}

	@RequestMapping(value = "/domain/{domainId}/edit", method = RequestMethod.POST)
	public String processUpdatedomainForm(Domain domain, BindingResult result, SessionStatus status) {
		if (result.hasErrors()) {
			return "admin/domain/form";
		} else {
			this.domainService.saveDomain(domain);
			status.setComplete();
			return "redirect:/admin/domain/{domainId}";
		}
	}

	@RequestMapping("/domain/{domainId}")
	public String showDomain(@PathVariable("domainId") int domainId, Model model) {
		Domain domain = this.domainService.findDomainById(domainId);
		model.addAttribute("domain", domain);
		return "admin/domain/details";
	}

	@RequestMapping(value = "/domain/{domainId}/delete")
	public String deleteDomain(@PathVariable("domainId") int domainId, Model model) {
		this.domainService.deleteDomain(domainId);
		return "redirect:/admin/domains";
	}
}
