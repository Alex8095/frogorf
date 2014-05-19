package com.frogorf.shop.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import java.util.List;

import org.junit.BeforeClass;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.test.context.transaction.TransactionConfiguration;

import com.frogorf.security.domain.User;
import com.frogorf.security.service.UserService;
import com.frogorf.service.AbstractBaseServiceTest;
import com.frogorf.shop.domain.Order;
import com.frogorf.shop.domain.OrderHistory;
import com.frogorf.shop.domain.Product;
import com.frogorf.shop.domain.Warehouse;

@TransactionConfiguration(transactionManager = "transactionManager", defaultRollback = false)
public class ShopServiceTest extends AbstractBaseServiceTest {

	@Autowired
	protected ShopService shopService;

	@Autowired
	protected UserService userService;

	private static final Logger logger = LoggerFactory.getLogger(ShopServiceTest.class);

	private static final Product product = null;
	private static final Warehouse warehouse = null;
	private static final Order order = null;

	@BeforeClass
	public static void setBeforeClass() {

	}

	// @Before
	public void setBefore() {
		logger.info("setBefore");
		/* product object save */
		Product product = new Product();
		product.setUrl("product");
		shopService.saveProduct(product);
		/* warehouse object save */
		Warehouse warehouse = new Warehouse();
		warehouse.setName("warehouse");
		shopService.saveWarehouse(warehouse);
		/* order object save */
		Order order = new Order();
		order.setCode("order");
		shopService.saveOrder(order);
	}

	@Test
	public void testFindProducts() {
		List<Product> list = shopService.findProducts();
		int found = list.size();
		Product item = new Product();
		item.setUrl("testFindProducts");
		shopService.saveProduct(item);
		list = shopService.findProducts();
		assertEquals("Verifying number of  after inserting a new one.", found + 1, list.size());
	}

	@Test
	public void testFindProductsByProductProduct() {
		Product item = new Product();
		item.setUrl("testFindProductsByProductProduct 1");
		shopService.saveProduct(item);
		item.setUrl("testFindProductsByProductProduct");
		shopService.saveProduct(item);
		List<Product> list = shopService.findProductsByProduct(item);
		assertEquals(1, list.size());
	}

	@Test
	public void testFindProductsByProductProductPageable() {
		String productUrl = "testFindProductsByProductProductPageable";

		Product item = new Product();
		item.setUrl(productUrl);
		shopService.saveProduct(item);
		item = new Product();
		item.setUrl(productUrl + "1");
		shopService.saveProduct(item);
		/* paggable */
		Sort sort = null;
		String orderBy = "url";
		String order = "desc";
		if (orderBy != null && order != null) {
			if (order.equals("desc")) {
				sort = new Sort(Sort.Direction.DESC, orderBy);
			} else
				sort = new Sort(Sort.Direction.ASC, orderBy);
		}
		PageRequest pageRequest = null;
		int page = 1;
		int rows = 20;
		if (sort != null) {
			pageRequest = new PageRequest(page - 1, rows, sort);
		} else {
			pageRequest = new PageRequest(page - 1, rows);
		}

		Product webProduct = new Product();
		webProduct.setUrl(productUrl);

		org.springframework.data.domain.Page<Product> products = shopService.findProductsByProduct(webProduct, pageRequest);
		assertEquals(products.getNumber() + 1, 1);
		assertEquals(products.getTotalPages(), 1);
		assertEquals(products.getTotalElements(), 1);
		assertEquals(products.iterator().next().getUrl(), productUrl);
	}

	@Test
	public void testFindProductById() {
		Product item = new Product();
		item.setUrl("testFindProductById");
		shopService.saveProduct(item);
		item = shopService.findProductById(item.getId());
		/* test object */
		assertEquals(item.getUrl(), "testFindProductById");
	}

	@Test
	public void testFindProductByProduct() {
		Product item = new Product();
		item.setUrl("testFindProductByProduct");
		assertNull(shopService.findProductByProduct(item));
	}

	@Test
	public void testSaveProduct() {
		Product item = new Product();
		item.setUrl("testSaveProduct");
		shopService.saveProduct(item);
		item = shopService.findProductById(item.getId());
		/* test object */
		assertEquals(item.getUrl(), "testSaveProduct");
	}

	@Test
	public void testDeleteProduct() {
		Product item = new Product();
		item.setUrl("testFindProductById");
		shopService.saveProduct(item);
		int itemId = item.getId();
		shopService.deleteProduct(itemId);
		assertNull(shopService.findProductById(itemId));
	}

	@Test
	public void testFindWarehouses() {
		List<Warehouse> list = shopService.findWarehouses();
		int found = list.size();
		Warehouse item = new Warehouse();
		item.setName("testFindWarehouses");
		shopService.saveWarehouse(item);
		list = shopService.findWarehouses();
		assertEquals("Verifying number of  after inserting a new one.", found + 1, list.size());
	}

	@Test
	public void testFindWarehousesByWarehouse() {
		Warehouse item = new Warehouse();
		item.setName("testFindWarehousesByWarehouse 1");
		shopService.saveWarehouse(item);
		item.setName("testFindWarehousesByWarehouse");
		shopService.saveWarehouse(item);
		List<Warehouse> list = shopService.findWarehousesByWarehouse(item);
		assertEquals(1, list.size());
	}

	@Test
	public void testFindWarehousesByWarehouseWarehousePageable() {
		String warehouseName = "testFindWarehousesByWarehouseWarehousePageable";

		Warehouse item = new Warehouse();
		item.setName(warehouseName);
		shopService.saveWarehouse(item);
		item = new Warehouse();
		item.setName(warehouseName + "1");
		shopService.saveWarehouse(item);
		/* paggable */
		Sort sort = null;
		String orderBy = "url";
		String order = "desc";
		if (orderBy != null && order != null) {
			if (order.equals("desc")) {
				sort = new Sort(Sort.Direction.DESC, orderBy);
			} else
				sort = new Sort(Sort.Direction.ASC, orderBy);
		}
		PageRequest pageRequest = null;
		int page = 1;
		int rows = 20;
		if (sort != null) {
			pageRequest = new PageRequest(page - 1, rows, sort);
		} else {
			pageRequest = new PageRequest(page - 1, rows);
		}

		Warehouse webWarehouse = new Warehouse();
		webWarehouse.setName(warehouseName);

		org.springframework.data.domain.Page<Warehouse> warehouses = shopService.findWarehousesByWarehouse(webWarehouse, pageRequest);
		assertEquals(warehouses.getNumber() + 1, 1);
		assertEquals(warehouses.getTotalPages(), 1);
		assertEquals(warehouses.getTotalElements(), 1);
		assertEquals(warehouses.iterator().next().getName(), warehouseName);
	}

	@Test
	public void testFindWarehouseById() {
		Warehouse item = new Warehouse();
		item.setName("testFindWarehouseById");
		shopService.saveWarehouse(item);
		item = shopService.findWarehouseById(item.getId());
		/* test object */
		assertEquals(item.getName(), "testFindWarehouseById");
	}

	@Test
	public void testFindWarehouseByWarehouse() {
		Warehouse item = new Warehouse();
		item.setName("testFindWarehouseByWarehouse");
		assertNull(shopService.findWarehouseByWarehouse(item));
	}

	@Test
	public void testSaveWarehouse() {
		Warehouse warehouse = new Warehouse();
		warehouse.setName("testSaveWarehouse");
		shopService.saveWarehouse(warehouse);
		warehouse = shopService.findWarehouseById(warehouse.getId());
		/* test object */
		assertEquals(warehouse.getName(), "testSaveWarehouse");
	}

	@Test
	public void testDeleteWarehouse() {
		Warehouse item = new Warehouse();
		item.setName("testDeleteWarehouse");
		shopService.saveWarehouse(item);
		int itemId = item.getId();
		shopService.deleteWarehouse(itemId);
		assertNull(shopService.findWarehouseById(itemId));
	}

	@Test
	public void testFindOrders() {
		List<Order> list = shopService.findOrders();
		int found = list.size();
		Order item = new Order();
		item.setCode("testFindOrders");
		shopService.saveOrder(item);
		list = shopService.findOrders();
		assertEquals("Verifying number of  after inserting a new one.", found + 1, list.size());
	}

	@Test
	public void testFindOrdersByOrder() {
		User user = new User();
		user.setLogin("testFindOrdersByOrder");
		user.setPassword("password");
		userService.saveUser(user);
		Order item = new Order();
		item.setCode("testFindOrdersByOrder 1");
		shopService.saveOrder(item);
		item.setCode("testFindOrdersByOrder");
		item.setUser(user);
		shopService.saveOrder(item);
		List<Order> list = shopService.findOrdersByOrder(item);
		assertEquals(1, list.size());
		assertEquals(list.get(0).getUser().getLogin(), "testFindOrdersByOrder");
	}

	@Test
	public void testFindOrdersByOrderOrderPageable() {
		String orderCode = "testFindOrdersByOrderOrderPageable";

		Order item = new Order();
		item.setCode(orderCode);
		shopService.saveOrder(item);
		item = new Order();
		item.setCode(orderCode + "1");
		shopService.saveOrder(item);
		/* paggable */
		Sort sort = null;
		String orderBy = "url";
		String order = "desc";
		if (orderBy != null && order != null) {
			if (order.equals("desc")) {
				sort = new Sort(Sort.Direction.DESC, orderBy);
			} else
				sort = new Sort(Sort.Direction.ASC, orderBy);
		}
		PageRequest pageRequest = null;
		int page = 1;
		int rows = 20;
		if (sort != null) {
			pageRequest = new PageRequest(page - 1, rows, sort);
		} else {
			pageRequest = new PageRequest(page - 1, rows);
		}

		Order webOrder = new Order();
		webOrder.setCode(orderCode);

		org.springframework.data.domain.Page<Order> orders = shopService.findOrdersByOrder(webOrder, pageRequest);
		assertEquals(orders.getNumber() + 1, 1);
		assertEquals(orders.getTotalPages(), 1);
		assertEquals(orders.getTotalElements(), 1);
		assertEquals(orders.iterator().next().getCode(), orderCode);
	}

	@Test
	public void testFindOrderById() {
		Order item = new Order();
		item.setCode("testFindOrderById");
		shopService.saveOrder(item);
		item = shopService.findOrderById(item.getId());
		/* test object */
		assertEquals(item.getCode(), "testFindOrderById");
	}

	@Test
	public void testFindOrderByOrder() {
		Order item = new Order();
		item.setCode("testFindOrderByOrder");
		assertNull(shopService.findOrderByOrder(item));
	}

	@Test
	public void testSaveOrder() {
		User user = new User();
		user.setLogin("testSaveOrderLogin");
		user.setPassword("password");
		userService.saveUser(user);
		Order order = new Order();
		order.setCode("code");
		order.setUser(user);
		shopService.saveOrder(order);
		order = shopService.findOrderById(order.getId());
		/* test object */
		assertEquals(order.getCode(), "code");
		assertEquals(order.getUser().getLogin(), "testSaveOrderLogin");
	}

	@Test
	public void testDeleteOrder() {
		Order item = new Order();
		item.setCode("testDeleteOrder");
		shopService.saveOrder(item);
		int itemId = item.getId();
		shopService.deleteOrder(itemId);
		assertNull(shopService.findOrderById(itemId));
	}

	@Test
	public void testFindOrderHistorys() {
	}

	@Test
	public void testFindOrderHistorysByOrderHistory() {
	}

	@Test
	public void testFindOrderHistorysByOrderHistoryHistory() {
	}

	@Test
	public void testFindOrderHistoryById() {
	}

	@Test
	public void testFindOrderHistoryByOrderHistory() {
	}

	@Test
	public void testSaveOrderHistory() {
	}

	@Test
	public void testDeleteOrderHistory() {
	}

}
