/**
 * 
 */
package com.frogorf.localize.model;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

import javax.persistence.Column;
import javax.persistence.Embeddable;

import org.hibernate.annotations.CollectionOfElements;
import org.hibernate.annotations.MapKey;

/** @author Tsurkin Alex
 * @version */
@Embeddable
public class LocalizedString implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private static final Locale DEFAULT_LOCALE = Locale.ENGLISH;

	public LocalizedString() {
	}

	public LocalizedString(String string) {
		this.getVariations().put(DEFAULT_LOCALE.getLanguage(), string);
	}

	@CollectionOfElements(targetElement = String.class)
	@MapKey(targetElement = String.class, columns = @Column(name = "language_code"))
	private Map<String, String> variations = new HashMap<String, String>();

	public Map<String, String> getVariations() {
		return variations;
	}

	public void setVariations(Map<String, String> variations) {
		this.variations = variations;
	}
}