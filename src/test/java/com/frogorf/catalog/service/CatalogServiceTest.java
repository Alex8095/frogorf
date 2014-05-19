package com.frogorf.catalog.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;

import com.frogorf.catalog.domain.CatalogNote;
import com.frogorf.catalog.service.CatalogService;
import com.frogorf.domain.BaseLocale;
import com.frogorf.service.AbstractBaseServiceTest;

public class CatalogServiceTest extends AbstractBaseServiceTest {

	private static final Logger logger = LoggerFactory.getLogger(CatalogServiceTest.class);

	@Autowired
	protected CatalogService catalogService;

	@Test
	public void testFindCatalogNotes() {
		List<CatalogNote> list = catalogService.findCatalogNotes();
		int found = list.size();
		CatalogNote item = new CatalogNote();
		item.setUrl("testFindCatalogNotes");
		catalogService.saveCatalogNote(item);
		list = catalogService.findCatalogNotes();
		assertEquals("Verifying number of  after inserting a new one.", found + 1, list.size());
	}

	@Test
	public void testFindCatalogNotesByCatalogNoteCatalogNote() {
		CatalogNote item = new CatalogNote();
		item.setUrl("url testFindCatalogNotesByCatalogNoteCatalogNote");
		catalogService.saveCatalogNote(item);
		List<CatalogNote> CatalogNotes = catalogService.findCatalogNotesByCatalogNote(item);
		assertEquals(1, CatalogNotes.size());
	}

	@Test
	public void testFindCatalogNotesByCatalogNoteCatalogNoteCatalogNoteable() {
		String catalogNoteUrl = "url 3156";

		CatalogNote p1 = new CatalogNote();
		p1.setUrl(catalogNoteUrl);
		catalogService.saveCatalogNote(p1);
		p1 = new CatalogNote();
		p1.setUrl("url 2");
		catalogService.saveCatalogNote(p1);
		/* paggable */
		Sort sort = null;
		String orderBy = "url";
		String order = "desc";
		if (orderBy != null && order != null) {
			if (order.equals("desc")) {
				sort = new Sort(Sort.Direction.DESC, orderBy);
			} else
				sort = new Sort(Sort.Direction.ASC, orderBy);
		}
		PageRequest pageRequest = null;
		int page = 1;
		int rows = 20;
		if (sort != null) {
			pageRequest = new PageRequest(page - 1, rows, sort);
		} else {
			pageRequest = new PageRequest(page - 1, rows);
		}

		CatalogNote webCatalogNote = new CatalogNote();
		webCatalogNote.setUrl(catalogNoteUrl);

		org.springframework.data.domain.Page<CatalogNote> catalogNotes = catalogService.findCatalogNotesByCatalogNote(webCatalogNote, pageRequest);
		System.out.println("setCurrentCatalogNote:" + catalogNotes.getNumber());
		System.out.println("setTotalCatalogNotes:" + catalogNotes.getTotalPages());
		System.out.println("setTotalRecords:" + catalogNotes.getTotalElements());

		assertEquals(catalogNotes.getNumber() + 1, 1);
		assertEquals(catalogNotes.getTotalPages(), 1);
		assertEquals(catalogNotes.getTotalElements(), 1);
		assertEquals(catalogNotes.iterator().next().getUrl(), catalogNoteUrl);
	}

	@Test
	public void testFindCatalogNoteById() {
		CatalogNote CatalogNote = new CatalogNote();
		CatalogNote.setUrl("url");
		catalogService.saveCatalogNote(CatalogNote);
		int CatalogNote_id = CatalogNote.getId();
		CatalogNote = catalogService.findCatalogNoteById(CatalogNote_id);
		assertEquals("testFindCatalogNoteById CatalogNote_id:" + Integer.toString(CatalogNote_id), CatalogNote.getUrl(), "url");
	}

	@Test
	public void testFindCatalogNoteByCatalogNote() {
		assertEquals(0, 0);
	}

	@Test
	public void testSaveCatalogNote() {
		/* catalog locale */
		BaseLocale catalogLocale = new BaseLocale();
		catalogLocale.setContent("content");
		catalogLocale.setDescription("descrition");
		catalogLocale.setMenu("menu");
		catalogLocale.setTitle("title");
		catalogLocale.setWebDescription("webDescription");
		catalogLocale.setWebKeywords("webKeywords");
		catalogLocale.setWebTitle("webTitle");
		Map<String, BaseLocale> catalogLocales = new HashMap<String, BaseLocale>();
		catalogLocales.put("ru", catalogLocale);
		catalogLocales.put("en", new BaseLocale("menu en"));
		/* catalog */
		CatalogNote catalogNote = new CatalogNote();
		catalogNote.setIsShow(false);
		catalogNote.setIsShowInMenu(false);
		catalogNote.setLevel(1);
		catalogNote.setUrl("url");
		catalogNote.setCatalogNoteLocale(catalogLocales);
		/* catalog note parent */
		CatalogNote catalogNoteParent = new CatalogNote();
		catalogNoteParent.setUrl("parent");
		catalogService.saveCatalogNote(catalogNoteParent);
		catalogNote.setParentCatalogNote(catalogNoteParent);
		catalogService.saveCatalogNote(catalogNote);

		catalogNote = catalogService.findCatalogNoteById(catalogNote.getId());
		// /* test object */
		assertEquals(catalogNote.getIsShow(), false);
		assertEquals(catalogNote.getIsShowInMenu(), false);
		assertEquals(catalogNote.getLevel(), 1);
		assertEquals(catalogNote.getUrl(), "url");
		// /* test object parent */
		assertEquals(catalogNote.getParentCatalogNote().getUrl(), "parent");
		// /* test object locale */
		assertEquals(catalogNote.getCatalogNoteLocale().get("en").getMenu(), "menu en");
		assertEquals(catalogNote.getCatalogNoteLocale().get("ru").getContent(), "content");
		assertEquals(catalogNote.getCatalogNoteLocale().get("ru").getDescription(), "descrition");
		assertEquals(catalogNote.getCatalogNoteLocale().get("ru").getMenu(), "menu");
		assertEquals(catalogNote.getCatalogNoteLocale().get("ru").getTitle(), "title");
		assertEquals(catalogNote.getCatalogNoteLocale().get("ru").getWebDescription(), "webDescription");
		assertEquals(catalogNote.getCatalogNoteLocale().get("ru").getWebKeywords(), "webKeywords");
		assertEquals(catalogNote.getCatalogNoteLocale().get("ru").getWebTitle(), "webTitle");
		assertEquals(catalogNote.getCurrentCatalogNoteLocale().getContent(), "content");
		assertEquals(catalogNote.getCurrentCatalogNoteLocale().getDescription(), "descrition");
		assertEquals(catalogNote.getCurrentCatalogNoteLocale().getMenu(), "menu");
		assertEquals(catalogNote.getCurrentCatalogNoteLocale().getTitle(), "title");
		assertEquals(catalogNote.getCurrentCatalogNoteLocale().getWebDescription(), "webDescription");
		assertEquals(catalogNote.getCurrentCatalogNoteLocale().getWebKeywords(), "webKeywords");
		assertEquals(catalogNote.getCurrentCatalogNoteLocale().getWebTitle(), "webTitle");
		
		logger.info(catalogNote.toString());
		logger.info(catalogNote.getCatalogNoteLocale().toString());
	}

	@Test
	public void testDeleteCatalogNote() {
		CatalogNote catalogNote = new CatalogNote();
		catalogNote.setUrl("testDeleteCatalogNote");
		catalogService.saveCatalogNote(catalogNote);
		int catalogNoteId = catalogNote.getId();
		catalogService.deleteCatalogNote(catalogNoteId);
		assertNull("testDeleteCatalogNote CatalogNote_id:" + Integer.toString(catalogNoteId), catalogService.findCatalogNoteById(catalogNoteId));
	}

}
