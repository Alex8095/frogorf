/**
 * 
 */
package com.frogorf.security.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.frogorf.security.dao.RoleDao;
import com.frogorf.security.domain.Role;
import com.frogorf.security.service.RoleService;

/** @author Tsurkin Alex
 * @version */

@Service("roleService")
@Transactional
public class RoleServiceImpl implements RoleService {

	@Autowired
	private RoleDao roleDao;

	public Role getRole(int id) {
		return roleDao.getRole(id);
	}

}
