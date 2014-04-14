/**
 * 
 */
package com.frogorf.security.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.hibernate.classic.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.frogorf.security.dao.UserDao;
import com.frogorf.security.domain.User;

/** @author Tsurkin Alex
 * @version */
@Repository("userDao")
public class UserDaoImpl implements UserDao {

	@Autowired
	private SessionFactory sessionFactory;

	private Session openSession() {
		return sessionFactory.getCurrentSession();
	}

	/* @see com.frogorf.security.service.UserService#getUser(java.lang.String) */
	@Override
	public User getUser(String login) {
		List<User> userList = new ArrayList<User>();
		Query query = openSession().createQuery("from User u where u.login = :login");
		query.setParameter("login", login);
		userList = query.list();
		if (userList.size() > 0) {
			System.out.println(userList.get(0).toString());
			return userList.get(0);
		} else
			return null;
	}
}
