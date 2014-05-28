package com.frogorf.parenttest.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.fail;

import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.frogorf.parenttest.ParentTest;
import com.frogorf.parenttest.ParentTestService;
import com.frogorf.service.AbstractBaseServiceTest;

public class ParentTestServiceTest extends AbstractBaseServiceTest {

	@Autowired
	protected ParentTestService parentTestService;

	private static final Logger logger = LoggerFactory.getLogger(ParentTestServiceTest.class);

	@Before
	public void setUp() throws Exception {
		super.setUp();
	}

	@Test
	public void testFindParentTestsByParentTest() {
		fail("Not yet implemented");
	}

	@Test
	public void testSaveParentTest() {
		ParentTest parentTest = new ParentTest();
		parentTest.setName("name");
		parentTestService.saveParentTest(parentTest);
		int id = parentTest.getId();
		assertEquals(1, id);
		parentTestService.deleteParentTest(id);
		assertNull(parentTestService.findParentTestById(id));
	}

}
