/**
 * 
 */
package com.frogorf.parenttest;

import java.util.List;

import com.frogorf.catalog.domain.CatalogNote;

/** @author Tsurkin Alex
 * @version */
public interface ParentTestDao {

	public ParentTest findParentTestById(int id);
	
	public List<ParentTest> findParentTestsByParentTest(ParentTest parentTest);

	public void saveParentTest(ParentTest parentTest);

	public void deleteParentTest(int id);
}
