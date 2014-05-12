/**
 * 
 */
package com.frogorf.catalog.dao.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

import com.frogorf.catalog.dao.CatalogDao;
import com.frogorf.catalog.domain.CatalogNote;

/** @author Tsurkin Alex
 * @version */
@Repository("catalogDao")
public class CatalogDaoImpl implements CatalogDao {

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public List<CatalogNote> findCatalogNotes() {
		return sessionFactory.getCurrentSession().createQuery("from CatalogNote").list();
	}

	@Override
	public List<CatalogNote> findCatalogNotesByCatalogNote(CatalogNote catalogNote) {
		Criteria criteria = sessionFactory.getCurrentSession().createCriteria(CatalogNote.class);
		if (catalogNote != null) {
			if (catalogNote.getUrl() != null)
				criteria.add(Restrictions.eq("url", catalogNote.getUrl()));
		}
		return criteria.list();
	}

	@Override
	public Page<CatalogNote> findCatalogNotesByCatalogNote(CatalogNote catalogNote, Pageable pageable) {
		List<CatalogNote> l = findCatalogNotesByCatalogNote(catalogNote);
		return new PageImpl<CatalogNote>(l, pageable, l.size());
	}

	@Override
	public CatalogNote findCatalogNoteById(int id) {
		return (CatalogNote) sessionFactory.getCurrentSession().get(CatalogNote.class, id);
	}

	@Override
	public CatalogNote findCatalogNoteByCatalogNote(CatalogNote catalogNote) {
		List<CatalogNote> l = findCatalogNotesByCatalogNote(catalogNote);
		return (l.size() > 0 ? l.get(0) : null);
	}

	@Override
	public void saveCatalogNote(CatalogNote catalogNote) {
		sessionFactory.getCurrentSession().saveOrUpdate(catalogNote);
	}

	@Override
	public void deleteCatalogNote(int id) {
		sessionFactory.getCurrentSession().delete(findCatalogNoteById(id));
	}
}
