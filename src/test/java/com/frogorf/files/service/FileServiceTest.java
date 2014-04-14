/**
 * 
 */
package com.frogorf.files.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import org.junit.Test;

import com.frogorf.files.domain.File;
import com.frogorf.service.AbstractBaseServiceImplTest;

/** @author Tsurkin Alex
 * @version */
public class FileServiceTest extends AbstractBaseServiceImplTest {

	// @Autowired
	// FileDao fileDao;

	/** Test method for
	 * {@link com.frogorf.files.service.impl.FileServiceImpl#getFileById(int)}. */
	@Test
	public void testGetFileById() {
		String testContentType = "image/test";
		byte[] testBlob = new byte[] { 1, 2, 3 };
		File expFile = new File(testContentType, testBlob.length, testBlob);
		fileService.saveFile(expFile);
		File fileById = fileService.getFileById(expFile.getId());
		assertEquals(expFile.getId(), fileById.getId());
		assertEquals(expFile.getType(), fileById.getType());
		assertEquals(expFile.getSize(), fileById.getSize());
		assertEquals(expFile.getBlob(), fileById.getBlob());
	}

	/** Test method for
	 * {@link com.frogorf.files.service.impl.FileServiceImpl#saveFile(com.frogorf.files.domain.File)}
	 * . */
	@Test
	public void testSaveFile() {
		String testContentType = "image/test";
		byte[] testBlob = new byte[] { 1, 2, 3 };
		File expFile = new File(testContentType, testBlob.length, testBlob);
		fileService.saveFile(expFile);
		assertEquals(expFile.getType(), testContentType);
		assertEquals(expFile.getSize(), (Integer) testBlob.length);
		assertEquals(expFile.getBlob(), testBlob);
	}

	/** Test method for
	 * {@link com.frogorf.files.service.impl.FileServiceImpl#deleteFile(int)}. */
	@Test
	public void testDeleteFile() {
		String testContentType = "image/test";
		byte[] testBlob = new byte[] { 1, 2, 3 };
		File expFile = new File(testContentType, testBlob.length, testBlob);
		fileService.saveFile(expFile);
		fileService.deleteFile(expFile.getId());
		File fileById = fileService.getFileById(expFile.getId());
		assertNull(fileById);
	}

}
