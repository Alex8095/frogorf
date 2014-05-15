package com.frogorf.shop.domain;

import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.frogorf.catalog.domain.CatalogNote;
import com.frogorf.domain.BaseEntity;
import com.frogorf.domain.BaseLocale;
import com.frogorf.security.domain.User;
import com.frogorf.shop.domain.Product;
import com.frogorf.shop.domain.ProductLocale;
import com.frogorf.shop.domain.ProductWarehouse;

@Entity
@Table(name = "user_address")
public class Address extends BaseEntity {

	@ManyToOne
	@JoinColumn(name = "user_id")
	private User user;
	@Column
	private String city;
	@Column
	private String street;
	@Column
	private String house;
	@Column
	private String telephone;

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getHouse() {
		return house;
	}

	public void setHouse(String house) {
		this.house = house;
	}

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public Address() {
	}

	@Override
	public String toString() {
		return "Address [user=" + user + ", city=" + city + ", street=" + street + ", house=" + house + ", telephone=" + telephone + "]";
	}

}
