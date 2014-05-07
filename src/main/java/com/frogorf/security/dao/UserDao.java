/**
 * 
 */
package com.frogorf.security.dao;

import com.frogorf.security.domain.User;

/** @author Tsurkin Alex
 * @version */
public interface UserDao {

	public User getUser(String login);

}
