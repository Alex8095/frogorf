/**
 * 
 */
package com.frogorf.shop.dao;

import java.util.List;

import org.springframework.data.domain.Pageable;

import com.frogorf.shop.domain.OrderHistory;

/** @author Tsurkin Alex
 * @version */
public interface OrderHistoryDao {

	public List<OrderHistory> findOrderHistorys();

	public List<OrderHistory> findOrderHistorysByOrderHistory(OrderHistory orderHistory);

	public org.springframework.data.domain.Page<OrderHistory> findOrderHistorysByOrderHistory(OrderHistory orderHistory, Pageable pageable);

	public OrderHistory findOrderHistoryById(int id);

	public OrderHistory findOrderHistoryByOrderHistory(OrderHistory orderHistory);

	public void saveOrderHistory(OrderHistory orderHistory);

	public void deleteOrderHistory(int id);
}
