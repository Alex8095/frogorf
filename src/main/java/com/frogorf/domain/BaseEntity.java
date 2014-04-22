/**
 * 
 */
package com.frogorf.domain;

import java.util.Locale;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

/** @author Tsurkin Alex
 * @version */
@MappedSuperclass
public class BaseEntity {

	private static final Locale DEFAULT_LOCALE = Locale.getDefault();

	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	protected Integer id;

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getId() {
		return id;
	}

	public boolean isNew() {
		return (this.id == null);
	}

	public Locale getLocale() {
		return DEFAULT_LOCALE;
	}

	public String getLocaleLanguage() {
		return DEFAULT_LOCALE.getLanguage();
	}
}
