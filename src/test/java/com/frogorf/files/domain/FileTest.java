/**
 * 
 */
package com.frogorf.files.domain;

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/** @author Tsurkin Alex
 * @version */
public class FileTest {

	/** @throws java.lang.Exception */
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	/** @throws java.lang.Exception */
	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	/** @throws java.lang.Exception */
	@Before
	public void setUp() throws Exception {
	}

	/** @throws java.lang.Exception */
	@After
	public void tearDown() throws Exception {
	}

	/** Test method for
	 * {@link com.frogorf.files.domain.File#File(java.lang.Integer, java.lang.String, java.lang.Integer, byte[])}
	 * . */
	@Test
	public void testFile() {
		String testContentType = "image/test";
		byte[] testBlob = new byte[] { 1, 2, 3 };
		Integer expId = 1;
		File expFile = new File(expId, testContentType, testBlob.length, testBlob);
		assertEquals(expFile.getId(), expId);
		assertEquals(expFile.getType(), testContentType);
		assertEquals(expFile.getSize(), (Integer) testBlob.length);
		assertEquals(expFile.getBlob(), testBlob);
	}

}
