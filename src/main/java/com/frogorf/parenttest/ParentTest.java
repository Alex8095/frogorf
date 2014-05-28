package com.frogorf.parenttest;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;

import com.frogorf.domain.BaseEntity;

@Entity
public class ParentTest extends BaseEntity {

	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@ManyToOne(cascade = { CascadeType.ALL })
	@JoinColumn(name = "parentid")
	@NotFound(action = NotFoundAction.IGNORE)
	private ParentTest parent;

	@OneToMany(mappedBy = "parent")
	@NotFound(action = NotFoundAction.IGNORE)
	private List<ParentTest> subCategories;

	public ParentTest getParent() {
		return parent;
	}

	public void setParent(ParentTest parent) {
		this.parent = parent;
	}

	public List<ParentTest> getSubCategories() {
		return subCategories;
	}

	public void setSubCategories(List<ParentTest> subCategories) {
		this.subCategories = subCategories;
	}

	public ParentTest() {
		
	}
	
}
