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

import com.frogorf.shop.dao.OrderDao;
import com.frogorf.shop.domain.Order;

/** @author Tsurkin Alex
 * @version */
@Repository("orderDao")
public class OrderDaoImpl implements OrderDao {

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public List<Order> findOrders() {
		return sessionFactory.getCurrentSession().createQuery("from Order").list();
	}

	@Override
	public List<Order> findOrdersByOrder(Order order) {
		Criteria criteria = sessionFactory.getCurrentSession().createCriteria(Order.class);
		if (order != null) {
			if (order.getCode() != null)
				criteria.add(Restrictions.eq("code", order.getCode()));
			if (order.getUser() != null)
				criteria.add(Restrictions.eq("user", order.getUser()));
		}
		return criteria.list();
	}

	@Override
	public Page<Order> findOrdersByOrder(Order Order, Pageable pageable) {
		List<Order> l = findOrdersByOrder(Order);
		return new PageImpl<Order>(l, pageable, l.size());
	}

	@Override
	public Order findOrderById(int id) {
		return (Order) sessionFactory.getCurrentSession().get(Order.class, id);
	}

	@Override
	public Order findOrderByOrder(Order Order) {
		List<Order> l = findOrdersByOrder(Order);
		return (l.size() > 0 ? l.get(0) : null);
	}

	@Override
	public void saveOrder(Order Order) {
		sessionFactory.getCurrentSession().saveOrUpdate(Order);
	}

	@Override
	public void deleteOrder(int id) {
		sessionFactory.getCurrentSession().delete(findOrderById(id));
	}
}
