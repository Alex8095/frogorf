/**
 * 
 */
package com.frogorf.web.core.domain;

import static org.junit.Assert.*;

import org.junit.Test;

/**
 * @author Tsurkin Alex
 * @version
 */
public class PageLocaleTest {

	@Test
	public void test() {
		PageLocale pageLocale = new PageLocale();
		pageLocale.setContent("content");
		pageLocale.setDescrition("descrition");
		pageLocale.setMenu("menu");
		pageLocale.setTitle("title");
		pageLocale.setWebDescription("webDescription");
		pageLocale.setWebKeywords("webKeywords");
		pageLocale.setWebTitle("webTitle");
		assertEquals(pageLocale.getContent(), "content");
		assertEquals(pageLocale.getDescrition(), "descrition");
		assertEquals(pageLocale.getMenu(), "menu");
		assertEquals(pageLocale.getTitle(), "title");
		assertEquals(pageLocale.getWebDescription(), "webDescription");
		assertEquals(pageLocale.getWebKeywords(), "webKeywords");
		assertEquals(pageLocale.getWebTitle(), "webTitle");
	}

}
