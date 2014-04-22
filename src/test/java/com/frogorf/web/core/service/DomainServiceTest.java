/**
 * 
 */
package com.frogorf.web.core.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import java.util.List;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.frogorf.service.AbstractBaseServiceTest;
import com.frogorf.web.core.domain.Domain;

/** @author Tsurkin Alex
 * @version */
public class DomainServiceTest extends AbstractBaseServiceTest {

	private static final Logger logger = LoggerFactory.getLogger(DomainServiceTest.class);

	@Autowired
	protected DomainService domainService;

	/** Test method for
	 * {@link com.frogorf.web.core.service.impl.DomainServiceImpl#findDomains()}
	 * . */
	@Test
	public void testFindDomains() {
		List<Domain> domains = domainService.findDomains();
		int count = domains.size();
		Domain domain = new Domain();
		domain.setUrl("url");
		domainService.saveDomain(domain);
		assertEquals(count + 1, domainService.findDomains().size());
	}

	/** Test method for
	 * {@link com.frogorf.web.core.service.impl.DomainServiceImpl#findDomainById(int)}
	 * . */
	@Test
	public void testFindDomainById() {
		Domain domain = new Domain();
		domain.setUrl("url");
		domainService.saveDomain(domain);
		assertEquals(domainService.findDomainById(domain.getId()).getUrl(), "url");
	}

	/** Test method for
	 * {@link com.frogorf.web.core.service.impl.DomainServiceImpl#saveDomain(com.frogorf.web.core.domain.Domain)}
	 * . */
	@Test
	public void testSaveDomain() {
		Domain domain = new Domain();
		domain.setUrl("url");
		domainService.saveDomain(domain);
		assertEquals(domainService.findDomainById(domain.getId()).getUrl(), "url");
	}

	/** Test method for
	 * {@link com.frogorf.web.core.service.impl.DomainServiceImpl#deleteDomain(int)}
	 * . */
	@Test
	public void testDeleteDomain() {
		Domain domain = new Domain();
		domain.setUrl("url");
		domainService.saveDomain(domain);
		int domain_id = domain.getId();
		domainService.deleteDomain(domain_id);
		assertNull(domainService.findDomainById(domain.getId()));

	}

}
