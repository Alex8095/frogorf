/**
 * 
 */
package com.frogorf.files.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.frogorf.files.dao.ImageDao;
import com.frogorf.files.domain.File;
import com.frogorf.files.domain.Image;
import com.frogorf.files.service.FileService;
import com.frogorf.files.service.ImageService;

/** @author Tsurkin Alex
 * @version */
@Service("imageService")
public class ImageServiceImpl implements ImageService {

	@Autowired
	private ImageDao imageDao;

	@Autowired
	private FileService fileService;

	/* @see com.frogorf.files.service.ImageService#createImage(java.lang.String,
	 * java.lang.String, byte[]) */
	@Override
	public Image createImage(String name, String type, byte[] blob) {
		File viewFile = new File(type, blob.length, blob);
		fileService.saveFile(viewFile);
		File imageFile = new File(type, blob.length, blob);
		fileService.saveFile(imageFile);
		Image image = new Image(name, viewFile, imageFile);
		saveImage(image);
		return image;
	}

	/* @see com.frogorf.files.dao.ImageDao#getImages() */
	@Override
	@Transactional
	public List<Image> getImages() {
		return imageDao.getImages();
	}

	/* @see com.frogorf.files.service.ImageService#getImageById(int) */
	@Override
	@Transactional
	public Image getImageById(int id) {
		return imageDao.getImageById(id);
	}

	/* @see
	 * com.frogorf.files.service.ImageService#saveImage(com.frogorf.files.domain
	 * .Image) */
	@Override
	public void saveImage(Image image) {
		imageDao.saveImage(image);
	}

	/* @see com.frogorf.files.service.ImageService#deleteImage(int) */
	@Override
	@Transactional
	public void deleteImage(int id) {
		imageDao.deleteImage(id);
	}
}
