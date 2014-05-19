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

import com.frogorf.shop.dao.OrderHistoryDao;
import com.frogorf.shop.domain.OrderHistory;

/** @author Tsurkin Alex
 * @version */
@Repository("OrderHistoryHistoryDao")
public class OrderHistoryDaoImpl implements OrderHistoryDao {

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public List<OrderHistory> findOrderHistorys() {
		return sessionFactory.getCurrentSession().createQuery("from OrderHistory").list();
	}

	@Override
	public List<OrderHistory> findOrderHistorysByOrderHistory(OrderHistory orderHistory) {
		Criteria criteria = sessionFactory.getCurrentSession().createCriteria(OrderHistory.class);
		if (orderHistory != null) {
			if (orderHistory.getOrder() != null)
				criteria.add(Restrictions.eq("order", orderHistory.getOrder()));
			if (orderHistory.getUser() != null)
				criteria.add(Restrictions.eq("user", orderHistory.getUser()));
		}
		return criteria.list();
	}

	@Override
	public Page<OrderHistory> findOrderHistorysByOrderHistory(OrderHistory orderHistory, Pageable pageable) {
		List<OrderHistory> l = findOrderHistorysByOrderHistory(orderHistory);
		return new PageImpl<OrderHistory>(l, pageable, l.size());
	}

	@Override
	public OrderHistory findOrderHistoryById(int id) {
		return (OrderHistory) sessionFactory.getCurrentSession().get(OrderHistory.class, id);
	}

	@Override
	public OrderHistory findOrderHistoryByOrderHistory(OrderHistory orderHistory) {
		List<OrderHistory> l = findOrderHistorysByOrderHistory(orderHistory);
		return (l.size() > 0 ? l.get(0) : null);
	}

	@Override
	public void saveOrderHistory(OrderHistory orderHistory) {
		sessionFactory.getCurrentSession().saveOrUpdate(orderHistory);
	}

	@Override
	public void deleteOrderHistory(int id) {
		sessionFactory.getCurrentSession().delete(findOrderHistoryById(id));
	}
}
