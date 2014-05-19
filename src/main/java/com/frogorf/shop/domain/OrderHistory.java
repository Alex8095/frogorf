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
@Table(name = "order_history")
public class OrderHistory extends BaseEntity {

	@Column(name = "date_time_add")
	private Date dateTimeAdd;
	@ManyToOne
	@JoinColumn(name = "user_id")
	private User user;
	@ManyToOne
	@JoinColumn(name = "order_id")
	private Order order;

	public Date getDateTimeAdd() {
		return dateTimeAdd;
	}

	public void setDateTimeAdd(Date dateTimeAdd) {
		this.dateTimeAdd = dateTimeAdd;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Order getOrder() {
		return order;
	}

	public void setOrder(Order order) {
		this.order = order;
	}

	public OrderHistory() {

	}

	@Override
	public String toString() {
		return "OrderHistory [dateTimeAdd=" + dateTimeAdd + ", user=" + user + ", order=" + order + "]";
	}

}
