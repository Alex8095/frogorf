package com.frogorf.shop.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Type;
import org.joda.time.DateTime;
import org.springframework.format.annotation.DateTimeFormat;

import com.frogorf.domain.BaseEntity;
import com.frogorf.security.domain.User;

@Entity
@Table(name = "order_history")
public class OrderHistory extends BaseEntity {

	@Column(name = "date_time_add")
	@Type(type = "org.joda.time.contrib.hibernate.PersistentDateTime")
	@DateTimeFormat(pattern = "dd.MM.yyyy hh:mm")
	private DateTime dateTimeAdd;
	@ManyToOne
	@JoinColumn(name = "user_id")
	private User user;
	@ManyToOne
	@JoinColumn(name = "order_id")
	private Order order;

	public DateTime getDateTimeAdd() {
		return dateTimeAdd;
	}

	public void setDateTimeAdd(DateTime dateTimeAdd) {
		this.dateTimeAdd = dateTimeAdd;
	}

	public String getDateTimeAddString() {
		return org.joda.time.format.DateTimeFormat.forPattern("dd.MM.yyyy hh:mm").print(dateTimeAdd);
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
