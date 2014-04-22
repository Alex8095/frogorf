/**
 * 
 */
package com.frogorf.web.core.service;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.frogorf.service.AbstractBaseServiceTest;
import com.frogorf.web.core.domain.Domain;
import com.frogorf.web.core.domain.Page;
import com.frogorf.web.core.domain.PageLocale;

/** @author Tsurkin Alex
 * @version */
public class CoreServiceTest extends AbstractBaseServiceTest {

	private static final Logger logger = LoggerFactory.getLogger(CoreServiceTest.class);

	@Autowired
	protected CoreService coreService;
	@Autowired
	protected DomainService domainService;

	/** Test method for
	 * {@link com.frogorf.web.core.service.CoreService#findPages()}. */
	@Test
	public void testFindPages() {
		List<Page> pages = coreService.findPages();
		int found = pages.size();
		Page page = new Page();
		page.setAction("action");
		coreService.savePage(page);
		pages = coreService.findPages();
		assertEquals("Verifying number of  after inserting a new one.", found + 1, pages.size());
	}

	/** Test method for
	 * {@link com.frogorf.web.core.service.CoreService#findPagesByPage(com.frogorf.web.core.domain.Page)}
	 * . */
	@Test
	public void testFindPagesByPagePage() {
		fail("Not yet implemented");
	}

	/** Test method for
	 * {@link com.frogorf.web.core.service.CoreService#findPagesByPage(com.frogorf.web.core.domain.Page, org.springframework.data.domain.Pageable)}
	 * . */
	@Test
	public void testFindPagesByPagePagePageable() {
		fail("Not yet implemented");
	}

	/** Test method for
	 * {@link com.frogorf.web.core.service.CoreService#findPageById(int)}. */
	@Test
	public void testFindPageById() {
		Page page = new Page();
		page.setAction("action");
		coreService.savePage(page);
		int page_id = page.getId();
		page = coreService.findPageById(page_id);
		assertEquals("testFindPageById page_id:" + Integer.toString(page_id), page.getAction(), "action");
	}

	/** Test method for
	 * {@link com.frogorf.web.core.service.CoreService#findPageByPage(com.frogorf.web.core.domain.Page)}
	 * . */
	@Test
	public void testFindPageByPage() {
		fail("Not yet implemented");
	}

	/** Test method for
	 * {@link com.frogorf.web.core.service.CoreService#savePage(com.frogorf.web.core.domain.Page)}
	 * . */
	@Test
	public void testSavePage() {
		/* domain */
		Domain domain = new Domain();
		domain.setUrl("url");
		List<Domain> domains = new ArrayList<Domain>();
		domains.add(domain);
		domainService.saveDomain(domain);
		/* page parent */
		Page pageParent = new Page();
		pageParent.setAction("parent");
		coreService.savePage(pageParent);
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
		page.setPage(pageParent);
		coreService.savePage(page);

		page = coreService.findPageById(page.getId());
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
		/* test object parent */
		assertEquals(page.getPage().getAction(), "parent");
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

	/** Test method for
	 * {@link com.frogorf.web.core.service.CoreService#deletePage(int)}. */
	@Test
	public void testDeletePage() {
		Page page = new Page();
		page.setAction("action");
		coreService.savePage(page);
		int page_id = page.getId();
		coreService.deletePage(page_id);
		assertNull("testDeletePage page_id:" + Integer.toString(page_id), coreService.findPageById(page_id));
	}

}
