/**
 * 
 */
package com.frogorf.files.dao;

import com.frogorf.files.domain.File;

/** @author Tsurkin Alex
 * @version */
public interface FileDao {

	File getFileById(int id);

	void saveFile(File file);

	void deleteFile(int id);
}
