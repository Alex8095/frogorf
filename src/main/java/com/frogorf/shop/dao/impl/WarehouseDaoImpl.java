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

import com.frogorf.shop.dao.WarehouseDao;
import com.frogorf.shop.domain.Warehouse;

/** @author Tsurkin Alex
 * @version */
@Repository("warehouseDao")
public class WarehouseDaoImpl implements WarehouseDao {

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public List<Warehouse> findWarehouses() {
		return sessionFactory.getCurrentSession().createQuery("from Warehouse").list();
	}

	@Override
	public List<Warehouse> findWarehousesByWarehouse(Warehouse warehouse) {
		Criteria criteria = sessionFactory.getCurrentSession().createCriteria(Warehouse.class);
		if (warehouse != null) {
		}
		return criteria.list();
	}

	@Override
	public Page<Warehouse> findWarehousesByWarehouse(Warehouse warehouse, Pageable pageable) {
		List<Warehouse> l = findWarehousesByWarehouse(warehouse);
		return new PageImpl<Warehouse>(l, pageable, l.size());
	}

	@Override
	public Warehouse findWarehouseById(int id) {
		return (Warehouse) sessionFactory.getCurrentSession().get(Warehouse.class, id);
	}

	@Override
	public Warehouse findWarehouseByWarehouse(Warehouse warehouse) {
		List<Warehouse> l = findWarehousesByWarehouse(warehouse);
		return (l.size() > 0 ? l.get(0) : null);
	}

	@Override
	public void saveWarehouse(Warehouse warehouse) {
		sessionFactory.getCurrentSession().saveOrUpdate(warehouse);
	}

	@Override
	public void deleteWarehouse(int id) {
		sessionFactory.getCurrentSession().delete(findWarehouseById(id));
	}
}
