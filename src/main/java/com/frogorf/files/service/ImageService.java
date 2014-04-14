/**
 * 
 */
package com.frogorf.files.service;

import java.util.List;

import com.frogorf.files.domain.Image;

/** @author Tsurkin Alex
 * @version */
public interface ImageService {

	Image createImage(String name, String type, byte[] blob);
	
	List<Image> getImages();

	Image getImageById(int id);

	void saveImage(Image image);

	void deleteImage(int id);

}
