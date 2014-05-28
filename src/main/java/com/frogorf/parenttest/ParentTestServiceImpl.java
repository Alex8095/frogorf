/**
 * 
 */
package com.frogorf.parenttest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.frogorf.catalog.dao.CatalogDao;
import com.frogorf.catalog.domain.CatalogNote;
import com.frogorf.catalog.service.CatalogService;
import com.frogorf.web.core.dao.PageDao;

/** @author Tsurkin Alex
 * @version */
@Service("parentTestService")
public class ParentTestServiceImpl implements ParentTestService {

	@Autowired
	private ParentTestDao parentTestDao;

	@Override
	@Transactional
	public List<ParentTest> findParentTestsByParentTest(ParentTest parentTest) {
		return parentTestDao.findParentTestsByParentTest(parentTest);
	}

	@Override
	@Transactional
	public void saveParentTest(ParentTest parentTest) {
		parentTestDao.saveParentTest(parentTest);
	}

	@Override
	@Transactional
	public ParentTest findParentTestById(int id) {
		return parentTestDao.findParentTestById(id);
	}

	@Override
	@Transactional
	public void deleteParentTest(int id) {
		parentTestDao.deleteParentTest(id);
	}

}
