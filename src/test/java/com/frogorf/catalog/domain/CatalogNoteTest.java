package com.frogorf.catalog.domain;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.frogorf.dictionary.domain.Dictionary;
import com.frogorf.dictionary.domain.DictionaryValue;
import com.frogorf.domain.BaseLocale;
import com.frogorf.web.core.domain.Domain;
import com.frogorf.web.core.domain.Page;
import com.frogorf.web.core.domain.PageTest;

public class CatalogNoteTest {

	private static final Logger logger = LoggerFactory.getLogger(PageTest.class);

	@Test
	public void test() {

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
		/* catalog */
		CatalogNote catalogNote = new CatalogNote();
		catalogNote.setIsShow(false);
		catalogNote.setIsShowInMenu(false);
		catalogNote.setLevel(1);
		catalogNote.setUrl("url");
		catalogNote.setCatalogNoteLocale(catalogLocales);
		/* test object */
		assertEquals(catalogNote.getIsShow(), false);
		assertEquals(catalogNote.getIsShowInMenu(), false);
		assertEquals(catalogNote.getLevel(), 1);
		assertEquals(catalogNote.getUrl(), "url");
		/* test object locale */
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
	}

}
