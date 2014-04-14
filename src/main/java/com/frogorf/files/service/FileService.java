/**
 * 
 */
package com.frogorf.files.service;

import com.frogorf.files.domain.File;

public interface FileService {

	File createFile();
	
	File getFileById(int id);

	void saveFile(File file);

	void deleteFile(int id);

}
