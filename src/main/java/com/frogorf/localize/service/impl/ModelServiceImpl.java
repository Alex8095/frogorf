/**
 * 
 */
package com.frogorf.localize.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.frogorf.localize.dao.ModelDao;
import com.frogorf.localize.model.Model;
import com.frogorf.localize.service.ModelService;

/** @author Tsurkin Alex
 * @version */
@Service("modelService")
public class ModelServiceImpl implements ModelService {

	@Autowired
	private ModelDao modelDao;

	/* @see com.frogorf.localize.service.ModelService#findDModelAll() */
	@Override
	public List<Model> findModelAll() {
		return modelDao.findModelAll();
	}

	/* @see
	 * com.frogorf.localize.service.ModelService#saveModel(com.frogorf.localize
	 * .model.Model) */
	@Override
	public void saveModel(Model model) {
		modelDao.saveModel(model);
	}

}
