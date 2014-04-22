/**
 * 
 */
package com.frogorf.localize.service;

import java.util.List;

import com.frogorf.localize.model.Model;


/**
 * 
 * @author Tsurkin Alex
 * @version
 */
public interface ModelService {

	public List<Model> findModelAll();

	public void saveModel(Model model);
}
