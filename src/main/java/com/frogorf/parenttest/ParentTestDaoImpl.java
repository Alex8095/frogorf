/**
 * 
 */
package com.frogorf.parenttest;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

import com.frogorf.catalog.dao.CatalogDao;
import com.frogorf.catalog.domain.CatalogNote;

/** @author Tsurkin Alex
 * @version */
@Repository("parentTestDao")
public class ParentTestDaoImpl implements ParentTestDao {

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public ParentTest findParentTestById(int id) {
		return (ParentTest) sessionFactory.getCurrentSession().get(ParentTest.class, id);
	}

	@Override
	public List<ParentTest> findParentTestsByParentTest(ParentTest parentTest) {
		Criteria criteria = sessionFactory.getCurrentSession().createCriteria(ParentTest.class);
		if (parentTest != null) {
			if (parentTest.getName() != null)
				criteria.add(Restrictions.eq("name", parentTest.getName()));
		}
		return criteria.list();
	}

	@Override
	public void saveParentTest(ParentTest parentTest) {
		sessionFactory.getCurrentSession().saveOrUpdate(parentTest);
	}

	@Override
	public void deleteParentTest(int id) {
		sessionFactory.getCurrentSession().delete(findParentTestById(id));
	}
}
