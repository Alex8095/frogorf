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
public class ImageTest {

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

	/** Test method for {@link com.frogorf.files.domain.Image#Image()}. */
	@Test
	public void testImage() {
		String testViewContentType = "image/test";
		byte[] testViewBlob = new byte[] { 1, 2, 3 };
		File testViewFile = new File(testViewContentType, testViewBlob.length, testViewBlob);
		String testImageContentType = "image/test";
		byte[] testImageBlob = new byte[] { 1, 2, 3 };
		File testImageFile = new File(testImageContentType, testImageBlob.length, testImageBlob);
		String imageName = "image";
		Image image = new Image(imageName, testViewFile, testImageFile);

		assertEquals(image.getName(), imageName);
		assertEquals(image.getViewFile(), testViewFile);
		assertEquals(image.getImageFile(), testImageFile);
	}

}
