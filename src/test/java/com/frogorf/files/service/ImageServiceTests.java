/**
 * 
 */
package com.frogorf.files.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import java.util.List;

import org.junit.Test;

import com.frogorf.files.domain.File;
import com.frogorf.files.domain.Image;
import com.frogorf.service.AbstractBaseServiceImplTest;

/** @author Tsurkin Alex
 * @version */
public class ImageServiceTests extends AbstractBaseServiceImplTest {

	/** Test method for
	 * {@link com.frogorf.files.service.impl.ImageServiceImpl#getImages()}. */
	@Test
	public void testGetImages() {
		List<Image> images = this.imageService.getImages();
		int found = images.size();
		Image image = new Image();
		image.setName("name");
		this.imageService.saveImage(image);
		images = this.imageService.getImages();
		assertEquals("Verifying number of  after inserting a new one.", found + 1, images.size());
	}

	/** Test method for
	 * {@link com.frogorf.files.service.ImageService#createImage(java.lang.String, java.lang.String, byte[])
	 * . */
	@Test
	public void testCreateFile() {
		String testName = "name";
		String testViewContentType = "image/test";
		byte[] testViewBlob = new byte[] { 1, 2, 3 };
		Image image = imageService.createImage(testName, testViewContentType, testViewBlob);
		Image imageGet = imageService.getImageById(image.getId());
		assertEquals(testName, imageGet.getName());
		assertEquals(image.getViewFile(), imageGet.getViewFile());
		assertEquals(image.getImageFile(), imageGet.getImageFile());
	}

	/** Test method for
	 * {@link com.frogorf.files.service.impl.ImageServiceImpl#getImageById(int)}
	 * . */
	@Test
	public void testGetImageById() {
		String testViewContentType = "image/test";
		byte[] testViewBlob = new byte[] { 1, 2, 3 };
		File testViewFile = new File(testViewContentType, testViewBlob.length, testViewBlob);
		String testImageContentType = "image/test";
		byte[] testImageBlob = new byte[] { 1, 2, 3 };
		File testImageFile = new File(testImageContentType, testImageBlob.length, testImageBlob);
		String imageName = "image";
		Image image = new Image(imageName, testViewFile, testImageFile);
		imageService.saveImage(image);
		Image imageGet = imageService.getImageById(image.getId());
		assertEquals(image.getName(), imageGet.getName());
		assertEquals(image.getViewFile(), imageGet.getViewFile());
		assertEquals(image.getImageFile(), imageGet.getImageFile());
	}

	/** Test method for
	 * {@link com.frogorf.files.service.impl.ImageServiceImpl#saveImage(com.frogorf.files.domain.Image)}
	 * . */
	@Test
	public void testSaveImage() {
		String testViewContentType = "image/test";
		byte[] testViewBlob = new byte[] { 1, 2, 3 };
		File testViewFile = new File(testViewContentType, testViewBlob.length, testViewBlob);
		String testImageContentType = "image/test";
		byte[] testImageBlob = new byte[] { 1, 2, 3 };
		File testImageFile = new File(testImageContentType, testImageBlob.length, testImageBlob);
		String imageName = "image";
		Image image = new Image(imageName, testViewFile, testImageFile);
		imageService.saveImage(image);

		assertEquals(image.getName(), imageName);
		assertEquals(image.getViewFile(), testViewFile);
		assertEquals(image.getImageFile(), testImageFile);
	}

	/** Test method for
	 * {@link com.frogorf.files.service.impl.ImageServiceImpl#deleteImage(int)}. */
	@Test
	public void testDeleteImage() {
		String testViewContentType = "image/test";
		byte[] testViewBlob = new byte[] { 1, 2, 3 };
		File testViewFile = new File(testViewContentType, testViewBlob.length, testViewBlob);
		String testImageContentType = "image/test";
		byte[] testImageBlob = new byte[] { 1, 2, 3 };
		File testImageFile = new File(testImageContentType, testImageBlob.length, testImageBlob);
		String imageName = "image";
		Image image = new Image(imageName, testViewFile, testImageFile);
		imageService.saveImage(image);
		imageService.deleteImage(image.getId());
		Image imageGet = imageService.getImageById(image.getId());
		assertNull(imageGet);
	}

}
