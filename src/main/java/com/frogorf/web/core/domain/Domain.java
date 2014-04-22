/**
 * 
 */
package com.frogorf.web.core.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.frogorf.domain.BaseEntity;

/** @author Tsurkin Alex
 * @version */
@Entity
@Table(name = "domain")
public class Domain extends BaseEntity {

	@Column
	private String url;

	/** @return the url */
	public String getUrl() {
		return url;
	}

	/** @param url the url to set */
	public void setUrl(String url) {
		this.url = url;
	}

	public Domain() {
	}
}
