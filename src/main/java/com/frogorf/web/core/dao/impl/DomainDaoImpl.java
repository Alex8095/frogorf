/**
 * 
 */
package com.frogorf.web.core.dao.impl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

import com.frogorf.dictionary.domain.Dictionary;
import com.frogorf.web.core.dao.CoreDao;
import com.frogorf.web.core.dao.DomainDao;
import com.frogorf.web.core.domain.Domain;
import com.frogorf.web.core.domain.Page;

/**
 * @author Tsurkin Alex
 * @version
 */
@Repository("domainDao")
public class DomainDaoImpl implements DomainDao {

	@Autowired
	private SessionFactory sessionFactory;

	/* @see com.frogorf.web.core.dao.CoreDao#findPages() */
	@Override
	public List<Domain> findDomains() {
		return sessionFactory.getCurrentSession().createQuery("from Domain").list();
	}

	/* @see com.frogorf.web.core.dao.CoreDao#findPageById(int) */
	@Override
	public Domain findDomainById(int id) {
		return (Domain) sessionFactory.getCurrentSession().get(Domain.class, id);
	}

	/*
	 * @see
	 * com.frogorf.web.core.dao.CoreDao#savePage(com.frogorf.web.core.domain
	 * .Page)
	 */
	@Override
	public void saveDomain(Domain domain) {
		sessionFactory.getCurrentSession().saveOrUpdate(domain);
	}

	/* @see com.frogorf.web.core.dao.CoreDao#deletePage(int) */
	@Override
	public void deleteDomain(int id) {
		sessionFactory.getCurrentSession().delete(findDomainById(id));
	}
}
