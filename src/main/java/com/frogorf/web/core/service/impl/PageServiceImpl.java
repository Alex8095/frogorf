/**
 * 
 */
package com.frogorf.web.core.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.frogorf.web.core.dao.PageDao;
import com.frogorf.web.core.domain.Page;
import com.frogorf.web.core.service.PageService;

/** @author Tsurkin Alex
 * @version */
@Service("coreService")
public class PageServiceImpl implements PageService {

	@Autowired
	private PageDao coreDao;

	/* @see com.frogorf.web.core.service.CoreService#findPages() */
	@Override
	@Transactional
	public List<Page> findPages() {
		return coreDao.findPages();
	}

	/* @see
	 * com.frogorf.web.core.service.CoreService#findPagesByPage(com.frogorf.
	 * web.core.domain.Page) */
	@Override
	@Transactional
	public List<Page> findPagesByPage(Page page) {
		return coreDao.findPagesByPage(page);
	}

	/* @see
	 * com.frogorf.web.core.service.CoreService#findPagesByPage(com.frogorf.
	 * web.core.domain.Page, org.springframework.data.domain.Pageable) */
	@Override
	@Transactional
	public org.springframework.data.domain.Page<Page> findPagesByPage(Page page, Pageable pageable) {
		return coreDao.findPagesByPage(page, pageable);
	}

	/* @see com.frogorf.web.core.service.CoreService#findPageById(int) */
	@Override
	@Transactional
	public Page findPageById(int id) {
		return coreDao.findPageById(id);
	}

	/* @see
	 * com.frogorf.web.core.service.CoreService#findPageByPage(com.frogorf.web
	 * .core.domain.Page) */
	@Override
	@Transactional
	public Page findPageByPage(Page page) {
		return coreDao.findPageByPage(page);
	}

	/* @see
	 * com.frogorf.web.core.service.CoreService#savePage(com.frogorf.web.core
	 * .domain.Page) */
	@Override
	@Transactional
	public void savePage(Page page) {
		coreDao.savePage(page);
	}

	/* @see com.frogorf.web.core.service.CoreService#deletePage(int) */
	@Override
	@Transactional
	public void deletePage(int id) {
		coreDao.deletePage(id);
	}
}
