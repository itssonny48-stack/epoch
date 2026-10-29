package com.sonnym.epoch.model;

public class Person {
	private int id;
	private int age = 0;
	private String firstName;
	private String surname;

	public Person(int id, int age, String firstname, String surname) {
		this.id = id;
		this.age = age;
		this.firstName = firstname;
		this.surname = surname;
	}

	public int getId() {
		return id;
	}

	public int getAge() {
		return age;
	}

	public String getFullName() {
		return firstName + " " + surname;
	}

	public String getFirstName() {
		return firstName;
	}

	public String getSurname() {
		return surname;
	}

}
