/**
 * 
 */
package com.frogorf.web.core.domain;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.CollectionOfElements;
import org.hibernate.annotations.MapKey;
import org.hibernate.validator.constraints.NotEmpty;

import com.frogorf.domain.BaseEntity;

/** @author Tsurkin Alex
 * @version */
@Entity
@Table(name = "page")
public class Page extends BaseEntity {

	@Column
	@NotEmpty
	private String controller;
	@Column
	@NotEmpty
	private String action;
	@Column
	private String url;
	@Column
	@NotNull
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
	private Page parentPage;
	@ManyToMany
	@JoinTable(name = "page_parent", joinColumns = @JoinColumn(name = "parent_id"), inverseJoinColumns = @JoinColumn(name = "page_id"))
	private List<Page> pages;

	@JoinTable(name = "page_locale")
	@CollectionOfElements(targetElement = PageLocale.class, fetch = FetchType.EAGER)
	@MapKey(targetElement = String.class, columns = @Column(name = "language_code"))
	private Map<String, PageLocale> pageLocale = new HashMap<String, PageLocale>();

	public Page() {
	}

	public Page(String controller, String action, Boolean isShow) {
		super();
		this.controller = controller;
		this.action = action;
		this.isShow = isShow;
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

	public Page getParentPage() {
		return parentPage;
	}

	public void setParentPage(Page parentPage) {
		this.parentPage = parentPage;
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

	public PageLocale getCurrentPageLocale(String localeCode) {
		return getPageLocale().get(localeCode);
	}

	public PageLocale getCurrentPageLocale() {
		return getPageLocale().get(getLocaleLanguage());
	}

	@Override
	public String toString() {
		return "Page [controller=" + controller + ", action=" + action + ", url=" + url + ", level=" + level + ", isShow=" + isShow + ", isAuthorized=" + isAuthorized + ", isShowInMenu="
				+ isShowInMenu + ", pageLocale=" + pageLocale + "]";
	}

}
