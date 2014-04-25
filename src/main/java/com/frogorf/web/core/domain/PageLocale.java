/**
 * 
 */
package com.frogorf.web.core.domain;

import javax.persistence.Column;
import javax.persistence.Embeddable;

/** @author Tsurkin Alex
 * @version */
@Embeddable
public class PageLocale {

	@Column(name = "web_title")
	private String webTitle;
	@Column(name = "web_description")
	private String webDescription;
	@Column(name = "web_keywords")
	private String webKeywords;
	@Column
	private String menu;
	@Column
	private String title;
	@Column
	private String description;
	@Column
	private String content;

	/** @return the webTitle */
	public String getWebTitle() {
		return webTitle;
	}

	/** @param webTitle the webTitle to set */
	public void setWebTitle(String webTitle) {
		this.webTitle = webTitle;
	}

	/** @return the webDescription */
	public String getWebDescription() {
		return webDescription;
	}

	/** @param webDescription the webDescription to set */
	public void setWebDescription(String webDescription) {
		this.webDescription = webDescription;
	}

	/** @return the webKeywords */
	public String getWebKeywords() {
		return webKeywords;
	}

	/** @param webKeywords the webKeywords to set */
	public void setWebKeywords(String webKeywords) {
		this.webKeywords = webKeywords;
	}

	/** @return the menu */
	public String getMenu() {
		return menu;
	}

	/** @param menu the menu to set */
	public void setMenu(String menu) {
		this.menu = menu;
	}

	/** @return the title */
	public String getTitle() {
		return title;
	}

	/** @param title the title to set */
	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	/** @return the content */
	public String getContent() {
		return content;
	}

	/** @param content the content to set */
	public void setContent(String content) {
		this.content = content;
	}

	public PageLocale() {
	}

	public PageLocale(String menu) {
		this.menu = menu;
	}
}
