/**
 * 
 */
package com.frogorf.localize.dao.impl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.frogorf.localize.dao.ModelDao;
import com.frogorf.localize.model.Model;

/** @author Tsurkin Alex
 * @version */
@Repository("modelDao")
public class ModelDaoImpl implements ModelDao {

	@Autowired
	private SessionFactory sessionFactory;

	/* @see com.frogorf.localize.dao.ModelDao#findDModelAll() */
	@Override
	public List<Model> findModelAll() {
		return sessionFactory.getCurrentSession().createQuery("from Model").list();
	}

	/* @see
	 * com.frogorf.localize.dao.ModelDao#saveModel(com.frogorf.localize.model
	 * .Model) */
	@Override
	public void saveModel(Model model) {
		sessionFactory.getCurrentSession().saveOrUpdate(model);
	}

}
