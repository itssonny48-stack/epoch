package com.sonnym.epoch;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import com.sonnym.epoch.model.Person;

public class PersonTest {

	@Test
	void newPersonAge() {
		Person person1 = new Person(1, 30, "sonny", "mooney");
		int age = person1.getAge();
		assertEquals(30, age);
	}

	@Test
	void fullName() {
		Person person1 = new Person(1, 30, "sonny", "mooney");
		String fullName = person1.getFullName();
		assertEquals("sonny mooney", fullName);
	}

	@Test
	void idStored() {
		Person person1 = new Person(1, 30, "sonny", "mooney");
		int id = person1.getId();
		assertEquals(id, 1);
	}

}
