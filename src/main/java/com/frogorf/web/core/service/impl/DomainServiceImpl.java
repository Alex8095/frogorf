/**
 * 
 */
package com.frogorf.web.core.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.frogorf.web.core.dao.DomainDao;
import com.frogorf.web.core.domain.Domain;
import com.frogorf.web.core.service.DomainService;

/** @author Tsurkin Alex
 * @version */
@Service("domainService")
public class DomainServiceImpl implements DomainService {

	@Autowired
	private DomainDao domainDao;

	/* @see com.frogorf.web.core.service.CoreService#findPages() */
	@Override
	@Transactional
	public List<Domain> findDomains() {
		return domainDao.findDomains();
	}

	/* @see com.frogorf.web.core.service.CoreService#findPageById(int) */
	@Override
	@Transactional
	public Domain findDomainById(int id) {
		return domainDao.findDomainById(id);
	}

	/* @see
	 * com.frogorf.web.core.service.CoreService#savePage(com.frogorf.web.core
	 * .domain.Page) */
	@Override
	@Transactional
	public void saveDomain(Domain domain) {
		domainDao.saveDomain(domain);
	}

	/* @see com.frogorf.web.core.service.CoreService#deletePage(int) */
	@Override
	@Transactional
	public void deleteDomain(int id) {
		domainDao.deleteDomain(id);
	}
}
