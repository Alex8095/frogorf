/**
 * 
 */
package com.frogorf.localize.service;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.frogorf.localize.model.Model;
import com.frogorf.localize.model.ModelLocale;
import com.frogorf.service.AbstractBaseServiceTest;

/** @author Tsurkin Alex
 * @version */
public class ModelServiceTest extends AbstractBaseServiceTest {

	@Autowired
	protected ModelService modelService;

	/** Test method for
	 * {@link com.frogorf.localize.service.ModelService#findModelAll()}. */
	@Test
	public void testFindModelAll() {

		List<Model> models = modelService.findModelAll();
		int found = models.size();
		Model model = new Model();
		model.setCode("code 2");
		model.setName("name 2");

		modelService.saveModel(model);
		models = modelService.findModelAll();
		assertEquals("Verifying number of  after inserting a new one.", found + 1, models.size());
	}

	/** Test method for
	 * {@link com.frogorf.localize.service.ModelService#saveModel(com.frogorf.localize.model.Model)}
	 * . */
	@Test
	public void testSaveModel() {
		Model model = new Model();
		model.setCode("code");
		model.setName("name");

		model.getModelLocale().put("ru", new ModelLocale("title ru", "description ru"));
		model.getModelLocale().put("en", new ModelLocale("title en", "description en"));
		modelService.saveModel(model);

		List<Model> models = modelService.findModelAll();

		assertEquals("title ru", models.get(1).getModelLocale().get("ru").getTitle());
		assertEquals("description ru", models.get(1).getModelLocale().get("ru").getDescription());

		assertEquals("title ru", models.get(1).getCurrentModelLocale().getTitle());
		assertEquals("description ru", models.get(1).getCurrentModelLocale().getDescription());
	}

}
