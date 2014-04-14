/**
 * 
 */
package com.frogorf.files.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.frogorf.domain.BaseEntity;

/** @author Tsurkin Alex
 * @version */
@Entity
@Table(name = "image")
public class Image extends BaseEntity implements Serializable {

	@Column
	private String name;
	@OneToOne
	@JoinColumn(name = "view_id")
	private File viewFile;
	@OneToOne
	@JoinColumn(name = "image_id")
	private File imageFile;

	public Image() {
	}

	/** @param name
	 * @param viewFileId
	 * @param imageFileId */
	public Image(Integer id, String name, File viewFile, File imageFile) {
		this.id = id;
		this.name = name;
		this.viewFile = viewFile;
		this.imageFile = imageFile;
	}

	/** @param name
	 * @param viewFileId
	 * @param imageFileId */
	public Image(String name, File viewFile, File imageFile) {
		super();
		this.name = name;
		this.viewFile = viewFile;
		this.imageFile = imageFile;
	}

	/** @return the name */
	public String getName() {
		return name;
	}

	/** @param name the name to set */
	public void setName(String name) {
		this.name = name;
	}

	/** @return the viewFile */
	public File getViewFile() {
		return viewFile;
	}

	/** @param viewFile the viewFile to set */
	public void setViewFile(File viewFile) {
		this.viewFile = viewFile;
	}

	/** @return the imageFile */
	public File getImageFile() {
		return imageFile;
	}

	/** @param imageFile the imageFile to set */
	public void setImageFile(File imageFile) {
		this.imageFile = imageFile;
	}

	/* @see java.lang.Object#equals(java.lang.Object) */
	@Override
	public boolean equals(Object obj) {
		boolean result = false;
		if ((obj instanceof Image)) {
			Image image = (Image) obj;
			if (image.getId() == this.id && image.getName() == image.getName() && image.getImageFile() == this.imageFile && image.getViewFile() == this.imageFile)
				result = true;
		}
		return result;
	}
}
