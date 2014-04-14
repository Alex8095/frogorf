/**
 * 
 */
package com.frogorf.security.dao.impl;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.frogorf.security.dao.RoleDao;
import com.frogorf.security.domain.Role;

/** @author Tsurkin Alex
 * @version */
@Repository("roleDao")
public class RoleDaoImpl implements RoleDao {

	@Autowired
	private SessionFactory sessionFactory;

	private Session getCurrentSession() {
		return sessionFactory.getCurrentSession();
	}

	/* @see com.frogorf.security.dao.RoleDao#getRole(int) */
	public Role getRole(int id) {
		Role role = (Role) getCurrentSession().load(Role.class, id);
		return role;
	}

}
