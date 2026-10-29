package com.sonnym.epoch.model;

import java.util.ArrayList;
import java.util.List;

public class Settlement {
	private String name;
	private List<Person> people;

	public Settlement(String name) {
		this.name = name;
		this.people = new ArrayList<>();
	}

	public String getName() {
		return name;
	}

	public void addPerson(Person person) {
		people.add(person);
	}

	public boolean removePerson(Person person) {
		return people.remove(person);
	}

	public int getPopulation() {
		return people.size();
	}

	public List<Person> getPeople() {
		return List.copyOf(people);
	}

	public double getAverageAge() {
		int total = 0;
		if (people.size() != 0) {
			for (Person person : people) {
				total = total + person.getAge();
			}
			double average = (double) total / people.size();
			return average;
		}
		return 0;
	}

}
