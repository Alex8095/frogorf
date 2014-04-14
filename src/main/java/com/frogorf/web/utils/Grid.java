/**
 * 
 */
package com.frogorf.web.utils;

import java.util.List;

/** @author Tsurkin Alex
 * @version */
public class Grid<T> {

	private int totalPages;

	private int currentPage;

	private long totalRecords;

	private List<T> data;

	public int getTotalPages() {
		return totalPages;
	}

	public void setTotalPages(int totalPages) {
		this.totalPages = totalPages;
	}

	public int getCurrentPage() {
		return currentPage;
	}

	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}

	public long getTotalRecords() {
		return totalRecords;
	}

	public void setTotalRecords(long totalRecords) {
		this.totalRecords = totalRecords;
	}

	/** @return the data */
	public List<T> getData() {
		return data;
	}

	/** @param data the data to set */
	public void setData(List<T> data) {
		this.data = data;
	}

}
