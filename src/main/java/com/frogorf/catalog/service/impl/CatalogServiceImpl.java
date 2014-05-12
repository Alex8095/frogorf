/**
 * 
 */
package com.frogorf.catalog.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.frogorf.catalog.dao.CatalogDao;
import com.frogorf.catalog.domain.CatalogNote;
import com.frogorf.catalog.service.CatalogService;
import com.frogorf.web.core.dao.PageDao;

/** @author Tsurkin Alex
 * @version */
@Service("catalogService")
public class CatalogServiceImpl implements CatalogService {

	@Autowired
	private CatalogDao catalogDao;
	
	@Override
	@Transactional
	public List<CatalogNote> findCatalogNotes() {
		return catalogDao.findCatalogNotes();
	}

	@Override
	@Transactional
	public List<CatalogNote> findCatalogNotesByCatalogNote(CatalogNote catalogNote) {
		return catalogDao.findCatalogNotesByCatalogNote(catalogNote);
	}

	@Override
	@Transactional
	public Page<CatalogNote> findCatalogNotesByCatalogNote(CatalogNote catalogNote, Pageable pageable) {
		return catalogDao.findCatalogNotesByCatalogNote(catalogNote, pageable);
	}

	@Override
	@Transactional
	public CatalogNote findCatalogNoteById(int id) {
		return catalogDao.findCatalogNoteById(id);
	}

	@Override
	@Transactional
	public CatalogNote findCatalogNoteByCatalogNote(CatalogNote catalogNote) {
		return catalogDao.findCatalogNoteByCatalogNote(catalogNote);
	}

	@Override
	@Transactional
	public void saveCatalogNote(CatalogNote catalogNote) {
		catalogDao.saveCatalogNote(catalogNote);
	}

	@Override
	@Transactional
	public void deleteCatalogNote(int id) {
		catalogDao.deleteCatalogNote(id);
	}
	
}
