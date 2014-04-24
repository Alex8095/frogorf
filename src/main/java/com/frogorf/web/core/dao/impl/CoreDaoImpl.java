/**
 * 
 */
package com.frogorf.web.core.dao.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

import com.frogorf.web.core.dao.CoreDao;
import com.frogorf.web.core.domain.Page;

/** @author Tsurkin Alex
 * @version */
@Repository("coreDao")
public class CoreDaoImpl implements CoreDao {

	@Autowired
	private SessionFactory sessionFactory;

	/* @see com.frogorf.web.core.dao.CoreDao#findPages() */
	@Override
	public List<Page> findPages() {
		return sessionFactory.getCurrentSession().createQuery("from Page").list();
	}

	/* @see
	 * com.frogorf.web.core.dao.CoreDao#findPagesByPage(com.frogorf.web.core
	 * .domain.Page) */
	@Override
	public List<Page> findPagesByPage(Page page) {
		Criteria criteria = sessionFactory.getCurrentSession().createCriteria(Page.class);
		if (page != null) {
			if (page.getAction() != null)
				criteria.add(Restrictions.eq("action", page.getAction()));
			if (page.getController() != null)
				criteria.add(Restrictions.eq("controller", page.getController()));
			if (page.getUrl() != null)
				criteria.add(Restrictions.eq("url", page.getUrl()));
			// if (tutorial.getSubject() != null)
			// criteria.add(Restrictions.like("subject", tutorial.getSubject() +
			// "%"));
		}
		return criteria.list();
	}

	/* @see
	 * com.frogorf.web.core.dao.CoreDao#findPagesByPage(com.frogorf.web.core
	 * .domain.Page, org.springframework.data.domain.Pageable) */
	@Override
	public org.springframework.data.domain.Page<Page> findPagesByPage(Page page, Pageable pageable) {
		List<Page> l = findPagesByPage(page);
		return new PageImpl<Page>(l, pageable, l.size());
	}

	/* @see com.frogorf.web.core.dao.CoreDao#findPageById(int) */
	@Override
	public Page findPageById(int id) {
		return (Page) sessionFactory.getCurrentSession().get(Page.class, id);
	}

	/* @see
	 * com.frogorf.web.core.dao.CoreDao#findPageByPage(com.frogorf.web.core.
	 * domain.Page) */
	@Override
	public Page findPageByPage(Page page) {
		return null;
	}

	/* @see
	 * com.frogorf.web.core.dao.CoreDao#savePage(com.frogorf.web.core.domain
	 * .Page) */
	@Override
	public void savePage(Page page) {
		sessionFactory.getCurrentSession().saveOrUpdate(page);
	}

	/* @see com.frogorf.web.core.dao.CoreDao#deletePage(int) */
	@Override
	@SuppressWarnings("unchecked")
	public void deletePage(int id) {
		sessionFactory.getCurrentSession().delete(findPageById(id));
	}
}
