/**
 * 
 */
package com.frogorf.files.dao.impl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.frogorf.files.dao.ImageDao;
import com.frogorf.files.domain.Image;

/** @author Tsurkin Alex
 * @version */
@Repository("imageDao")
public class ImageDaoImpl implements ImageDao {

	@Autowired
	private SessionFactory sessionFactory;

	/* @see com.frogorf.files.dao.ImageDao#getImages() */
	@Override
	public List<Image> getImages() {
		return sessionFactory.getCurrentSession().createQuery("from Image").list();
	}

	/* @see com.frogorf.files.dao.ImageDao#getImageById(int) */
	@Override
	public Image getImageById(int id) {
		return (Image) sessionFactory.getCurrentSession().get(Image.class, id);
	}

	/* @see
	 * com.frogorf.files.dao.ImageDao#saveImage(com.frogorf.files.domain.Image) */
	@Override
	public void saveImage(Image image) {
		sessionFactory.getCurrentSession().saveOrUpdate(image);
	}

	/* @see com.frogorf.files.dao.ImageDao#deleteImage(int) */
	@Override
	public void deleteImage(int id) {
		sessionFactory.getCurrentSession().delete(getImageById(id));
	}

}
