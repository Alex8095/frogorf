package com.frogorf.web.core.support;

import java.util.List;

import com.frogorf.web.core.domain.Page;
import com.frogorf.web.core.service.PageService;

abstract class AbstractPageSupport {
	protected PageService pageService;
	protected Page currentPage;
	protected List<Page> pages;

	public PageService getPageService() {
		return pageService;
	}

	public void setPageService(PageService pageService) {
		this.pageService = pageService;
	}

	public Page getCurrentPage() {
		return currentPage;
	}

	public void setCurrentPage(Page currentPage) {
		this.currentPage = currentPage;
	}

	public List<Page> getPages() {
		return pages;
	}

	public void setPages(List<Page> pages) {
		this.pages = pages;
	}

	public void process() {

	}

	public AbstractPageSupport() {
	}

	public AbstractPageSupport(PageService pageService) {
		super();
		this.pageService = pageService;
	}

	public AbstractPageSupport(PageService pageService, Page currentPage) {
		super();
		this.pageService = pageService;
		this.currentPage = currentPage;
	}

	public AbstractPageSupport(PageService pageService, Page currentPage, List<Page> pages) {
		super();
		this.pageService = pageService;
		this.currentPage = currentPage;
		this.pages = pages;
	}

}
