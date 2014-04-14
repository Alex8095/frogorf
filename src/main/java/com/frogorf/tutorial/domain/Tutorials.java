/**
 * 
 */
package com.frogorf.tutorial.domain;

import java.io.Serializable;
import java.util.List;

/** @author Tsurkin Alex
 * @version */
public class Tutorials implements Serializable {

	private List<Tutorial> tutorials;

	public Tutorials() {
	}

	public Tutorials(List<Tutorial> tutorials) {
		this.tutorials = tutorials;
	}

	/** @return the tutorials */
	public List<Tutorial> getTutorials() {
		return tutorials;
	}

	/** @param tutorials the tutorials to set */
	public void setTutorials(List<Tutorial> tutorials) {
		this.tutorials = tutorials;
	}

}
