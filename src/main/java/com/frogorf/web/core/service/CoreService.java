/**
 * 
 */
package com.frogorf.web.core.service;

import java.util.List;

import org.springframework.data.domain.Pageable;

import com.frogorf.web.core.domain.Page;

/** @author Tsurkin Alex
 * @version */
public interface CoreService {

	public List<Page> findPages();

	public List<Page> findPagesByPage(Page page);

	public org.springframework.data.domain.Page<Page> findPagesByPage(Page page, Pageable pageable);

	public Page findPageById(int id);

	public Page findPageByPage(Page page);

	public void savePage(Page page);

	public void deletePage(int id);
}
