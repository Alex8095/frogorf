/**
 * 
 */
package com.frogorf.files.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.frogorf.files.dao.FileDao;
import com.frogorf.files.domain.File;
import com.frogorf.files.service.FileService;

/** @author Tsurkin Alex
 * @version */
@Service("fileService")
public class FileServiceImpl implements FileService {

	@Autowired
	private FileDao fileDao;

	/* @see com.frogorf.files.service.FileService#createFile() */
	@Override
	public File createFile() {
		return null;
	}

	/* @see com.frogorf.files.service.FileService#getFileById(int) */
	@Override
	@Transactional
	public File getFileById(int id) {
		return fileDao.getFileById(id);
	}

	/* @see
	 * com.frogorf.files.service.FileService#saveFile(com.frogorf.files.domain
	 * .File) */
	@Override
	public void saveFile(File file) {
		fileDao.saveFile(file);
	}

	/* @see com.frogorf.files.service.FileService#deleteFile(int) */
	@Override
	@Transactional
	public void deleteFile(int id) {
		fileDao.deleteFile(id);
	}

}
