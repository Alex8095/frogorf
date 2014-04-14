/**
 * 
 */
package com.frogorf.domain;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.transaction.annotation.Transactional;

import com.frogorf.tutorial.domain.Book;
import com.frogorf.tutorial.domain.Tutorial;

/** @author Tsurkin Alex
 * @version */
public class TutorialTest {

	private static final Logger logger = LoggerFactory.getLogger(TutorialTest.class);

	@Test
	@Transactional
	public void testTutorial() {
		Tutorial tutorial = new Tutorial();
		Book book = new Book();
		book.setName("name");
		assertNull(tutorial.getBook());
		tutorial.setBook(book);
		assertEquals(book, tutorial.getBook());
	}
}
