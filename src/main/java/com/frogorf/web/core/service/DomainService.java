/**
 * 
 */
package com.frogorf.web.core.service;

import java.util.List;

import com.frogorf.web.core.domain.Domain;

/** @author Tsurkin Alex
 * @version */
public interface DomainService {

	public List<Domain> findDomains();

	public Domain findDomainById(int id);
	
	public void saveDomain(Domain domain);

	public void deleteDomain(int id);
}
