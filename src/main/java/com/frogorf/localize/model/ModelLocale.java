/**
 * 
 */
package com.frogorf.localize.model;

import javax.persistence.Column;
import javax.persistence.Embeddable;

/** @author Tsurkin Alex
 * @version */
@Embeddable
public class ModelLocale {

	@Column
	private String title;
	@Column
	private String description;

	/** @return the title */
	public String getTitle() {
		return title;
	}

	/** @param title the title to set */
	public void setTitle(String title) {
		this.title = title;
	}

	/** @return the description */
	public String getDescription() {
		return description;
	}

	/** @param description the description to set */
	public void setDescription(String description) {
		this.description = description;
	}

	public ModelLocale() {
	}

	/** @param title
	 * @param description */
	public ModelLocale(String title, String description) {
		super();
		this.title = title;
		this.description = description;
	}

}
