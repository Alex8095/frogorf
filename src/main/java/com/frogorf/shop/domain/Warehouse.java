package com.frogorf.shop.domain;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.frogorf.domain.BaseEntity;

@Entity
@Table(name = "warehouse")
public class Warehouse extends BaseEntity {

	@Column
	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Warehouse() {

	}

	@Override
	public String toString() {
		return "Warehouse [name=" + name + "]";
	}

}
