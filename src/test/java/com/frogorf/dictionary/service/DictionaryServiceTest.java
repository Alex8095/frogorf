/*package com.frogorf.dictionary.service;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;

import com.frogorf.dictionary.domain.Dictionary;
import com.frogorf.dictionary.domain.DictionaryValue;

 *//** <p>
 * Integration test using the 'Spring Data' profile.
 * 
 * @see AbstractisawyouServiceTests AbstractisawyouServiceTests for more
 *      details.
 *      </p>
 * @author Tsurkin Alex */
/* @RunWith(SpringJUnit4ClassRunner.class)
 * 
 * @ContextConfiguration(locations = {
 * "classpath:WEB-INF/spring/business-context.xml" })
 * 
 * @TransactionConfiguration(transactionManager = "transactionManager") public
 * class DictionaryServiceTest {
 * 
 * @Autowired protected DictionaryService dictionaryService;
 * 
 * private static final Logger logger =
 * LoggerFactory.getLogger(DictionaryServiceTest.class);
 * 
 * @Test
 * 
 * @Transactional public void findDictionarys() { // List<Dictionary>
 * dictionaries = // this.dictionaryService.findDictionaryAll(); //
 * assertEquals(0, dictionaries.size()); // List<DictionaryValue>
 * dictionaryValues = // this.dictionaryService.findDictionaryValueAll(); //
 * assertEquals(0, dictionaryValues.size()); assertEquals(0, 0); }
 * 
 * // // @Test // public void findSingledictionary() { // dictionary dictionary1
 * = this.dictionaryService.finddictionaryById(1); //
 * assertTrue(dictionary1.getLastName().startsWith("Franklin")); // dictionary
 * dictionary10 = this.dictionaryService.finddictionaryById(10); //
 * assertEquals("Carlos", dictionary10.getFirstName()); // //
 * assertEquals(dictionary1.getPets().size(), 1); // } //
 * 
 * @Test
 * 
 * @Transactional public void insertDictionary() { List<Dictionary> dictionaries
 * = this.dictionaryService.findDictionaryAll(); int found =
 * dictionaries.size(); Dictionary dictionary = new Dictionary();
 * dictionary.setCode("code"); dictionary.setDescription("description");
 * dictionary.setLang("lang"); dictionary.setName("name");
 * this.dictionaryService.saveDictionary(dictionary); dictionaries =
 * this.dictionaryService.findDictionaryAll();
 * assertEquals("Verifying number of dictionarys after inserting a new one.",
 * found + 1, dictionaries.size()); }
 * 
 * @Test
 * 
 * @Transactional public void updateDictionary() throws Exception { Dictionary
 * dictionary = this.dictionaryService.findDictionaryById(1); String old =
 * dictionary.getName(); dictionary.setName(old + "X");
 * this.dictionaryService.saveDictionary(dictionary); dictionary =
 * this.dictionaryService.findDictionaryById(1); assertEquals(old + "X",
 * dictionary.getName()); }
 * 
 * // @Test // public void findPet() { // Collection<PetType> types =
 * this.dictionaryService.findPetTypes(); // Pet pet7 =
 * this.dictionaryService.findPetById(7); //
 * assertTrue(pet7.getName().startsWith("Samantha")); //
 * assertEquals(EntityUtils.getById(types, PetType.class, 1).getId(), //
 * pet7.getType().getId()); // assertEquals("Jean",
 * pet7.getdictionary().getFirstName()); // Pet pet6 =
 * this.dictionaryService.findPetById(6); // assertEquals("George",
 * pet6.getName()); // assertEquals(EntityUtils.getById(types, PetType.class,
 * 4).getId(), // pet6.getType().getId()); // assertEquals("Peter",
 * pet6.getdictionary().getFirstName()); // } // // @Test // public void
 * getPetTypes() { // Collection<PetType> petTypes =
 * this.dictionaryService.findPetTypes(); // // PetType petType1 =
 * EntityUtils.getById(petTypes, PetType.class, 1); // assertEquals("cat",
 * petType1.getName()); // PetType petType4 = EntityUtils.getById(petTypes,
 * PetType.class, 4); // assertEquals("snake", petType4.getName()); // } //
 * 
 * @Test
 * 
 * @Transactional public void insertDictionaryValue() { Dictionary dictionary6 =
 * this.dictionaryService.findDictionaryById(3); int found =
 * dictionary6.getDictionaryValues().size(); DictionaryValue dictionaryValue =
 * new DictionaryValue(); dictionaryValue.setName("dictionaryValue");
 * dictionary6.getDictionaryValues().add(dictionaryValue); assertEquals(found +
 * 1, dictionary6.getDictionaryValues().size()); // both storePet and
 * storedictionary are necessary to cover all ORM tools
 * this.dictionaryService.saveDictionaryValue(dictionaryValue);
 * this.dictionaryService.saveDictionary(dictionary6); dictionary6 =
 * this.dictionaryService.findDictionaryById(3); assertEquals(found + 1,
 * dictionary6.getDictionaryValues().size()); }
 * 
 * @Test
 * 
 * @Transactional public void updateDictionaryValue() throws Exception {
 * DictionaryValue dictionaryValue3 =
 * this.dictionaryService.findDictionaryValueById(3); String old =
 * dictionaryValue3.getName(); dictionaryValue3.setName(old + "X");
 * this.dictionaryService.saveDictionaryValue(dictionaryValue3);
 * dictionaryValue3 = this.dictionaryService.findDictionaryValueById(3);
 * assertEquals(old + "X", dictionaryValue3.getName()); } // // @Test // public
 * void findVets() { // Collection<Vet> vets =
 * this.dictionaryService.findVets(); // // Vet v1 = EntityUtils.getById(vets,
 * Vet.class, 2); // assertEquals("Leary", v1.getLastName()); // assertEquals(1,
 * v1.getNrOfSpecialties()); // assertEquals("radiology",
 * (v1.getSpecialties().get(0)).getName()); // Vet v2 =
 * EntityUtils.getById(vets, Vet.class, 3); // assertEquals("Douglas",
 * v2.getLastName()); // assertEquals(2, v2.getNrOfSpecialties()); //
 * assertEquals("dentistry", (v2.getSpecialties().get(0)).getName()); //
 * assertEquals("surgery", (v2.getSpecialties().get(1)).getName()); // } // //
 * 
 * @Test // @Transactional // public void insertVisit() { // Pet pet7 =
 * this.dictionaryService.findPetById(7); // int found =
 * pet7.getVisits().size(); // Visit visit = new Visit(); //
 * pet7.addVisit(visit); // visit.setDescription("test"); // // both storeVisit
 * and storePet are necessary to cover all ORM tools //
 * this.dictionaryService.saveVisit(visit); //
 * this.dictionaryService.savePet(pet7); // pet7 =
 * this.dictionaryService.findPetById(7); // assertEquals(found + 1,
 * pet7.getVisits().size()); // }
 * 
 * // Dictionary dictionary = new Dictionary(); // dictionary.setCode("code");
 * // dictionary.setDescription("description"); // dictionary.setLang("lang");
 * // dictionary.setName("name"); //
 * this.dictionaryService.saveDictionary(dictionary); // //
 * System.out.println(dictionary.toString()); // // DictionaryValue
 * dictionaryValue1 = new DictionaryValue(); //
 * dictionaryValue1.setCode("codeDictionaryValue"); //
 * dictionaryValue1.setDescription("descriptionDictionaryValue"); //
 * dictionaryValue1.setLang("langDictionaryValue"); //
 * dictionaryValue1.setName("nameDictionaryValue"); //
 * this.dictionaryService.saveDictionaryValue(dictionaryValue1); // //
 * System.out.println(dictionaryValue1.toString()); // // DictionaryValue
 * dictionaryValue = new DictionaryValue(); //
 * dictionaryValue.setCode("codeDictionaryValue 2"); //
 * dictionaryValue.setDescription("descriptionDictionaryValue 2"); //
 * dictionaryValue.setLang("langDictionaryValue 2"); //
 * dictionaryValue.setName("nameDictionaryValue 2"); //
 * dictionaryValue.setDictionary(dictionary); //
 * dictionaryValue.setDictionaryValue(dictionaryValue1); //
 * this.dictionaryService.saveDictionaryValue(dictionaryValue); // //
 * System.out.println(dictionaryValue.toString()); } */