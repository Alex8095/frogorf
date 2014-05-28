/**
 * 
 */
package com.frogorf.parenttest;

import java.util.List;

/** @author Tsurkin Alex
 * @version */
public interface ParentTestService {

	public ParentTest findParentTestById(int id);

	public List<ParentTest> findParentTestsByParentTest(ParentTest parentTest);

	public void saveParentTest(ParentTest parentTest);

	public void deleteParentTest(int id);
}