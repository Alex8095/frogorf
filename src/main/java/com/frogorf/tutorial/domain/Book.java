/**
 * 
 */
package com.frogorf.tutorial.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.frogorf.domain.BaseEntity;

/** @author Tsurkin Alex
 * @version */
@Entity
@Table(name = "book")
public class Book extends BaseEntity {

	private static final long serialVersionUID = 1L;

	@Column
	private String name;

	@Column
	private String authors;

	/** @return the name */
	public String getName() {
		return name;
	}

	/** @param name the name to set */
	public void setName(String name) {
		this.name = name;
	}

	/** @return the authors */
	public String getAuthors() {
		return authors;
	}

	/** @param authors the authors to set */
	public void setAuthors(String authors) {
		this.authors = authors;
	}

	public Book() {

	}

	@Override
	public String toString() {
		return String.format("Book[id=%s, name='%s', authors='%s']", id, name, authors);
	}
}
