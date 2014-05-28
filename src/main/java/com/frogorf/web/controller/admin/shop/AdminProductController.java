package com.frogorf.web.controller.admin.shop;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.joda.time.DateTime;
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
import com.frogorf.shop.domain.Product;
import com.frogorf.shop.domain.ProductLocale;
import com.frogorf.shop.service.ShopService;

/** Handles requests for the application home catalog note. */
@Controller
@SessionAttributes(types = { Product.class })
@RequestMapping("/admin")
public class AdminProductController {

	private static final Logger logger = LoggerFactory.getLogger(AdminProductController.class);

	@Autowired
	private ShopService shopService;

	@Autowired
	private CatalogService catalogService;

	@InitBinder
	public void setAllowedFields(WebDataBinder dataBinder) {
		dataBinder.setDisallowedFields("id");
	}

	@RequestMapping(value = "/products", method = RequestMethod.GET)
	public String processFindForm(Model model) {
		List<Product> products = shopService.findProducts();
		model.addAttribute("products", products);
		return "admin/shop/product/list";
	}

	@RequestMapping(value = "/product/new", method = RequestMethod.GET)
	public String initCreationForm(Model model) {
		Product product = new Product();
		if (product.isNew()) {
			ProductLocale productLocale = new ProductLocale();
			Map<String, ProductLocale> locales = new HashMap<String, ProductLocale>();
			productLocale.setName("");
			locales.put("ru", productLocale);
			productLocale = new ProductLocale();
			productLocale.setName("");
			locales.put("en", productLocale);
			product.setProductLocale(locales);
			product.setDateCreate(new DateTime());
		}
		model.addAttribute(product);
		CatalogNote catalogNote = new CatalogNote();
		catalogNote.setParentCatalogNote(new CatalogNote(5));
		model.addAttribute("catalogList", catalogService.findCatalogNotesByCatalogNote(catalogNote));
		int size = catalogService.findCatalogNotesByCatalogNote(catalogNote).size();
		logger.info(Integer.toString(size));
		return "admin/shop/product/form";
	}

	@RequestMapping(value = "/product/new", method = RequestMethod.POST)
	public String processCreationForm(@Valid Product product, BindingResult result, SessionStatus status) {
		if (result.hasErrors()) {
			return "admin/shop/product/form";
		} else {
			product.setDateUpdate(new DateTime());
			shopService.saveProduct(product);
			status.setComplete();
			return "redirect:/admin/product/" + product.getId();
		}
	}

	@RequestMapping(value = "/product/{productId}/edit", method = RequestMethod.GET)
	public String initUpdateProductForm(@PathVariable("productId") int productId, Model model) {
		model.addAttribute("product", shopService.findProductById(productId));
		return "admin/shop/product/form";
	}

	@RequestMapping(value = "/product/{productId}/edit", method = RequestMethod.POST)
	public String processUpdateProductForm(Product product, BindingResult result, SessionStatus status) {
		if (result.hasErrors()) {
			return "admin/shop/product/form";
		} else {
			logger.info(product.getId().toString());
			shopService.saveProduct(product);
			status.setComplete();
			return "redirect:/admin/product/{productId}";
		}
	}

	@RequestMapping("/product/{productId}")
	public String showProduct(@PathVariable("productId") int productId, Model model) {
		Product product = shopService.findProductById(productId);
		model.addAttribute("product", product);
		return "admin/shop/product/details";
	}

	@RequestMapping(value = "/product/{productId}/delete")
	public String deleteProduct(@PathVariable("productId") int productId, Model model) {
		shopService.deleteProduct(productId);
		return "redirect:/admin/products";
	}
}
