/**
 * 
 */
package com.frogorf.security.service;

import com.frogorf.security.domain.User;

/** @author Tsurkin Alex
 * @version */
public interface UserService {

	public User getUser(String login);
}
