/**
 * 
 */
package com.frogorf.service;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;

import com.frogorf.files.service.FileService;
import com.frogorf.files.service.ImageService;

/** @author Tsurkin Alex
 * @version */
@Ignore
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:WEB-INF/spring/business-context.xml" })
@TransactionConfiguration(transactionManager = "transactionManager", defaultRollback = true)
@Transactional()
public abstract class AbstractBaseServiceImplTest {

	@Autowired
	protected FileService fileService;
	@Autowired
	protected ImageService imageService;


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
}
