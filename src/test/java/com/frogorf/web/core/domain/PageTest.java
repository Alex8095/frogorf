/**
 * 
 */
package com.frogorf.web.core.domain;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author Tsurkin Alex
 * @version
 */
public class PageTest {

	private static final Logger logger = LoggerFactory.getLogger(PageTest.class);

	@Test
	public void test() {
		/* domain */
		Domain domain = new Domain();
		domain.setUrl("url");
		List<Domain> domains = new ArrayList<Domain>();
		domains.add(domain);
		/* page locale */
		PageLocale pageLocale = new PageLocale();
		pageLocale.setContent("content");
		pageLocale.setDescrition("descrition");
		pageLocale.setMenu("menu");
		pageLocale.setTitle("title");
		pageLocale.setWebDescription("webDescription");
		pageLocale.setWebKeywords("webKeywords");
		pageLocale.setWebTitle("webTitle");
		Map<String, PageLocale> pageLocales = new HashMap<String, PageLocale>();
		pageLocales.put("ru", pageLocale);
		/* page */
		Page page = new Page();
		page.setAction("action");
		page.setController("controller");
		page.setIsAuthorized(false);
		page.setIsShow(false);
		page.setIsShowInMenu(false);
		page.setLevel(1);
		page.setUrl("url");
		page.setDomains(domains);
		page.setPageLocale(pageLocales);
		/* test object */
		assertEquals(page.getAction(), "action");
		assertEquals(page.getController(), "controller");
		assertEquals(page.getIsAuthorized(), false);
		assertEquals(page.getIsShow(), false);
		assertEquals(page.getIsShowInMenu(), false);
		assertEquals(page.getLevel(), 1);
		assertEquals(page.getUrl(), "url");
		/* test object domain */
		assertEquals(page.getDomains().get(0).getUrl(), "url");
		/* test object locale */
		assertEquals(page.getPageLocale().get("ru").getContent(), "content");
		assertEquals(page.getPageLocale().get("ru").getDescrition(), "descrition");
		assertEquals(page.getPageLocale().get("ru").getMenu(), "menu");
		assertEquals(page.getPageLocale().get("ru").getTitle(), "title");
		assertEquals(page.getPageLocale().get("ru").getWebDescription(), "webDescription");
		assertEquals(page.getPageLocale().get("ru").getWebKeywords(), "webKeywords");
		assertEquals(page.getPageLocale().get("ru").getWebTitle(), "webTitle");
		assertEquals(page.getCurrentPageLocale().getContent(), "content");
		assertEquals(page.getCurrentPageLocale().getDescrition(), "descrition");
		assertEquals(page.getCurrentPageLocale().getMenu(), "menu");
		assertEquals(page.getCurrentPageLocale().getTitle(), "title");
		assertEquals(page.getCurrentPageLocale().getWebDescription(), "webDescription");
		assertEquals(page.getCurrentPageLocale().getWebKeywords(), "webKeywords");
		assertEquals(page.getCurrentPageLocale().getWebTitle(), "webTitle");
	}
}
