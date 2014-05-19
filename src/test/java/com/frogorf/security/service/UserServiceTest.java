package com.frogorf.security.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.fail;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.frogorf.security.domain.User;
import com.frogorf.security.service.UserService;
import com.frogorf.service.AbstractBaseServiceTest;
import com.frogorf.shop.domain.Product;
import com.frogorf.shop.service.ShopServiceTest;

public class UserServiceTest extends AbstractBaseServiceTest {

	private static final Logger logger = LoggerFactory.getLogger(ShopServiceTest.class);

	@Autowired
	protected UserService userService;

	@Test
	public void testFindUsers() {
	}

	@Test
	public void testGetUser() {
	}

	@Test
	public void testFindUserById() {
		User item = new User();
		item.setLogin("testFindUserById");
		item.setPassword("password");
		userService.saveUser(item);
		item = userService.findUserById(item.getId());
		/* test object */
		assertEquals(item.getLogin(), "testFindUserById");
	}

	@Test
	public void testSaveUser() {
		User item = new User();
		item.setLogin("login");
		item.setPassword("password");
		userService.saveUser(item);
		item = userService.findUserById(item.getId());
		/* test object */
		assertEquals(item.getLogin(), "login");
		assertEquals(item.getPassword(), "password");
	}

	@Test
	public void testDeleteUser() {
		User item = new User();
		item.setLogin("login");
		item.setPassword("password");
		userService.saveUser(item);
		int itemId = item.getId();
		userService.deleteUser(itemId);
		assertNull(userService.findUserById(itemId));
	}

}
