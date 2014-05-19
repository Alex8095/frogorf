/**
 * 
 */
package com.frogorf.security.service;

import java.util.List;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.frogorf.security.domain.User;

/** @author Tsurkin Alex
 * @version */
public interface UserService extends UserDetailsService {

	public List<User> findUsers();

	public User getUser(String login);

	public User findUserById(int id);

	public void saveUser(User user);

	public void deleteUser(int id);

}
