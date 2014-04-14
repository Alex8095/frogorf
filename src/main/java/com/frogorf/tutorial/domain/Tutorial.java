/**
 * 
 */
package com.frogorf.tutorial.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.frogorf.dictionary.domain.DictionaryValue;
import com.frogorf.domain.BaseEntity;

/** @author Tsurkin Alex
 * @version */
@Entity
@Table(name = "tutorial")
public class Tutorial extends BaseEntity {

	private static final long serialVersionUID = 1L;

	@Column
	private String subject;
	@Column
	private String description;
	@Column
	@Lob
	private String summary;

	@ManyToOne
	@JoinColumn(name = "category_id")
	private DictionaryValue category;

	@ManyToOne
	@JoinColumn(name = "book_id")
	private Book book;

	/** @return the subject */
	public String getSubject() {
		return subject;
	}

	/** @param subject the subject to set */
	public void setSubject(String subject) {
		this.subject = subject;
	}

	/** @return the description */
	public String getDescription() {
		return description;
	}

	/** @param description the description to set */
	public void setDescription(String description) {
		this.description = description;
	}

	/** @return the summary */
	public String getSummary() {
		return summary;
	}

	/** @param summary the summary to set */
	public void setSummary(String summary) {
		this.summary = summary;
	}

	/** @return the category */
	public DictionaryValue getCategory() {
		return category;
	}

	/** @param category the category to set */
	public void setCategory(DictionaryValue category) {
		this.category = category;
	}

	/** @return the book */
	public Book getBook() {
		return book;
	}

	/** @param book the book to set */
	public void setBook(Book book) {
		this.book = book;
	}

	public Tutorial() {

	}

	@Override
	public String toString() {
		return String.format("Tutorial[id=%s, subject='%s', description='%s', summary='%s']", id, subject, description.length() <= 100 ? description : description.substring(0, 100),
				summary.length() <= 100 ? summary : summary.substring(0, 100));
	}
}
