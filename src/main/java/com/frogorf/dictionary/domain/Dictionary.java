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
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.validator.constraints.NotEmpty;

import com.frogorf.domain.BaseEntity;

/** @author Tsurkin Alex
 * @version */
@Entity
@Table(name = "dictionary")
public class Dictionary extends BaseEntity {

	private static final long serialVersionUID = 1L;

	@Column
	@NotEmpty
	private String name;
	@Column
	private String code;
	@Column
	private String description;
	@Column
	private String lang;
	@OneToMany(mappedBy = "dictionary", fetch = FetchType.EAGER)
	private List<DictionaryValue> dictionaryValues;

	/* parent */
	@ManyToOne
	@JoinColumn(name = "parent_id")
	private Dictionary dictionary;
	@ManyToMany
	@JoinTable(name = "dictionary", joinColumns = @JoinColumn(name = "id"), inverseJoinColumns = @JoinColumn(name = "parent_id"))
	private List<Dictionary> dictionarys;

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

	/** @return the dictionaryValues */
	public List<DictionaryValue> getDictionaryValues() {
		if (this.dictionaryValues == null)
			this.dictionaryValues = new ArrayList<DictionaryValue>();
		return this.dictionaryValues;
	}

	/** @param dictionaryValues the dictionaryValues to set */
	public void setDictionaryValues(List<DictionaryValue> dictionaryValues) {
		this.dictionaryValues = dictionaryValues;
	}

	/** @return the dictionary */
	public Dictionary getDictionary() {
		return dictionary;
	}

	/** @param dictionary the dictionary to set */
	public void setDictionary(Dictionary dictionary) {
		this.dictionary = dictionary;
	}

	/** @return the dictionarys */
	public List<Dictionary> getDictionarys() {
		return dictionarys;
	}

	/** @param dictionarys the dictionarys to set */
	public void setDictionarys(List<Dictionary> dictionarys) {
		this.dictionarys = dictionarys;
	}

	public Dictionary() {

	}

	/** @param name
	 * @param code
	 * @param description
	 * @param dictionaryValues */
	public Dictionary(String name, String code, String description, String lang, List<DictionaryValue> dictionaryValues) {
		super();
		this.name = name;
		this.code = code;
		this.description = description;
		this.lang = lang;
		this.dictionaryValues = dictionaryValues;
	}

	@Override
	public String toString() {
		return String.format("Dictionary[id=%s, name='%s', code='%s', description='%s', lang='%s', dictionaryValues.size=%s]", id, name, code, description, lang, getDictionaryValues().size());
	}
}
