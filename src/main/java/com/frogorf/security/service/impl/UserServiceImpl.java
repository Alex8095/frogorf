/**
 * 
 */
package com.frogorf.security.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.frogorf.security.dao.UserDao;
import com.frogorf.security.domain.User;

/** @author Tsurkin Alex
 * @version */
@Service("userService")
public class UserServiceImpl implements UserDao {

	@Autowired
	private UserDao userDao;

	@Override
	@Transactional
	public List<User> findUsers() {
		return userDao.findUsers();
	}

	@Override
	@Transactional
	public User getUser(String login) {
		return userDao.getUser(login);
	}

	@Override
	@Transactional
	public User findUserById(int id) {
		return userDao.findUserById(id);
	}

	@Override
	@Transactional
	public void saveUser(User user) {
		userDao.saveUser(user);
	}

	@Override
	@Transactional
	public void deleteUser(int id) {
		userDao.deleteUser(id);
	}

}
