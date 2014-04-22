/**
 * 
 */
package com.frogorf.web.core.domain;

import static org.junit.Assert.*;

import org.junit.Test;

/** @author Tsurkin Alex
 * @version */
public class DomainTest {

	@Test
	public void test() {
		Domain domain = new Domain();
		domain.setUrl("url");
		assertEquals(domain.getUrl(), "url");
	}

}
