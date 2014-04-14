/**
 * 
 */
package com.frogorf.files.dao;

import java.util.List;

import com.frogorf.files.domain.Image;

/** @author Tsurkin Alex
 * @version */
public interface ImageDao {

	List<Image> getImages();

	Image getImageById(int id);

	void saveImage(Image image);

	void deleteImage(int id);
}
