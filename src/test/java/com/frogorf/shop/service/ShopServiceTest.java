package com.frogorf.shop.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.frogorf.service.AbstractBaseServiceTest;
import com.frogorf.shop.domain.Address;
import com.frogorf.shop.domain.Order;
import com.frogorf.shop.domain.Warehouse;

public class ShopServiceTest extends AbstractBaseServiceTest {

	@Autowired
	protected ShopService shopService;

	private static final Logger logger = LoggerFactory.getLogger(ShopServiceTest.class);

	@Test
	public void testFindProducts() {
		fail("Not yet implemented");
	}

	@Test
	public void testFindProductsByProductProduct() {
		fail("Not yet implemented");
	}

	@Test
	public void testFindProductsByProductProductPageable() {
		fail("Not yet implemented");
	}

	@Test
	public void testFindProductById() {
		fail("Not yet implemented");
	}

	@Test
	public void testFindProductByProduct() {
		fail("Not yet implemented");
	}

	@Test
	public void testSaveProduct() {
		fail("Not yet implemented");
	}

	@Test
	public void testDeleteProduct() {
		fail("Not yet implemented");
	}

	@Test
	public void testFindWarehouses() {
		fail("Not yet implemented");
	}

	@Test
	public void testFindWarehousesByWarehouseWarehouse() {
		fail("Not yet implemented");
	}

	@Test
	public void testFindWarehousesByWarehouseWarehousePageable() {
		fail("Not yet implemented");
	}

	@Test
	public void testFindWarehouseById() {
		fail("Not yet implemented");
	}

	@Test
	public void testFindWarehouseByWarehouse() {
		fail("Not yet implemented");
	}

	@Test
	public void testSaveWarehouse() {
		Warehouse warehouse = new Warehouse();
		warehouse.setName("name");
		shopService.saveWarehouse(warehouse);
		warehouse = shopService.findWarehouseById(warehouse.getId());
		/* test object */
		assertEquals(warehouse.getName(), "name");
	}

	@Test
	public void testDeleteWarehouse() {
		fail("Not yet implemented");
	}

	@Test
	public void testFindOrders() {
		fail("Not yet implemented");
	}

	@Test
	public void testFindOrdersByOrderOrder() {
		fail("Not yet implemented");
	}

	@Test
	public void testFindOrdersByOrderOrderPageable() {
		fail("Not yet implemented");
	}

	@Test
	public void testFindOrderById() {
		fail("Not yet implemented");
	}

	@Test
	public void testFindOrderByOrder() {
		fail("Not yet implemented");
	}

	@Test
	public void testSaveOrder() {
		Order order = new Order();
		order.setCode("code");
		shopService.saveOrder(order);
		order = shopService.findOrderById(order.getId());
		/* test object */
		assertEquals(order.getCode(), "code");
	}

	@Test
	public void testDeleteOrder() {
		fail("Not yet implemented");
	}

}
