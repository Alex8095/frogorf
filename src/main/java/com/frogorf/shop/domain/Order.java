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
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.frogorf.catalog.domain.CatalogNote;
import com.frogorf.domain.BaseEntity;
import com.frogorf.domain.BaseLocale;
import com.frogorf.security.domain.User;
import com.frogorf.shop.domain.Product;
import com.frogorf.shop.domain.ProductLocale;
import com.frogorf.shop.domain.ProductWarehouse;

@Entity
@Table(name = "orders")
public class Order extends BaseEntity {

	@Column(name = "code")
	private String code;
	@OneToMany
	@JoinTable(name = "order_product", joinColumns = @JoinColumn(name = "order_id"), inverseJoinColumns = @JoinColumn(name = "id"))
	private List<OrderProduct> orderProducts;
	@ManyToOne
	@JoinColumn(name = "user_id")
	private User user;
	@ManyToOne
	@JoinColumn(name = "address_delivery_id")
	private Address addressDelivery;
	@Column(name = "date_create")
	private Date dateCreate;
	@Column(name = "date_delivery")
	private Date dateDelivery;

	@OneToMany
	@JoinTable(name = "order_history", joinColumns = @JoinColumn(name = "order_id"), inverseJoinColumns = @JoinColumn(name = "id"))
	private List<OrderHistory> orderHistories;

	public List<OrderProduct> getOrderProducts() {
		return orderProducts;
	}

	public void setOrderProducts(List<OrderProduct> orderProducts) {
		this.orderProducts = orderProducts;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Date getDateCreate() {
		return dateCreate;
	}

	public void setDateCreate(Date dateCreate) {
		this.dateCreate = dateCreate;
	}

	public Date getDateDelivery() {
		return dateDelivery;
	}

	public void setDateDelivery(Date dateDelivery) {
		this.dateDelivery = dateDelivery;
	}

	public Address getAddressDelivery() {
		return addressDelivery;
	}

	public void setAddressDelivery(Address addressDelivery) {
		this.addressDelivery = addressDelivery;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public List<OrderHistory> getOrderHistories() {
		return orderHistories;
	}

	public void setOrderHistories(List<OrderHistory> orderHistories) {
		this.orderHistories = orderHistories;
	}

	public Order() {
	}

	@Override
	public String toString() {
		return "Order [code=" + code + ", dateCreate=" + dateCreate + ", dateDelivery=" + dateDelivery + "]";
	}

}
