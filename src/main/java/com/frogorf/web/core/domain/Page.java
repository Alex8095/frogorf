/**
 * 
 */
package com.frogorf.web.core.domain;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.CollectionOfElements;
import org.hibernate.annotations.MapKey;

import com.frogorf.domain.BaseEntity;

/** @author Tsurkin Alex
 * @version */
@Entity
@Table(name = "page")
public class Page extends BaseEntity {

	@Column
	private String controller;
	@Column
	private String action;
	@Column
	private String url;
	@Column
	private int level;
	@Column(name = "is_show")
	private Boolean isShow;
	@Column(name = "is_authorized")
	private Boolean isAuthorized;
	@Column(name = "is_show_in_menu")
	private Boolean isShowInMenu;

	@ManyToMany
	@JoinTable(name = "page_domain", joinColumns = @JoinColumn(name = "page_id"), inverseJoinColumns = @JoinColumn(name = "domain_id"))
	private List<Domain> domains;

	@ManyToOne
	@JoinTable(name = "page_parent", joinColumns = @JoinColumn(name = "page_id"), inverseJoinColumns = @JoinColumn(name = "parent_id"))
	private Page page;
	@ManyToMany
	@JoinTable(name = "page_parent", joinColumns = @JoinColumn(name = "parent_id"), inverseJoinColumns = @JoinColumn(name = "page_id"))
	private List<Page> pages;

	@JoinTable(name = "page_locale")
	@CollectionOfElements(targetElement = PageLocale.class)
	@MapKey(targetElement = String.class, columns = @Column(name = "language_code"))
	private Map<String, PageLocale> pageLocale = new HashMap<String, PageLocale>();

	public Page() {
	}

	/** @return the controller */
	public String getController() {
		return controller;
	}

	/** @param controller the controller to set */
	public void setController(String controller) {
		this.controller = controller;
	}

	/** @return the action */
	public String getAction() {
		return action;
	}

	/** @param action the action to set */
	public void setAction(String action) {
		this.action = action;
	}

	/** @return the url */
	public String getUrl() {
		return url;
	}

	/** @param url the url to set */
	public void setUrl(String url) {
		this.url = url;
	}

	/** @return the level */
	public int getLevel() {
		return level;
	}

	/** @param level the level to set */
	public void setLevel(int level) {
		this.level = level;
	}

	/** @return the isShow */
	public Boolean getIsShow() {
		return isShow;
	}

	/** @param isShow the isShow to set */
	public void setIsShow(Boolean isShow) {
		this.isShow = isShow;
	}

	/** @return the isAuthorized */
	public Boolean getIsAuthorized() {
		return isAuthorized;
	}

	/** @param isAuthorized the isAuthorized to set */
	public void setIsAuthorized(Boolean isAuthorized) {
		this.isAuthorized = isAuthorized;
	}

	/** @return the isShowInMenu */
	public Boolean getIsShowInMenu() {
		return isShowInMenu;
	}

	/** @param isShowInMenu the isShowInMenu to set */
	public void setIsShowInMenu(Boolean isShowInMenu) {
		this.isShowInMenu = isShowInMenu;
	}

	/** @return the page */
	public Page getPage() {
		return page;
	}

	/** @param page the page to set */
	public void setPage(Page page) {
		this.page = page;
	}

	/** @return the pages */
	public List<Page> getPages() {
		return pages;
	}

	/** @param pages the pages to set */
	public void setPages(List<Page> pages) {
		this.pages = pages;
	}

	/** @return the pageLocale */
	public Map<String, PageLocale> getPageLocale() {
		return pageLocale;
	}

	/** @param pageLocale the pageLocale to set */
	public void setPageLocale(Map<String, PageLocale> pageLocale) {
		this.pageLocale = pageLocale;
	}

	/** @return the domains */
	public List<Domain> getDomains() {
		return domains;
	}

	/** @param domains the domains to set */
	public void setDomains(List<Domain> domains) {
		this.domains = domains;
	}

	public PageLocale getCurrentPageLocale() {
		return getPageLocale().get(getLocaleLanguage());
	}
}
