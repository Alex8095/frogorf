/**
 * 
 */
package com.frogorf.dictionary.dao.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

import com.frogorf.dictionary.dao.DictionaryDao;
import com.frogorf.dictionary.domain.Dictionary;
import com.frogorf.dictionary.domain.DictionaryValue;

/** @author Tsurkin Alex
 * @version */
@Repository("dictionaryDao")
public class DictionaryDaoImpl implements DictionaryDao {

	@Autowired
	private SessionFactory sessionFactory;

	/* (non-Javadoc)
	 * 
	 * @see com.frogorf.dictionary.dao.DictionaryDao#findDictionaryAll() */
	@Override
	public List<Dictionary> findDictionaryAll() {
		return sessionFactory.getCurrentSession().createQuery("from Dictionary").list();
	}

	/* (non-Javadoc)
	 * 
	 * @see
	 * com.frogorf.dictionary.dao.DictionaryDao#findDictionaryAllByPage(org
	 * .springframework.data.domain.Pageable) */
	@Override
	public Page<Dictionary> findDictionaryAllByPage(Pageable pageable) {
		return null;
	}

	/* (non-Javadoc)
	 * 
	 * @see com.frogorf.dictionary.dao.DictionaryDao#findDictionaryById(int) */
	@Override
	public Dictionary findDictionaryById(int id) {
		return (Dictionary) sessionFactory.getCurrentSession().get(Dictionary.class, id);
	}

	/* (non-Javadoc)
	 * 
	 * @see
	 * com.frogorf.dictionary.dao.DictionaryDao#saveDictionary(com.frogorf.
	 * dictionary.domain.Dictionary) */
	@Override
	public void saveDictionary(Dictionary dictionary) {
		sessionFactory.getCurrentSession().saveOrUpdate(dictionary);

	}

	/* (non-Javadoc)
	 * 
	 * @see com.frogorf.dictionary.dao.DictionaryDao#deleteDictionary(int) */
	@Override
	public void deleteDictionary(int id) {
		sessionFactory.getCurrentSession().delete(findDictionaryById(id));
	}

	/* (non-Javadoc)
	 * 
	 * @see com.frogorf.dictionary.dao.DictionaryDao#findDictionaryValueAll() */
	@Override
	public List<DictionaryValue> findDictionaryValueAll() {
		return sessionFactory.getCurrentSession().createQuery("from DictionaryValue").list();
	}

	/* (non-Javadoc)
	 * 
	 * @see
	 * com.frogorf.dictionary.dao.DictionaryDao#findDictionaryValueAllByPage
	 * (org.springframework.data.domain.Pageable) */
	@Override
	public Page<DictionaryValue> findDictionaryValueAllByPage(Pageable pageable) {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * 
	 * @see
	 * com.frogorf.dictionary.dao.DictionaryDao#findDictionaryValueAllByDictionary
	 * (com.frogorf.dictionary.domain.Dictionary) */
	@Override
	public List<DictionaryValue> findDictionaryValueAllByDictionary(Dictionary dictionary) {
		Criteria criteria = sessionFactory.getCurrentSession().createCriteria(DictionaryValue.class);
		if (!dictionary.getCode().isEmpty())
			criteria.add(Restrictions.like("code", dictionary.getCode()));
		if (!dictionary.getName().isEmpty())
			criteria.add(Restrictions.like("code", dictionary.getCode()));
		// criteria.add(Restrictions.like("userName", "%User 9%")).add(
		// Restrictions.between("userId", 5, 50));
		// criteria.add(Restrictions.eq("userName", "User 4"));
		// criteria.add(Restrictions.or(Restrictions.between("userId", 0, 3),
		// Restrictions.between("userId", 7, 10)));

		return criteria.list();
	}

	/* (non-Javadoc)
	 * 
	 * @see
	 * com.frogorf.dictionary.dao.DictionaryDao#findDictionaryValueAllByDictionaryId
	 * (int) */
	@Override
	public List<DictionaryValue> findDictionaryValueAllByDictionaryId(int dictionaryId) {
		return sessionFactory.getCurrentSession().createQuery("from DictionaryValue").list();
	}

	/* (non-Javadoc)
	 * 
	 * @see
	 * com.frogorf.dictionary.dao.DictionaryDao#findDictionaryValueById(int) */
	@Override
	public DictionaryValue findDictionaryValueById(int id) {
		return (DictionaryValue) sessionFactory.getCurrentSession().get(DictionaryValue.class, id);
	}

	/* (non-Javadoc)
	 * 
	 * @see
	 * com.frogorf.dictionary.dao.DictionaryDao#saveDictionary(com.frogorf.
	 * dictionary.domain.DictionaryValue) */
	@Override
	public void saveDictionaryValue(DictionaryValue dictionaryValue) {
		sessionFactory.getCurrentSession().saveOrUpdate(dictionaryValue);
	}

	/* (non-Javadoc)
	 * 
	 * @see com.frogorf.dictionary.dao.DictionaryDao#deleteDictionaryValue(int) */
	@Override
	public void deleteDictionaryValue(int id) {
		sessionFactory.getCurrentSession().delete(findDictionaryValueById(id));
	}
}
