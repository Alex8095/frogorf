/**
 * 
 */
package com.frogorf.files.dao.impl;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.frogorf.files.dao.FileDao;
import com.frogorf.files.domain.File;

/** @author Tsurkin Alex
 * @version */
@Repository("fileDao")
public class FileDaoImpl implements FileDao {

	@Autowired
	private SessionFactory sessionFactory;

	/* @see com.frogorf.files.dao.FileDao#getFileById(int) */
	@Override
	public File getFileById(int id) {
		return (File) sessionFactory.getCurrentSession().get(File.class, id);
	}

	/* @see
	 * com.frogorf.files.dao.FileDao#saveFile(com.frogorf.files.domain.File) */
	@Override
	public void saveFile(File file) {
		sessionFactory.getCurrentSession().saveOrUpdate(file);
	}

	/* @see com.frogorf.files.dao.FileDao#deleteFile(int) */
	@Override
	public void deleteFile(int id) {
		sessionFactory.getCurrentSession().delete(getFileById(id));
	}

}
