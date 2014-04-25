/**
 * 
 */
package com.frogorf.web.core.dao;

import java.util.List;

import com.frogorf.web.core.domain.Domain;

/** @author Tsurkin Alex
 * @version */
public interface DomainDao {

	public List<Domain> findDomains();

	public Domain findDomainById(int id);
	
	public void saveDomain(Domain domain);

	public void deleteDomain(int id);
}
