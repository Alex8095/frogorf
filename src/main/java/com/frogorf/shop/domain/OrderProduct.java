package com.frogorf.shop.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.frogorf.domain.BaseEntity;
import com.frogorf.shop.domain.Product;
import com.frogorf.shop.domain.Warehouse;

@Entity
@Table(name = "order_product")
public class OrderProduct extends BaseEntity {

	@ManyToOne
	private Order order;
	@Column
	private Long count;
	@ManyToOne
	private Product product;
	@Column
	private Double price;
	@Column(name = "sum")
	private Double sum;

	public Long getCount() {
		return count;
	}

	public void setCount(Long count) {
		this.count = count;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public Double getSum() {
		return sum;
	}

	public void setSum(Double sum) {
		this.sum = sum;
	}

	public Order getOrder() {
		return order;
	}

	public void setOrder(Order order) {
		this.order = order;
	}

	public OrderProduct() {
	}

	@Override
	public String toString() {
		return "OrderProduct [order=" + order + ", count=" + count + ", price=" + price + "]";
	}

}
