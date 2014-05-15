package com.frogorf.shop.domain;

import javax.persistence.Column;
import javax.persistence.Embeddable;

import com.frogorf.domain.BaseLocale;

@Embeddable
public class ProductLocale extends BaseLocale {

	@Column
	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "ProductLocale [name=" + name + ", webTitle=" + webTitle + ", webDescription=" + webDescription + ", webKeywords=" + webKeywords + ", menu=" + menu + ", title=" + title
				+ ", description=" + description + ", content=" + content + "]";
	}

}
