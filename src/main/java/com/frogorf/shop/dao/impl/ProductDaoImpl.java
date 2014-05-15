/**
 * 
 */
package com.frogorf.shop.dao.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

import com.frogorf.shop.dao.ProductDao;
import com.frogorf.shop.domain.Product;

/** @author Tsurkin Alex
 * @version */
@Repository("productDao")
public class ProductDaoImpl implements ProductDao {

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public List<Product> findProducts() {
		return sessionFactory.getCurrentSession().createQuery("from Product").list();
	}

	@Override
	public List<Product> findProductsByProduct(Product product) {
		Criteria criteria = sessionFactory.getCurrentSession().createCriteria(Product.class);
		if (product != null) {
			if (product.getUrl() != null)
				criteria.add(Restrictions.eq("url", product.getUrl()));
		}
		return criteria.list();
	}

	@Override
	public Page<Product> findProductsByProduct(Product product, Pageable pageable) {
		List<Product> l = findProductsByProduct(product);
		return new PageImpl<Product>(l, pageable, l.size());
	}

	@Override
	public Product findProductById(int id) {
		return (Product) sessionFactory.getCurrentSession().get(Product.class, id);
	}

	@Override
	public Product findProductByProduct(Product product) {
		List<Product> l = findProductsByProduct(product);
		return (l.size() > 0 ? l.get(0) : null);
	}

	@Override
	public void saveProduct(Product product) {
		sessionFactory.getCurrentSession().saveOrUpdate(product);
	}

	@Override
	public void deleteProduct(int id) {
		sessionFactory.getCurrentSession().delete(findProductById(id));
	}
}
