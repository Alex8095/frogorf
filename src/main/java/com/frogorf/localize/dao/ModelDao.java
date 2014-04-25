/**
 * 
 */
package com.frogorf.localize.dao;

import java.util.List;

import com.frogorf.localize.model.Model;

/** @author Tsurkin Alex
 * @version */
public interface ModelDao {

	public List<Model> findModelAll();

	public void saveModel(Model model);

}
