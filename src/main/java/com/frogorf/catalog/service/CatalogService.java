/**
 * 
 */
package com.frogorf.catalog.service;

import java.util.List;

import org.springframework.data.domain.Pageable;

import com.frogorf.catalog.domain.CatalogNote;

/** @author Tsurkin Alex
 * @version */
public interface CatalogService {

	public List<CatalogNote> findCatalogNotes();

	public List<CatalogNote> findCatalogNotesByCatalogNote(CatalogNote catalogNote);

	public org.springframework.data.domain.Page<CatalogNote> findCatalogNotesByCatalogNote(CatalogNote catalogNote, Pageable pageable);

	public CatalogNote findCatalogNoteById(int id);

	public CatalogNote findCatalogNoteByCatalogNote(CatalogNote catalogNote);

	public void saveCatalogNote(CatalogNote catalogNote);

	public void deleteCatalogNote(int id);
}
