/**
 * 
 */
package com.frogorf.catalog.dao.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.hibernate.Query;
import org.hibernate.SQLQuery;
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
		System.out.println(catalogNote.toString());
		Map<String, Object> parameters = new HashMap<String, Object>();
		StringBuffer query = new StringBuffer();
		if (catalogNote.getUrl() != null) {
			query.append(" cn.url = :url ");
			parameters.put("url", catalogNote.getUrl());
		}
		if (catalogNote.getParentCatalogNote() != null) {
			query.append((query.length() > 0 ? " and " : "") + " cn.parent_id = :parent_id");
			parameters.put("parent_id", catalogNote.getParentCatalogNote().getId());
		}
		SQLQuery sqlQuery = sessionFactory
				.getCurrentSession()
				.createSQLQuery(
						"select cn.*, cnl.* from catalog_note cn left join catalog_note_locale cnl on cn.id = cnl.catalog_note_id and cnl.language_code = 'ru' " + (query.length() > 0 ? " where" : "")
								+ query).addEntity("cn", CatalogNote.class);
		if (parameters.size() > 0)
			for (String key : parameters.keySet()) {
				sqlQuery.setParameter(key, parameters.get(key));
			}
		return sqlQuery.list();
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
