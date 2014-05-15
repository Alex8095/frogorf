package com.frogorf.shop.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.frogorf.domain.BaseEntity;

@Entity
@Table(name = "product_warehouse")
public class ProductWarehouse extends BaseEntity {

	@Column
	private Long count;
	@ManyToOne
	private Product product;
	@ManyToOne
	private Warehouse warehouse;

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

	public Warehouse getWarehouse() {
		return warehouse;
	}

	public void setWarehouse(Warehouse warehouse) {
		this.warehouse = warehouse;
	}

	public ProductWarehouse() {
	}

	@Override
	public String toString() {
		return "ProductWarehouse [count=" + count + ", product=" + product + ", warehouse=" + warehouse + "]";
	}

}
