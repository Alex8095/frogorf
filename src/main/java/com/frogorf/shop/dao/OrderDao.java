/**
 * 
 */
package com.frogorf.shop.dao;

import java.util.List;

import org.springframework.data.domain.Pageable;

import com.frogorf.shop.domain.Order;

/** @author Tsurkin Alex
 * @version */
public interface OrderDao {

	public List<Order> findOrders();

	public List<Order> findOrdersByOrder(Order order);

	public org.springframework.data.domain.Page<Order> findOrdersByOrder(Order order, Pageable pageable);

	public Order findOrderById(int id);

	public Order findOrderByOrder(Order order);

	public void saveOrder(Order order);

	public void deleteOrder(int id);
}
