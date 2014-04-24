/**
 * 
 */
package com.frogorf.dictionary.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import java.util.List;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.frogorf.dictionary.domain.Dictionary;
import com.frogorf.dictionary.domain.DictionaryValue;
import com.frogorf.service.AbstractBaseServiceTest;

/** @author Tsurkin Alex
 * @version */
public class DictionaryServiceTest extends AbstractBaseServiceTest {

	@Autowired
	protected DictionaryService dictionaryService;

	private static final Logger logger = LoggerFactory.getLogger(DictionaryServiceTest.class);

	/** Test method for
	 * {@link com.frogorf.dictionary.service.DictionaryService#findDictionaryAll()}
	 * . */
	@Test
	public void testFindDictionaryAll() {
	}

	/** Test method for
	 * {@link com.frogorf.dictionary.service.DictionaryService#findDictionaryAllByPage(org.springframework.data.domain.Pageable)}
	 * . */
	@Test
	public void testFindDictionaryAllByPage() {
	}

	/** Test method for
	 * {@link com.frogorf.dictionary.service.DictionaryService#findDictionaryById(int)}
	 * . */
	@Test
	public void testFindDictionaryById() {
	}

	/** Test method for
	 * {@link com.frogorf.dictionary.service.DictionaryService#saveDictionary(com.frogorf.dictionary.domain.Dictionary)}
	 * . */
	@Test
	@Transactional
	public void testSaveDictionary() {
		List<Dictionary> dictionaries = dictionaryService.findDictionaryAll();
		int found = dictionaries.size();
		Dictionary dictionary = new Dictionary();
		dictionary.setCode("code");
		dictionary.setDescription("description");
		dictionary.setLang("lang");
		dictionary.setName("name");
		dictionaryService.saveDictionary(dictionary);
		dictionaries = dictionaryService.findDictionaryAll();
		assertEquals("Verifying number of  after inserting a new one.", found + 1, dictionaries.size());
	}

	/** Test method for
	 * {@link com.frogorf.dictionary.service.DictionaryService#deleteDictionary(int)}
	 * . */
	@Test
	@Transactional
	public void testDeleteDictionary() {
	}

	/** Test method for
	 * {@link com.frogorf.dictionary.service.DictionaryService#findDictionaryValueAll()}
	 * . */
	@Test
	public void testFindDictionaryValueAll() {
	}

	/** Test method for
	 * {@link com.frogorf.dictionary.service.DictionaryService#findDictionaryValueAllByPage(org.springframework.data.domain.Pageable)}
	 * . */
	@Test
	public void testFindDictionaryValueAllByPage() {
	}

	/** Test method for
	 * {@link com.frogorf.dictionary.service.DictionaryService#findDictionaryValueAllByDictionary(com.frogorf.dictionary.domain.Dictionary)}
	 * . */
	@Test
	public void testFindDictionaryValueAllByDictionary() {
	}

	/** Test method for
	 * {@link com.frogorf.dictionary.service.DictionaryService#findDictionaryValueAllByDictionaryId(int)}
	 * . */
	@Test
	public void testFindDictionaryValueAllByDictionaryId() {
	}

	/** Test method for
	 * {@link com.frogorf.dictionary.service.DictionaryService#findDictionaryValueById(int)}
	 * . */
	@Test
	public void testFindDictionaryValueById() {
	}

	/** Test method for
	 * {@link com.frogorf.dictionary.service.DictionaryService#saveDictionaryValue(com.frogorf.dictionary.domain.DictionaryValue)}
	 * . */
	@Test
	@Transactional
	public void testSaveDictionaryValue() {
		List<DictionaryValue> dictionariesValues = dictionaryService.findDictionaryValueAll();
		int found = dictionariesValues.size();
		DictionaryValue dictionaryValue = new DictionaryValue();
		dictionaryValue.setCode("code");
		dictionaryValue.setLang("lang");
		dictionaryValue.setName("name");
		dictionaryService.saveDictionaryValue(dictionaryValue);
		dictionariesValues = dictionaryService.findDictionaryValueAll();
		assertEquals("Verifying number of  after inserting a new one.", found + 1, dictionariesValues.size());
	}

	/** Test method for
	 * {@link com.frogorf.dictionary.service.DictionaryService#deleteDictionaryValue(int)}
	 * . */
	@Test
	@Transactional
	public void testDeleteDictionaryValue() {
	}

}
