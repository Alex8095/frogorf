/**
 * 
 */
package com.frogorf.localize.model;

import java.util.HashMap;
import java.util.Map;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinTable;
import javax.persistence.Table;

import org.hibernate.annotations.CollectionOfElements;
import org.hibernate.annotations.MapKey;

import com.frogorf.domain.BaseEntity;

/** @author Tsurkin Alex
 * @version */
@Entity
@Table(name = "model")
public class Model extends BaseEntity {

	@Column
	private String name;
	@Column
	private String code;

	@JoinTable(name="model_locale")
	@CollectionOfElements(targetElement = ModelLocale.class)
	@MapKey(targetElement = String.class, columns = @Column(name = "language_code"))
	private Map<String, ModelLocale> modelLocale = new HashMap<String, ModelLocale>();

	/** @return the name */
	public String getName() {
		return name;
	}

	/** @param name the name to set */
	public void setName(String name) {
		this.name = name;
	}

	/** @return the code */
	public String getCode() {
		return code;
	}

	/** @param code the code to set */
	public void setCode(String code) {
		this.code = code;
	}

	public Model() {
	}

	/** @return the modelLocale */
	public Map<String, ModelLocale> getModelLocale() {
		return modelLocale;
	}

	/** @param modelLocale the modelLocale to set */
	public void setModelLocale(Map<String, ModelLocale> modelLocale) {
		this.modelLocale = modelLocale;
	}

	public ModelLocale getCurrentModelLocale() {
		return getModelLocale().get(getLocaleLanguage());
	}
}
