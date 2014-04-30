package com.frogorf.web.core.support;

import com.frogorf.web.core.domain.Page;
import com.frogorf.web.core.service.PageService;

public class PageMenuSupport extends AbstractPageSupport {

	public PageMenuSupport(PageService pageService) {
		super(pageService);
	}

	public void process() {
		Page page = new Page();
		page.setIsShow(true);
		// page.setIsShowInMenu(true);
		pages = this.pageService.findPages();
	}
}
