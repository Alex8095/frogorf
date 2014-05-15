package com.frogorf.shop.domain;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.CollectionOfElements;
import org.hibernate.annotations.MapKey;

import com.frogorf.catalog.domain.CatalogNote;
import com.frogorf.domain.BaseEntity;
import com.frogorf.domain.BaseLocale;

@Entity
@Table(name = "product")
public class Product extends BaseEntity {

	@Column
	private String url;
	@Column
	private Double price;
	@Column(name = "old_price")
	private Double oldPrice;
	@Column(name = "date_create")
	private Date dateCreate;
	@Column(name = "count_in_warehouse")
	private Long countInWarehouse;
	@Column(name = "is_hot")
	private Boolean isHot;
	@Column(name = "is_show")
	private Boolean isShow;

	@JoinTable(name = "product_locale")
	@CollectionOfElements(targetElement = ProductLocale.class, fetch = FetchType.EAGER)
	@MapKey(targetElement = String.class, columns = @Column(name = "language_code"))
	private Map<String, ProductLocale> productLocale = new HashMap<String, ProductLocale>();

	@ManyToOne
	@JoinColumn(name = "catalog_id")
	private CatalogNote productCatalog;

	@OneToMany
	@JoinTable(name = "product_warehouse", joinColumns = @JoinColumn(name = "product_id"), inverseJoinColumns = @JoinColumn(name = "id"))
	private List<ProductWarehouse> productWarehouses;

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public Double getOldPrice() {
		return oldPrice;
	}

	public void setOldPrice(Double oldPrice) {
		this.oldPrice = oldPrice;
	}

	public Date getDateCreate() {
		return dateCreate;
	}

	public void setDateCreate(Date dateCreate) {
		this.dateCreate = dateCreate;
	}

	public Long getCountInWarehouse() {
		return countInWarehouse;
	}

	public void setCountInWarehouse(Long countInWarehouse) {
		this.countInWarehouse = countInWarehouse;
	}

	public Boolean getIsShow() {
		return isShow;
	}

	public void setIsShow(Boolean isShow) {
		this.isShow = isShow;
	}

	public Map<String, ProductLocale> getProductLocale() {
		return productLocale;
	}

	public void setProductLocale(Map<String, ProductLocale> productLocale) {
		this.productLocale = productLocale;
	}

	public BaseLocale getCurrentProductLocale(String localeCode) {
		return getProductLocale().get(localeCode);
	}

	public BaseLocale getCurrentCatalogNoteLocale() {
		return getProductLocale().get(getLocaleLanguage());
	}

	public Boolean getIsHot() {
		return isHot;
	}

	public void setIsHot(Boolean isHot) {
		this.isHot = isHot;
	}

	public CatalogNote getProductCatalog() {
		return productCatalog;
	}

	public void setProductCatalog(CatalogNote productCatalog) {
		this.productCatalog = productCatalog;
	}

	public Product() {
	}

	@Override
	public String toString() {
		return "Product [url=" + url + ", price=" + price + ", oldPrice=" + oldPrice + ", dateCreate=" + dateCreate + ", countInWarehouse=" + countInWarehouse + ", isHot=" + isHot + ", isShow="
				+ isShow + ", productLocale=" + productLocale + "]";
	}

}
