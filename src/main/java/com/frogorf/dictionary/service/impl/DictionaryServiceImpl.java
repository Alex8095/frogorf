/**
 * 
 */
package com.frogorf.dictionary.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.frogorf.dictionary.dao.DictionaryDao;
import com.frogorf.dictionary.domain.Dictionary;
import com.frogorf.dictionary.domain.DictionaryValue;
import com.frogorf.dictionary.service.DictionaryService;

/** @author Tsurkin Alex
 * @version */
@Service("dictionaryService")
public class DictionaryServiceImpl implements DictionaryService {

	@Autowired
	private DictionaryDao dictionaryDao;

	/* (non-Javadoc)
	 * 
	 * @see
	 * com.frogorf.dictioanry.service.DictionaryService#findDictionaryAll() */
	@Override
	@Transactional
	public List<Dictionary> findDictionaryAll() {
		return dictionaryDao.findDictionaryAll();
	}

	/* (non-Javadoc)
	 * 
	 * @see
	 * com.frogorf.dictioanry.service.DictionaryService#findDictionaryAllByPage
	 * (org.springframework.data.domain.Pageable) */
	@Override
	@Transactional
	public Page<Dictionary> findDictionaryAllByPage(Pageable pageable) {
		return dictionaryDao.findDictionaryAllByPage(pageable);
	}

	/* (non-Javadoc)
	 * 
	 * @see
	 * com.frogorf.dictioanry.service.DictionaryService#findDictionaryById(int) */
	@Override
	@Transactional
	public Dictionary findDictionaryById(int id) {
		return dictionaryDao.findDictionaryById(id);
	}

	/* (non-Javadoc)
	 * 
	 * @see
	 * com.frogorf.dictioanry.service.DictionaryService#saveDictionary(com.
	 * frogorf.dictionary.domain.Dictionary) */
	@Override
	public void saveDictionary(Dictionary dictionary) {
		dictionaryDao.saveDictionary(dictionary);
	}

	/* (non-Javadoc)
	 * 
	 * @see
	 * com.frogorf.dictioanry.service.DictionaryService#deleteDictionary(int) */
	@Override
	@Transactional
	public void deleteDictionary(int id) {
		dictionaryDao.deleteDictionary(id);
	}

	/* (non-Javadoc)
	 * 
	 * @see
	 * com.frogorf.dictioanry.service.DictionaryService#findDictionaryValueAll() */
	@Override
	@Transactional
	public List<DictionaryValue> findDictionaryValueAll() {
		return dictionaryDao.findDictionaryValueAll();
	}

	/* (non-Javadoc)
	 * 
	 * @see
	 * com.frogorf.dictioanry.service.DictionaryService#findDictionaryValueAllByPage
	 * (org.springframework.data.domain.Pageable) */
	@Override
	@Transactional
	public Page<DictionaryValue> findDictionaryValueAllByPage(Pageable pageable) {
		return dictionaryDao.findDictionaryValueAllByPage(pageable);
	}

	/* (non-Javadoc)
	 * 
	 * @see com.frogorf.dictioanry.service.DictionaryService#
	 * findDictionaryValueAllByDictionary
	 * (com.frogorf.dictionary.domain.Dictionary) */
	@Override
	@Transactional(readOnly = true)
	public List<DictionaryValue> findDictionaryValueAllByDictionary(Dictionary dictionary) {
		return dictionaryDao.findDictionaryValueAllByDictionary(dictionary);
	}

	/* (non-Javadoc)
	 * 
	 * @see com.frogorf.dictioanry.service.DictionaryService#
	 * findDictionaryValueAllByDictionaryId(int) */
	@Override
	@Transactional
	public List<DictionaryValue> findDictionaryValueAllByDictionaryId(int dictionaryId) {
		return dictionaryDao.findDictionaryValueAllByDictionaryId(dictionaryId);
	}

	/* (non-Javadoc)
	 * 
	 * @see
	 * com.frogorf.dictioanry.service.DictionaryService#findDictionaryValueById
	 * (int) */
	@Override
	@Transactional
	public DictionaryValue findDictionaryValueById(int id) {
		return dictionaryDao.findDictionaryValueById(id);
	}

	/* (non-Javadoc)
	 * 
	 * @see
	 * com.frogorf.dictioanry.service.DictionaryService#saveDictionary(com.
	 * frogorf.dictionary.domain.DictionaryValue) */
	@Override
	public void saveDictionaryValue(DictionaryValue dictionaryValue) {
		dictionaryDao.saveDictionaryValue(dictionaryValue);
	}

	/* (non-Javadoc)
	 * 
	 * @see
	 * com.frogorf.dictioanry.service.DictionaryService#deleteDictionaryValue
	 * (int) */
	@Override
	@Transactional(readOnly = true)
	public void deleteDictionaryValue(int id) {
		dictionaryDao.deleteDictionary(id);
	}

}
