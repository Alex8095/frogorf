/**
 * 
 */
package com.frogorf.dictionary.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.frogorf.dictionary.domain.Dictionary;
import com.frogorf.dictionary.domain.DictionaryValue;

/** @author Tsurkin Alex
 * @version */
public interface DictionaryService {

	/* Dictionary */
	public List<Dictionary> findDictionaryAll();

	public Page<Dictionary> findDictionaryAllByPage(Pageable pageable);

	public Dictionary findDictionaryById(int id);

	public void saveDictionary(Dictionary dictionary);

	public void deleteDictionary(int id);

	/* DictionaryValue */
	public List<DictionaryValue> findDictionaryValueAll();

	public Page<DictionaryValue> findDictionaryValueAllByPage(Pageable pageable);

	public List<DictionaryValue> findDictionaryValueAllByDictionary(Dictionary dictionary);

	public List<DictionaryValue> findDictionaryValueAllByDictionaryId(int dictionaryId);

	public DictionaryValue findDictionaryValueById(int id);

	public void saveDictionaryValue(DictionaryValue dictionaryValue);

	public void deleteDictionaryValue(int id);

}
