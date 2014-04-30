package com.frogorf.web.core.support;

import com.frogorf.web.core.service.PageService;

public class PageBreadCrumbSupport {
	private PageService pageService;

	public PageBreadCrumbSupport() {
	}

	public PageBreadCrumbSupport(PageService pageService) {
		this.pageService = pageService;
	}
}
