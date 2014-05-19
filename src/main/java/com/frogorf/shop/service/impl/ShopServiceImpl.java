/**
 * 
 */
package com.frogorf.shop.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.frogorf.shop.dao.OrderDao;
import com.frogorf.shop.dao.OrderHistoryDao;
import com.frogorf.shop.dao.ProductDao;
import com.frogorf.shop.dao.WarehouseDao;
import com.frogorf.shop.domain.Order;
import com.frogorf.shop.domain.OrderHistory;
import com.frogorf.shop.domain.Product;
import com.frogorf.shop.domain.Warehouse;
import com.frogorf.shop.service.ShopService;

/** @author Tsurkin Alex
 * @version */
@Service("shopService")
public class ShopServiceImpl implements ShopService {

	@Autowired
	private ProductDao productDao;
	@Autowired
	private WarehouseDao warehouseDao;
	@Autowired
	private OrderDao orderDao;
	@Autowired
	private OrderHistoryDao orderHistoryDao;

	@Override
	@Transactional
	public List<Product> findProducts() {
		return productDao.findProducts();
	}

	@Override
	@Transactional
	public List<Product> findProductsByProduct(Product product) {
		return productDao.findProductsByProduct(product);
	}

	@Override
	@Transactional
	public Page<Product> findProductsByProduct(Product product, Pageable pageable) {
		return productDao.findProductsByProduct(product, pageable);
	}

	@Override
	@Transactional
	public Product findProductById(int id) {
		return productDao.findProductById(id);
	}

	@Override
	@Transactional
	public Product findProductByProduct(Product product) {
		return productDao.findProductByProduct(product);
	}

	@Override
	@Transactional
	public void saveProduct(Product product) {
		productDao.saveProduct(product);
	}

	@Override
	@Transactional
	public void deleteProduct(int id) {
		productDao.deleteProduct(id);
	}

	@Override
	@Transactional
	public List<Warehouse> findWarehouses() {
		return warehouseDao.findWarehouses();
	}

	@Override
	@Transactional
	public List<Warehouse> findWarehousesByWarehouse(Warehouse warehouse) {
		return warehouseDao.findWarehousesByWarehouse(warehouse);
	}

	@Override
	@Transactional
	public Page<Warehouse> findWarehousesByWarehouse(Warehouse warehouse, Pageable pageable) {
		return warehouseDao.findWarehousesByWarehouse(warehouse, pageable);
	}

	@Override
	@Transactional
	public Warehouse findWarehouseById(int id) {
		return warehouseDao.findWarehouseById(id);
	}

	@Override
	@Transactional
	public Warehouse findWarehouseByWarehouse(Warehouse warehouse) {
		return warehouseDao.findWarehouseByWarehouse(warehouse);
	}

	@Override
	@Transactional
	public void saveWarehouse(Warehouse warehouse) {
		warehouseDao.saveWarehouse(warehouse);
	}

	@Override
	@Transactional
	public void deleteWarehouse(int id) {
		warehouseDao.deleteWarehouse(id);
	}

	@Override
	@Transactional
	public List<Order> findOrders() {
		return orderDao.findOrders();
	}

	@Override
	@Transactional
	public List<Order> findOrdersByOrder(Order order) {
		return orderDao.findOrdersByOrder(order);
	}

	@Override
	@Transactional
	public Page<Order> findOrdersByOrder(Order order, Pageable pageable) {
		return orderDao.findOrdersByOrder(order, pageable);
	}

	@Override
	@Transactional
	public Order findOrderById(int id) {
		return orderDao.findOrderById(id);
	}

	@Override
	@Transactional
	public Order findOrderByOrder(Order order) {
		return orderDao.findOrderByOrder(order);
	}

	@Override
	@Transactional
	public void saveOrder(Order order) {
		orderDao.saveOrder(order);
	}

	@Override
	@Transactional
	public void deleteOrder(int id) {
		orderDao.deleteOrder(id);
	}

	@Override
	@Transactional
	public List<OrderHistory> findOrderHistorys() {
		return orderHistoryDao.findOrderHistorys();
	}

	@Override
	@Transactional
	public List<OrderHistory> findOrderHistorysByOrderHistory(OrderHistory orderHistory) {
		return orderHistoryDao.findOrderHistorysByOrderHistory(orderHistory);
	}

	@Override
	@Transactional
	public Page<OrderHistory> findOrderHistorysByOrderHistory(OrderHistory orderHistory, Pageable pageable) {
		return findOrderHistorysByOrderHistory(orderHistory, pageable);
	}

	@Override
	@Transactional
	public OrderHistory findOrderHistoryById(int id) {
		return orderHistoryDao.findOrderHistoryById(id);
	}

	@Override
	@Transactional
	public OrderHistory findOrderHistoryByOrderHistory(OrderHistory orderHistory) {
		return orderHistoryDao.findOrderHistoryByOrderHistory(orderHistory);
	}

	@Override
	@Transactional
	public void saveOrderHistory(OrderHistory orderHistory) {
		orderHistoryDao.saveOrderHistory(orderHistory);
	}

	@Override
	@Transactional
	public void deleteOrderHistory(int id) {
		orderHistoryDao.deleteOrderHistory(id);
	}

}
