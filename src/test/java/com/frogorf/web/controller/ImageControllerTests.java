/**
 * 
 */
package com.frogorf.web.controller;

import static org.junit.Assert.assertEquals;
import static org.mockito.Matchers.any;
import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.io.IOException;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.mock.web.MockMultipartFile;

import com.frogorf.files.domain.File;
import com.frogorf.files.domain.Image;
import com.frogorf.files.service.ImageService;
import com.frogorf.web.controller.ImageController;

/** @author Tsurkin Alex
 * @version */
@RunWith(MockitoJUnitRunner.class)
public class ImageControllerTests {

	@Mock
	ImageService imageServiceMock;
	@InjectMocks
	private ImageController controller;

	public ImageControllerTests() {
	}

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
	 * {@link com.frogorf.web.controller.ImageController#imageUpload(org.springframework.web.multipart.MultipartFile)}
	 * .
	 * 
	 * @throws IOException */
	@Test
	public void testImageUpload() throws IOException {
		String testFileName = "name";
		String testOriginalFileName = "originalname";
		String testContentType = "content_type";
		byte[] testBlob = new byte[] { 1, 2, 3, };
		MockMultipartFile testFile = new MockMultipartFile(testFileName, testOriginalFileName, testContentType, testBlob);
		File expFile = new File(testContentType, testBlob.length, testBlob);
		Image expImage = new Image(1, testOriginalFileName, expFile, expFile);

		when(imageServiceMock.createImage(anyString(), anyString(), any(byte[].class))).thenReturn(expImage);
		/* action */
		String result = controller.imageUpload(testFile);
		/* result */
		verify(imageServiceMock).createImage(testOriginalFileName, testContentType, testBlob);
		assertEquals(result, expImage.getId().toString());
	}

	@Test
	public void testImageUploadNull() throws IOException {
		String testFileName = "name";
		String testOriginalFileName = "originalname";
		String testContentType = "content_type";
		byte[] testBlob = new byte[] { 1, 2, 3, };
		MockMultipartFile testFile = new MockMultipartFile(testFileName, testOriginalFileName, testContentType, testBlob);

		String result = controller.imageUpload(testFile);
		System.out.println(result);
		assertEquals(result, "null");
	}

}
