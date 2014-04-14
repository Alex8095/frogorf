/**
 * 
 */
package com.frogorf.files.domain;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Lob;
import javax.persistence.Table;

import com.frogorf.domain.BaseEntity;

/** @author Tsurkin Alex
 * @version */
@Entity
@Table(name = "file")
public class File extends BaseEntity {

	@Column
	private String type;
	@Column
	private Integer size;
	@Basic(fetch = FetchType.LAZY)
	@Lob
	@Column(name = "file")
	private byte[] blob;

	/** @param type
	 * @param size
	 * @param blob */
	public File(Integer id, String type, Integer size, byte[] blob) {
		this.id = id;
		this.type = type;
		this.size = size;
		this.blob = blob;
	}

	public File(String type, Integer size, byte[] blob) {
		this.type = type;
		this.size = size;
		this.blob = blob;
	}

	/** @return the type */
	public String getType() {
		return type;
	}

	/** @param type the type to set */
	public void setType(String type) {
		this.type = type;
	}

	/** @return the size */
	public Integer getSize() {
		return size;
	}

	/** @param size the size to set */
	public void setSize(Integer size) {
		this.size = size;
	}

	/** @return the blob */
	public byte[] getBlob() {
		return blob;
	}

	/** @param blob the blob to set */
	public void setBlob(byte[] blob) {
		this.blob = blob;
	}

}
