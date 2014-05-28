package com.frogorf.web.controller.admin.shop;

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

import com.frogorf.shop.domain.Warehouse;
import com.frogorf.shop.service.ShopService;

/** Handles requests for the application home catalog note. */
@Controller
@SessionAttributes(types = { Warehouse.class })
@RequestMapping("/admin")
public class AdminWarehouseController {

	private static final Logger logger = LoggerFactory.getLogger(AdminWarehouseController.class);

	@Autowired
	private ShopService shopService;

	@InitBinder
	public void setAllowedFields(WebDataBinder dataBinder) {
		dataBinder.setDisallowedFields("id");
	}

	@RequestMapping(value = "/warehouses", method = RequestMethod.GET)
	public String processFindForm(Model model) {
		List<Warehouse> Warehouses = shopService.findWarehouses();
		model.addAttribute("warehouses", Warehouses);
		return "admin/shop/warehouse/list";
	}

	@RequestMapping(value = "/warehouse/new", method = RequestMethod.GET)
	public String initCreationForm(Model model) {
		Warehouse warehouse = new Warehouse();
		model.addAttribute(warehouse);
		return "admin/shop/warehouse/form";
	}

	@RequestMapping(value = "/warehouse/new", method = RequestMethod.POST)
	public String processCreationForm(@Valid Warehouse warehouse, BindingResult result, SessionStatus status) {
		if (result.hasErrors()) {
			return "admin/shop/warehouse/form";
		} else {
			shopService.saveWarehouse(warehouse);
			status.setComplete();
			return "redirect:/admin/warehouse/" + warehouse.getId();
		}
	}

	@RequestMapping(value = "/warehouse/{warehouseId}/edit", method = RequestMethod.GET)
	public String initUpdateWarehouseForm(@PathVariable("warehouseId") int warehouseId, Model model) {
		model.addAttribute("warehouse", shopService.findWarehouseById(warehouseId));
		return "admin/shop/warehouse/form";
	}

	@RequestMapping(value = "/warehouse/{warehouseId}/edit", method = RequestMethod.POST)
	public String processUpdateWarehouseForm(Warehouse warehouse, BindingResult result, SessionStatus status) {
		if (result.hasErrors()) {
			return "admin/shop/warehouse/form";
		} else {
			shopService.saveWarehouse(warehouse);
			status.setComplete();
			return "redirect:/admin/warehouse/{warehouseId}";
		}
	}

	@RequestMapping("/warehouse/{warehouseId}")
	public String showWarehouse(@PathVariable("warehouseId") int warehouseId, Model model) {
		Warehouse warehouse = shopService.findWarehouseById(warehouseId);
		model.addAttribute("warehouse", warehouse);
		return "admin/shop/warehouse/details";
	}

	@RequestMapping(value = "/warehouse/{warehouseId}/delete")
	public String deleteWarehouse(@PathVariable("warehouseId") int warehouseId, Model model) {
		shopService.deleteWarehouse(warehouseId);
		return "redirect:/admin/warehouses";
	}
}
