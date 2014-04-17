package com.frogorf.web.controller.admin;

import java.util.List;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import com.frogorf.dictionary.domain.Dictionary;
import com.frogorf.dictionary.domain.DictionaryValue;
import com.frogorf.dictionary.service.DictionaryService;

/** Handles requests for the application home page. */
@Controller
@SessionAttributes(types = { Dictionary.class, DictionaryValue.class })
@RequestMapping("/admin")
public class AdminDictionaryController {

	private static final Logger logger = LoggerFactory.getLogger(AdminDictionaryController.class);

	@Autowired
	private DictionaryService dictionaryService;

	@InitBinder
	public void setAllowedFields(WebDataBinder dataBinder) {
		dataBinder.setDisallowedFields("id");
	}

	@RequestMapping(value = "/dictionaries", method = RequestMethod.GET)
	public String processFindForm(Model model) {
		List<Dictionary> dictionaries = this.dictionaryService.findDictionaryAll();
		model.addAttribute("dictionaries", dictionaries);
		return "admin/dictionary/list";
	}

	@RequestMapping(value = "/dictionary/new", method = RequestMethod.GET)
	public String initCreationForm(Model model) {
		Dictionary dictionary = new Dictionary();
		model.addAttribute(dictionary);
		return "admin/dictionary/form";
	}

	@RequestMapping(value = "/dictionary/new", method = RequestMethod.POST)
	public String processCreationForm(@Valid Dictionary dictionary, BindingResult result, SessionStatus status) {
		System.out.println("/dictionary/new");
		
		if (result.hasErrors()) {
			return "admin/dictionary/form";
		} else {
			this.dictionaryService.saveDictionary(dictionary);
			status.setComplete();
			return "redirect:/admin/dictionary/" + dictionary.getId();
		}
	}

	@RequestMapping(value = "/dictionary/{dictionaryId}/edit", method = RequestMethod.GET)
	public String initUpdateDictionaryForm(@PathVariable("dictionaryId") int dictionaryId, Model model) {
		model.addAttribute("dictionary", this.dictionaryService.findDictionaryById(dictionaryId));
		return "admin/dictionary/form";
	}

	@RequestMapping(value = "/dictionary/{dictionaryId}/edit", method = RequestMethod.POST)
	public String processUpdateDictionaryForm(Dictionary dictionary, BindingResult result, SessionStatus status) {
		if (result.hasErrors()) {
			return "admin/dictionary/form";
		} else {
			this.dictionaryService.saveDictionary(dictionary);
			status.setComplete();
			return "redirect:/dictionary/{dictionaryId}";
		}
	}

	/** Custom handler for displaying an Dictionary.
	 * 
	 * @param DictionaryId the ID of the Dictionary to display
	 * @return a ModelMap with the model attributes for the view */
	@RequestMapping("/dictionary/{dictionaryId}")
	public String showDictionary(@PathVariable("dictionaryId") int dictionaryId, Model model) {
		Dictionary dictionary = this.dictionaryService.findDictionaryById(dictionaryId);
		model.addAttribute("dictionary", dictionary);
		return "admin/dictionary/details";
	}

	@RequestMapping(value = "/dictionary/{dictionaryId}/delete")
	public String deleteDictionary(@PathVariable("dictionaryId") int dictionaryId, Model model) {
		this.dictionaryService.deleteDictionary(dictionaryId);
		return "redirect:/admin/dictionary";
	}

	@RequestMapping(value = "/dictionary/values", method = RequestMethod.GET)
	public String processFindValueForm(Model model) {
		List<DictionaryValue> dictionaryValues = this.dictionaryService.findDictionaryValueAll();
		model.addAttribute("dictionaryValues", dictionaryValues);
		return "admin/dictionary/listValue";
	}

	@RequestMapping(value = "/dictionary/value/new", method = RequestMethod.GET)
	public String initCreationValueForm(Model model) {
		DictionaryValue dictionaryValue = new DictionaryValue();
		model.addAttribute(dictionaryValue);
		model.addAttribute("dictionaries", dictionaryService.findDictionaryAll());
		return "admin/dictionary/formValue";
	}

	@RequestMapping(value = "/dictionary/value/new", method = RequestMethod.POST)
	public String processCreationValueForm(@Valid DictionaryValue dictionaryValue, BindingResult result, SessionStatus status) {
		System.out.println(dictionaryValue);
		if (result.hasErrors()) {
			for (ObjectError error : result.getAllErrors()) {
				System.out.println(error.getDefaultMessage());
			}
			System.out.println("error");
			return "admin/dictionary/formValue";
		} else {
			this.dictionaryService.saveDictionaryValue(dictionaryValue);
			status.setComplete();
			return "redirect:/admin/dictionary/value/" + dictionaryValue.getId();
		}
	}

	@RequestMapping(value = "/dictionary/value/edit/{dictionaryValueId}", method = RequestMethod.GET)
	public String initUpdateDictionaryValueForm(@PathVariable("dictionaryValueId") int dictionaryValueId, Model model) {
		model.addAttribute("dictionaryValue", this.dictionaryService.findDictionaryValueById(dictionaryValueId));
		model.addAttribute("dictionaries", dictionaryService.findDictionaryAll());
		return "admin/dictionary/formValue";
	}

	@RequestMapping(value = "/dictionary/value/edit/{dictionaryValueId}", method = RequestMethod.POST)
	public String processUpdateDictionaryValueForm(DictionaryValue dictionaryValue, BindingResult result, SessionStatus status) {
		if (result.hasErrors()) {
			return "admin/dictionary/form";
		} else {
			this.dictionaryService.saveDictionaryValue(dictionaryValue);
			status.setComplete();
			return "redirect:/admin/dictionary/value/{dictionaryValueId}";
		}
	}

	/** Custom handler for displaying an Dictionary.
	 * 
	 * @param DictionaryId the ID of the Dictionary to display
	 * @return a ModelMap with the model attributes for the view */
	@RequestMapping("/dictionary/value/{dictionaryValueId}")
	public String showDictionaryValue(@PathVariable("dictionaryValueId") int dictionaryValueId, Model model) {
		DictionaryValue dictionaryValue = this.dictionaryService.findDictionaryValueById(dictionaryValueId);
		model.addAttribute("dictionaryValue", dictionaryValue);
		return "admin/dictionary/detailsValue";
	}

	@RequestMapping(value = "/dictionary/value/delete/{dictionaryValueId}")
	public String deleteDictionaryValue(@PathVariable("dictionaryValueId") int dictionaryValueId, Model model) {
		this.dictionaryService.deleteDictionaryValue(dictionaryValueId);
		return "redirect:/admin/dictionary/values";
	}
}
