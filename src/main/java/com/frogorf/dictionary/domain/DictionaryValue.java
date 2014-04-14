/**
 * 
 */
package com.frogorf.dictionary.domain;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.frogorf.domain.BaseEntity;

/** @author Tsurkin Alex
 * @version */
@Entity
@Table(name = "dictionary_value")
public class DictionaryValue extends BaseEntity {

	private static final long serialVersionUID = 1L;

	@Column
	private String name;
	@Column
	private String code;
	@Column
	private String description;
	@Column
	private String lang;
	@ManyToOne
	@JoinColumn(name = "dictionary_id")
	private Dictionary dictionary;
	@ManyToOne
	@JoinColumn(name = "parent_id")
	private DictionaryValue dictionaryValue;
	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(name = "dictionary_value", joinColumns = @JoinColumn(name = "id"), inverseJoinColumns = @JoinColumn(name = "parent_id"))
	private List<DictionaryValue> dictionaryValues;

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

	/** @return the description */
	public String getDescription() {
		return description;
	}

	/** @param description the description to set */
	public void setDescription(String description) {
		this.description = description;
	}

	/** @return the lang */
	public String getLang() {
		return lang;
	}

	/** @param lang the lang to set */
	public void setLang(String lang) {
		this.lang = lang;
	}

	/** @return the dictionary */
	public Dictionary getDictionary() {
		return dictionary;
	}

	/** @param dictionary the dictionary to set */
	public void setDictionary(Dictionary dictionary) {
		this.dictionary = dictionary;
	}

	/** @return the dictionaryValue */
	public DictionaryValue getDictionaryValue() {
		return dictionaryValue;
	}

	/** @param dictionaryValue the dictionaryValue to set */
	public void setDictionaryValue(DictionaryValue dictionaryValue) {
		this.dictionaryValue = dictionaryValue;
	}

	/** @return the dictionaryValues */
	public List<DictionaryValue> getDictionaryValues() {
		if (this.dictionaryValues == null) {
			this.dictionaryValues = new ArrayList<DictionaryValue>();
		}
		return dictionaryValues;
	}

	/** @param dictionaryValues the dictionaryValues to set */
	public void setDictionaryValues(List<DictionaryValue> dictionaryValues) {
		this.dictionaryValues = dictionaryValues;
	}

	public DictionaryValue() {

	}

	/** @param name
	 * @param code
	 * @param description
	 * @param lang
	 * @param dictionary
	 * @param dictionaryValue
	 * @param dictionaryValues */
	public DictionaryValue(String name, String code, String description, String lang, Dictionary dictionary, DictionaryValue dictionaryValue, List<DictionaryValue> dictionaryValues) {
		super();
		this.name = name;
		this.code = code;
		this.description = description;
		this.lang = lang;
		this.dictionary = dictionary;
		this.dictionaryValue = dictionaryValue;
		this.dictionaryValues = dictionaryValues;
	}

	@Override
	public String toString() {
		return String.format("DictionaryValue[id=%s, name='%s', code='%s', description='%s', lang='%s', dictionary=%s, dictionaryValue=%s, dictionaryValue.size=%s]", id, name, code, description,
				lang, dictionary, dictionaryValue, getDictionaryValues().size());
	}
}
