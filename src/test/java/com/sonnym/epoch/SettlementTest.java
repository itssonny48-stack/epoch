package com.sonnym.epoch;

import static org.junit.jupiter.api.Assertions.assertEquals;

import static org.junit.jupiter.api.Assertions.assertFalse;

import org.junit.jupiter.api.Test;

import org.junit.jupiter.api.BeforeEach;

import com.sonnym.epoch.model.Person;

import com.sonnym.epoch.model.Settlement;

public class SettlementTest {
	
	private Person person1;
	private Settlement settlement1;
	
	@BeforeEach
	void setUp() {
		person1 = new Person(1, 0, "sonny", "mooney");
		settlement1 = new Settlement("minetown");
	}
	
	@Test
	void newPopulationIsZero() {
		
		int population = settlement1.getPopulation();
		assertEquals(0, population);// checks if a new settlement starts at 0
	}// other values were also tested

	@Test
	void addPersonUpdates() {
		settlement1.addPerson(person1);
		int population = settlement1.getPopulation();
		assertEquals(1, population);
	}

	@Test
	void addAndRemovePopulation() {
		settlement1.addPerson(person1);
		int population = settlement1.getPopulation();
		assertEquals(1, population);// checks if adding someone worked
		settlement1.removePerson(person1);
		population = settlement1.getPopulation();
		assertEquals(0, population);// checks if removal was successful
	}// other values tested

	@Test
	void removingUnknownPersonReturnsFalse() {
		Person person2 = new Person(2, 0, "ash", "ketchum");
		settlement1.addPerson(person1);
		boolean removed = settlement1.removePerson(person2);
		assertFalse(removed);
	}// tested with true
	
	@Test 
	void averageAgeWorks() {
		assertEquals(0,settlement1.getAverageAge());
		Person person2 = new Person(2, 15, "person", "2");
		Person person3 = new Person(3, 20, "person", "3");
		Person person4 = new Person(4, 30, "person", "4");
		Person person5 = new Person(5, 51, "person", "5");
		settlement1.addPerson(person1);
		settlement1.addPerson(person2);
		settlement1.addPerson(person3);
		settlement1.addPerson(person4);
		settlement1.addPerson(person5);
		assertEquals(23.2,settlement1.getAverageAge(),0.001);
		
	}

}
