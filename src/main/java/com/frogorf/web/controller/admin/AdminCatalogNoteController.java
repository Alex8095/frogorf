package com.frogorf.web.controller.admin;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

import com.frogorf.catalog.domain.CatalogNote;
import com.frogorf.catalog.service.CatalogService;
import com.frogorf.domain.BaseLocale;

/** Handles requests for the application home catalog note. */
@Controller
@SessionAttributes(types = { CatalogNote.class })
@RequestMapping("/admin")
public class AdminCatalogNoteController {

	private static final Logger logger = LoggerFactory.getLogger(AdminCatalogNoteController.class);

	@Autowired
	private CatalogService catalogService;

	@InitBinder
	public void setAllowedFields(WebDataBinder dataBinder) {
		dataBinder.setDisallowedFields("id");
	}

	@RequestMapping(value = "/catalognotes", method = RequestMethod.GET)
	public String processFindForm(Model model) {
		List<CatalogNote> catalogNotes = this.catalogService.findCatalogNotes();
		model.addAttribute("catalogNotes", catalogNotes);
		return "admin/catalog/catalogNoteList";
	}

	@RequestMapping(value = "/catalognote/new", method = RequestMethod.GET)
	public String initCreationForm(Model model) {
		CatalogNote catalogNote = new CatalogNote();
		if (catalogNote.isNew()) {
			BaseLocale catalogLocale = new BaseLocale();
			Map<String, BaseLocale> locales = new HashMap<String, BaseLocale>();
			catalogLocale.setMenu("menu ru");
			locales.put("ru", catalogLocale);
			catalogLocale = new BaseLocale();
			catalogLocale.setMenu("menu en");
			locales.put("en", catalogLocale);
			catalogNote.setCatalogNoteLocale(locales);
		}
		model.addAttribute(catalogNote);
		model.addAttribute("catalogNotes", catalogService.findCatalogNotes());
		return "admin/catalog/catalogNoteForm";
	}

	@RequestMapping(value = "/catalognote/new", method = RequestMethod.POST)
	public String processCreationForm(@Valid CatalogNote catalogNote, BindingResult result, SessionStatus status) {
		if (result.hasErrors()) {
			return "admin/catalog/catalogNoteForm";
		} else {
			this.catalogService.saveCatalogNote(catalogNote);
			status.setComplete();
			return "redirect:/admin/catalognote/" + catalogNote.getId();
		}
	}

	@RequestMapping(value = "/catalognote/{catalogNoteId}/edit", method = RequestMethod.GET)
	public String initUpdateCatalogNoteForm(@PathVariable("catalogNoteId") int catalogNoteId, Model model) {
		model.addAttribute("catalogNote", this.catalogService.findCatalogNoteById(catalogNoteId));
		model.addAttribute("catalogNotes", catalogService.findCatalogNotes());
		return "admin/catalog/catalogNoteForm";
	}

	@RequestMapping(value = "/catalognote/{catalogNoteId}/edit", method = RequestMethod.POST)
	public String processUpdateCatalogNoteForm(CatalogNote catalogNote, BindingResult result, SessionStatus status) {
		if (result.hasErrors()) {
			return "admin/catalog/catalogNoteForm";
		} else {
			logger.info(catalogNote.getId().toString());
			this.catalogService.saveCatalogNote(catalogNote);
			status.setComplete();
			return "redirect:/admin/catalognote/{catalogNoteId}";
		}
	}

	@RequestMapping("/catalognote/{catalogNoteId}")
	public String showCatalogNote(@PathVariable("catalogNoteId") int catalogNoteId, Model model) {
		CatalogNote catalogNote = this.catalogService.findCatalogNoteById(catalogNoteId);
		model.addAttribute("catalogNote", catalogNote);
		return "admin/catalog/catalogNoteDetails";
	}

	@RequestMapping(value = "/catalognote/{catalogNoteId}/delete")
	public String deleteCatalogNote(@PathVariable("catalogNoteId") int catalogNoteId, Model model) {
		this.catalogService.deleteCatalogNote(catalogNoteId);
		return "redirect:/admin/catalognotes";
	}
}
