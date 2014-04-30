package com.frogorf.web.aspect;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.frogorf.web.core.domain.Page;
import com.frogorf.web.core.domain.PageLocale;
import com.frogorf.web.core.service.PageService;
import com.frogorf.web.core.support.PageBreadCrumbSupport;
import com.frogorf.web.core.support.PageMenuSupport;

@Aspect
public class PageAspect {
	private static final Logger logger = LoggerFactory.getLogger(PageAspect.class);
	private static final String LOCALE_DEFAULT_PARAM_NAME = "lang_code";

	private static final String BREAD_CRUMB_LINKS = "breadCrumb";
	private static final String CURRENT_PAGE = "currentPage";
	private static final String CURRENT_PAGE_LOCALE = "currentPageLocale";
	private static final String PAGE_MENU_LINKS = "pageMenu";

	private HttpServletRequest request;
	private Page page;

	@Autowired
	PageService pageService;

	private PageBreadCrumbSupport pageBreadCrumbSupport;
	private PageMenuSupport pageMenuSupport;

	private Map<String, String> currentPageParam = new HashMap<String, String>();
	private PageLocale currentPage = new PageLocale();

	public PageAspect() {
	}

	@Pointcut("within(@org.springframework.stereotype.Controller *)")
	public void controller() {
	}

	@Pointcut("execution(* *(..))")
	public void method() {
	}

	@Before("controller() && method()")
	public void doAccessCheck(JoinPoint joinPoint) {
		logger.info(joinPointNiceName(joinPoint));
		localeChangeListener();
		getCurrentHttpServletRequest();
		setEmptySessionAttributes();
		processPageLocale(joinPoint);
		processPageMenu();
	}

	private String joinPointNiceName(JoinPoint joinPoint) {
		return String.format("JoinPoint [target: %s, signature: %s, args: %s]", joinPoint.getTarget().getClass(), joinPoint.getSignature().getName(), Arrays.toString(joinPoint.getArgs()));
	}

	private void getCurrentHttpServletRequest() {
		request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
	}

	private void setEmptySessionAttributes() {
		request.getSession().setAttribute(BREAD_CRUMB_LINKS, new ArrayList<Page>());
		request.getSession().setAttribute(CURRENT_PAGE_LOCALE, new PageLocale("home"));
		request.getSession().setAttribute(PAGE_MENU_LINKS, new ArrayList<Page>());
		request.getSession().setAttribute(CURRENT_PAGE, new Page());

	}

	private void processPageLocale(JoinPoint joinPoint) {
		currentPageParam.put("controller", joinPoint.getTarget().getClass().getName().substring(joinPoint.getTarget().getClass().getName().lastIndexOf('.') + 1));
		currentPageParam.put("action", joinPoint.getSignature().getName());
		page = pageService.findPageByPage(new Page(currentPageParam.get("controller"), currentPageParam.get("action"), true));
		if (page != null) {
			logger.info(page.toString());
			request.getSession().setAttribute(CURRENT_PAGE, page);
			request.getSession().setAttribute(CURRENT_PAGE_LOCALE, page.getCurrentPageLocale(Locale.getDefault().getLanguage()));
		}
	}

	private void localeChangeListener() {
		HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
		String newLocale = request.getParameter(LOCALE_DEFAULT_PARAM_NAME);
		if (newLocale != null) {
			logger.info(newLocale.substring(0, 2));
			Locale.setDefault(new Locale(newLocale.substring(0, 2)));
		}
	}

	/* page menu */
	private void processPageMenu() {
		pageMenuSupport = new PageMenuSupport(pageService);
		pageMenuSupport.process();
		if (pageMenuSupport.getPages() != null) {
			request.getSession().setAttribute(PAGE_MENU_LINKS, pageMenuSupport.getPages());
		}
	}

	/* page menu */
	private void processPageBreadCrumb() {
		pageBreadCrumbSupport = new PageBreadCrumbSupport(pageService);

	}
}
