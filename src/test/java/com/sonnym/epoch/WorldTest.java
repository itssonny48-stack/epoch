package com.sonnym.epoch;

import static org.junit.jupiter.api.Assertions.assertEquals;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import org.junit.jupiter.api.BeforeEach;

import com.sonnym.epoch.model.Person;

import com.sonnym.epoch.model.Settlement;

import com.sonnym.epoch.model.World;

public class WorldTest {

	private Settlement settlement1;
	private Settlement settlement2;
	private Settlement settlement3;
	private Settlement settlement4;
	private World world = new World();

	@BeforeEach
	void setUp() {
		settlement1 = new Settlement("settlement1");
		settlement2 = new Settlement("settlement2");
		settlement3 = new Settlement("settlement3");
		settlement4 = new Settlement("settlement4");

		for (int i = 0; i < 3; i++) {
			settlement1.addPerson(new Person(i, 0, "person", "" + (i + 1)));
		}
		for (int i = 3; i < 4; i++) {
			settlement2.addPerson(new Person(i, 0, "person", "" + (i + 1)));
		}
		for (int i = 4; i < 6; i++) {
			settlement3.addPerson(new Person(i, 0, "person", "" + (i + 1)));
		}
		for (int i = 6; i < 8; i++) {
			settlement4.addPerson(new Person(i, 0, "person", "" + (i + 1)));
		}
		world.addSettlement(settlement1);
		world.addSettlement(settlement2);
		world.addSettlement(settlement3);
		world.addSettlement(settlement4);

	}

	@Test
	void totalPopulationWorks() {
		assertEquals(8, world.getTotalPopulation());
		World blankWorld = new World();
		assertEquals(0, blankWorld.getTotalPopulation());
	}

	@Test
	void newWorldStartsAtYearZero() {
		World blankWorld = new World();
		assertEquals(0, blankWorld.getCurrentYear());
	}

	@Test
	void seedIsStored() {
		assertEquals(1, world.getSeed());
		World worldSeedTwenty = new World(20);
		assertEquals(20, worldSeedTwenty.getSeed());
	}

	@Test
	void sameSeedSameOutput() {
		World worldA = new World(21);
		World worldB = new World(21);
		for (int i = 0; i < 10; i++) {
			assertEquals(worldA.nextInt(100), worldB.nextInt(100));
		}
	}

	@Test
	void differentSeedDifferentOutput() {
		World worldA = new World(2);
		World worldB = new World(1);
		boolean foundDifference = false;
		for (int i = 0; i < 10; i++) {
			if (worldA.nextInt(100) != worldB.nextInt(100))
				foundDifference = true;
		}
		assertTrue(foundDifference);
	}
	
}
